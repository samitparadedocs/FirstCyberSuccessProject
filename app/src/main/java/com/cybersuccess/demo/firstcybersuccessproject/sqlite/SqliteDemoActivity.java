package com.cybersuccess.demo.firstcybersuccessproject.sqlite;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.R;

import java.util.ArrayList;

public class SqliteDemoActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    ListView listView;
    ContactAdapter contactAdapter;
    ArrayList<Contact> contactList = new ArrayList<>();
    EditText nameSql, numberSql;
    Button addSql, displaySql;

    long previousInsertedId = 0;
    Contact contactTobeEdited;
    int selectedPostionFromList = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        nameSql = findViewById(R.id.nameSql);
        numberSql = findViewById(R.id.numberSql);
        addSql = findViewById(R.id.addDataSql);
        displaySql = findViewById(R.id.displaySql);


        listView = findViewById(R.id.contactList);
        dbHelper = new DatabaseHelper(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                showAddContacteDialog(false, null, -1);
            }
        });

        addSql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String name="'samit'";
                String qury=" select * from xyz where first_name='"+name+"'";*/
                if (addSql.getText().equals("Add Data")) {
                    previousInsertedId = dbHelper.insertContact(nameSql.getText().toString(), numberSql.getText().toString());
                } else if (addSql.getText().equals("Edit Contact")) {

                    SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(Contact.COLUMN_NAME, nameSql.getText().toString());
                    values.put(Contact.COLUMN_NUMBER, numberSql.getText().toString());

                    // updating row
                    long id = sqLiteDatabase.update(Contact.TABLE_NAME, values,
                            Contact.COLUMN_ID + " = ?",
                            new String[]{String.valueOf(contactTobeEdited.getId())});
                    sqLiteDatabase.close();
                   /* Contact CurrentlyUpdatedContact = dbHelper.getContact(id);
                   contactList.add(CurrentlyUpdatedContact);
                    contactList.remove(selectedPostionFromList);*/
                    contactList.clear();
                    contactAdapter.notifyDataSetChanged();

                    contactList = dbHelper.getAllContacts();
                    contactAdapter.notifyDataSetChanged();
                }
                nameSql.setText("");
                numberSql.setText("");



               /* // get writable database as we want to write data
                SQLiteDatabase sqlitedb = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                // `id` and `timestamp` will be inserted automatically.
                // no need to add them
                values.put(Contact.COLUMN_NUMBER, numberSql.getText().toString());
                values.put(Contact.COLUMN_NAME, nameSql.getText().toString());

                // insert row
                long id = sqlitedb.insert(Contact.TABLE_NAME, null, values);

                // close dbHelper connection
                previousInsertedId = id;
                sqlitedb.close();
*/
            }
        });
        displaySql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getContact(previousInsertedId);

                /*SQLiteDatabase readbledb = dbHelper.getReadableDatabase();

                Cursor cursor = readbledb.query(Contact.TABLE_NAME,
                        new String[]{Contact.COLUMN_ID, Contact.COLUMN_NAME, Contact.COLUMN_NUMBER, Contact.COLUMN_TIMESTAMP},
                        Contact.COLUMN_ID + "=?",
                        new String[]{String.valueOf(previousInsertedId)}, null, null, null, null);

                if (cursor != null) {
                    cursor.moveToFirst();
                    // prepare note object
                    int id_primary = cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_ID));
                    String name = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NUMBER));
                    String timestap = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TIMESTAMP));

                    Contact contact = new Contact(id_primary, name, number, timestap);
                    contactList.add(contact);
                    contactAdapter.notifyDataSetChanged();
                    // close the dbHelper connection
                    cursor.close();

                } else {
                    Toast.makeText(SqliteDemoActivity.this, "No result found", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
        contactList = dbHelper.getAllContacts();
        contactAdapter = new ContactAdapter(contactList, this);
        listView.setAdapter(contactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //below code for update sqlite data for selected item from list
                /*Toast.makeText(SqliteDemoActivity.this, "postion clicked" + i, Toast.LENGTH_SHORT).show();
                contactTobeEdited = contactList.get(i);
                nameSql.setText(contactTobeEdited.getName());
                numberSql.setText(contactTobeEdited.getContactNumber());
                addSql.setText("Edit Contact");
                selectedPostionFromList = i;*/

             Contact   contactTobedeted = contactList.get(i);
                dbHelper.deleteContact(contactTobedeted);
                contactList.remove(i);
                contactAdapter.notifyDataSetChanged();


            }
        });


    }


    /**
     * Inserting new Contact in dbHelper
     * and refreshing the list
     */
    private void createContact(String contactName, String contactNumber) {

        // inserting note in dbHelper and getting
        // newly inserted note id
        long id = dbHelper.insertContact(contactName, contactNumber);

        // get the newly inserted note from dbHelper
        Contact n = dbHelper.getContact(id);

        if (n != null) {
            // adding new note to array list at 0 position
            contactList.add(0, n);

            // refreshing the list
            contactAdapter.notifyDataSetChanged();

            // toggleEmptyNotes();
        }
    }

    /**
     * Updating Contact in dbHelper and updating
     * item in the list by its position
     */
    private void updateNote(String note, int position) {
        Contact n = contactList.get(position);
        // updating note text
        n.setName(note);

        // updating note in dbHelper
        dbHelper.updateContact(n);

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
        // deleting the note from dbHelper
        dbHelper.deleteContact(contactList.get(position));

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
                    //updateContact(inputNote.getText().toString(), position);
                } else {
                    // create new note
                    createContact(inputContactName.getText().toString(), inputContactNumber.getText().toString());
                }
            }
        });
    }


}
