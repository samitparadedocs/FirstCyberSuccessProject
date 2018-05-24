package com.cybersuccess.demo.firstcybersuccessproject.sqlite;

/**
 * Created by Samit on 5/22/2018.
 */

public class Contact {
    public static final String TABLE_NAME = "Contact";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUMBER = "contact_number";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    private int id;
    private String name;
    private String contactNumber;
    private String timeStamp;

    // Create table SQL query
    public static final String CREATE_TABLE =

            " Create Table "+TABLE_NAME+" ("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COLUMN_NAME+" TEXT,"
            +COLUMN_NUMBER+" TEXT, "
            + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ")";

    public Contact(){}
    public Contact(int id, String name, String contactNumber, String timeStamp) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
