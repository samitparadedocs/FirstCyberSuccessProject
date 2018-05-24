package com.cybersuccess.demo.firstcybersuccessproject.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samit on 5/22/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contacts_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//create contact table;
        Log.d("Oncreate DatabaseHelper", "" + Contact.CREATE_TABLE);
        sqLiteDatabase.execSQL(Contact.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Contact.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    public long insertContact(String contactName, String contactNumber) {

        // get writable database as we want to write data
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Contact.COLUMN_NAME, contactName);
        values.put(Contact.COLUMN_NUMBER, contactNumber);

        // insert row
        long id = db.insert(Contact.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Contact getContact(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Contact.TABLE_NAME,
                new String[]{Contact.COLUMN_ID, Contact.COLUMN_NAME, Contact.COLUMN_NUMBER, Contact.COLUMN_TIMESTAMP},
                Contact.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        int id_primary = cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAME));
        String number = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NUMBER));
        String timestap = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TIMESTAMP));
        Contact contact = new Contact(id_primary, name, number, timestap);
        // close the db connection
        cursor.close();

        return contact;
    }

    public List<Contact> getAllNotes() {
        List<Contact> contacts = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Contact.TABLE_NAME + " ORDER BY " +
                Contact.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_ID)));
                contact.setName(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAME)));
                contact.setContactNumber(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NUMBER)));
                contact.setTimeStamp(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TIMESTAMP)));

                contacts.add(contact);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return contacts;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Contact.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contact.COLUMN_NAME, contact.getName());
        values.put(Contact.COLUMN_NUMBER, contact.getContactNumber());

        // updating row
        return db.update(Contact.TABLE_NAME, values, Contact.COLUMN_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void deleteNote(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Contact.TABLE_NAME, Contact.COLUMN_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }


}
