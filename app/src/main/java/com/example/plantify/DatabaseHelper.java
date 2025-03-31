package com.example.plantify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "users";

    private static final String COLUMN_ID = "sr_no";
    private static final String COLUMN_FNAME = "fname";
    private static final String COLUMN_LNAME = "lname";
    private static final String COLUMN_PHONE = "phone_no";
    private static final String COLUMN_EMAIL = "email_id";
    private static final String COLUMN_PASSWORD = "password";

    // Table Creation Query
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FNAME + " TEXT, " +
                    COLUMN_LNAME + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_EMAIL + " INTEGER, " +
                    COLUMN_PASSWORD + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert User Data
    public boolean insertUser(String fname, String lname, String phone, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FNAME, fname);
        contentValues.put(COLUMN_LNAME, lname);
        contentValues.put(COLUMN_PHONE, phone);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Fetch all users (Optional)
    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
