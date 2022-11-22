package com.example.sqliteassignmentno3;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class MyDBClass {
    private static final String IMAGE_ID = "id";
    private final Context context;
    public static final String Image = "image";
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase muDB;
    private static final String DATABASE_NAME = "ImageInfo";
    private static final int DATABASE_VERSION = 1;
    private static final String IMAGE_TABLE = "ImagesTable";
    private static final String CREATE_IMAGE_TABLE = "CREATE TABLE " + IMAGE_TABLE + "(" + IMAGE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + Image + "BLOB NOT NULL);";

    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_IMAGE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + IMAGE_TABLE);
            onCreate(db);
        }
    }

    public void Reset() {
        myDBHelper.onUpgrade(this.muDB, 1, 1);
    }

    public MyDBClass(Context context) {
        this.context = context;
        myDBHelper = new DatabaseHelper(context);
    }

    public MyDBClass Open() throws SQLException {
        muDB = myDBHelper.getWritableDatabase();
        return this;
    }

    public void Close() {
        myDBHelper.close();
    }

    public void insertImage(byte[] imageByte) {
        ContentValues cv = new ContentValues();
        cv.put(Image, imageByte);
        muDB.insert(IMAGE_TABLE, null, cv);
    }

    public byte[] reteriveImageFromDB() {
        Cursor cursor = muDB.query(true, IMAGE_TABLE, new String[]{Image,}, null, null, null, null, IMAGE_ID + "DESC", "1");
        if (cursor.moveToFirst()) {

           byte[] blob = cursor.getBlob(cursor.getColumnIndexOrThrow(Image));
            cursor.close();
            return blob;
        }
        cursor.close();
        return null;
    }
}
