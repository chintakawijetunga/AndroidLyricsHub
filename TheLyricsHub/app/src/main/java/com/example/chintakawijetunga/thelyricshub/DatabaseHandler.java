package com.example.chintakawijetunga.thelyricshub;

/**
 * Created by Chintaka Wijetunga on 12-08-2017.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class DatabaseHandler {
    SQLiteDatabase db;
    public void CreateDB()
    {
        db=openOrCreateDatabase("StudentDB", null, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");
    }
}
