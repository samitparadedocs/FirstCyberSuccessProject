package com.cybersuccess.demo.firstcybersuccessproject.sqlite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.R;

import java.util.ArrayList;

public class SqliteDemoActivity extends AppCompatActivity {
    private DatabaseHelper db;

    ListView listView;
    ContactAdapter contactAdapter;
    ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        listView = findViewById(R.id.contactList);
        contactAdapter = new ContactAdapter(contactList, this);
        listView.setAdapter(contactAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               showAddContacteDialog(false, null, -1);
            }
        });
        db = new DatabaseHelper(this);
    }


    /**
     * Inserting new Contact in db
     * and refreshing the list
     */
    private void createContact(String contactName, String contactNumber) {

        // inserting note in db and getting
        // newly inserted note id
        long id = db.insertContact(contactName,contactNumber);

        // get the newly inserted note from db
        Contact n = db.getContact(id);

        if (n != null) {
            // adding new note to array list at 0 position
            contactList.add(0, n);

            // refreshing the list
             contactAdapter.notifyDataSetChanged();

            // toggleEmptyNotes();
        }
    }

    /**
     * Updating Contact in db and updating
     * item in the list by its position
     */
    private void updateNote(String note, int position) {
        Contact n = contactList.get(position);
        // updating note text
        n.setName(note);

        // updating note in db
        db.updateNote(n);

        // refreshing the list
        contactList.set(position, n);
        /*mAdapter.notifyItemChanged(position);

        toggleEmptyNotes();*/
    }

    /**
     * Deleting note from SQLite and removing the
     * item from the list by its position
     */
    private void deleteNote(int position) {
        // deleting the note from db
        db.deleteNote(contactList.get(position));

        // removing the note from the list
        contactList.remove(position);
        /*mAdapter.notifyItemRemoved(position);

        toggleEmptyNotes();
   */
    }


    /**
     * Opens dialog with Edit - Delete options
     * Edit - 0
     * Delete - 0
     */
    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showAddContacteDialog(true, contactList.get(position), position);
                } else {
                    deleteNote(position);
                }
            }
        });
        builder.show();
    }

    /**
     * Shows alert dialog with EditText options to enter / edit
     * a note.
     * when shouldUpdate=true, it automatically displays old note and changes the
     * button text to UPDATE
     */
    private void showAddContacteDialog(final boolean shouldUpdate, final Contact contact, final int position) {

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.note_dialog, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(SqliteDemoActivity.this);
        alertDialogBuilderUserInput.setView(view);

        final EditText inputContactName = view.findViewById(R.id.contact_name);
        final EditText inputContactNumber = view.findViewById(R.id.contactNumber);
        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        dialogTitle.setText(!shouldUpdate ? "New Contact" : "Update Contact");

        if (shouldUpdate && contact != null) {
            inputContactName.setText(contact.getName());
        }
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when no text is entered
                if (TextUtils.isEmpty(inputContactName.getText().toString())) {
                    Toast.makeText(SqliteDemoActivity.this, "Enter note!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }

                // check if user updating note
                if (shouldUpdate && contact != null) {
                    // update note by it's id
                    //updateNote(inputNote.getText().toString(), position);
                } else {
                    // create new note
                    createContact(inputContactName.getText().toString(),inputContactNumber.getText().toString());
                }
            }
        });
    }


}
