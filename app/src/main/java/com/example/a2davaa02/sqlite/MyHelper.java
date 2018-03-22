package com.example.a2davaa02.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

/**
 * Created by 2davaa02 on 21/03/2018.
 */

public class MyHelper extends SQLiteOpenHelper {
    static final int VERSION = 2;
    static final String DATABASE_NAME = "TestDB";

    public MyHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL ("CREATE TABLE IF NOT EXISTS Songs (Id INTEGER PRIMARY KEY, Title VARCHAR(255), Artist VARCHAR(255), Year LONG)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS Songs");
        onCreate(db);
    }
    public long insertRecord(String Title,String Artist,Long Year)
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement
                ("INSERT INTO Songs(Title,Artist,Year) VALUES (?, ?, ?)");
        stmt.bindString (1, Title);
        stmt.bindString (2, Artist);
        stmt.bindLong (3, Year);
        long id = stmt.executeInsert();
        return id;
    }
   public Song findSong(Integer ID)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery ("SELECT * FROM Songs WHERE Id=?",
               new String[]{Integer.toString(ID)});

        cursor.moveToFirst();
        Song s = new Song(cursor.getString(cursor.getColumnIndex("Title")),
                        cursor.getString(cursor.getColumnIndex("Artist")),
                        cursor.getLong(cursor.getColumnIndex("Year")));
        return s;
    }




}
