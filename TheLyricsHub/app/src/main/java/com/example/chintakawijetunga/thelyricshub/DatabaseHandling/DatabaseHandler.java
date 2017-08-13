package com.example.chintakawijetunga.thelyricshub.DatabaseHandling;

/**
 * Created by Chintaka Wijetunga on 12-08-2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables.ArtistTable.ArtistTableInstance;
import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables.SongTable.SongTableInstance;


public class DatabaseHandler extends SQLiteOpenHelper{
    private static final String SQL_CREATE_ARTIST =
            "CREATE TABLE IF NOT EXISTS" + ArtistTableInstance.TABLE_NAME + " (" +
                    ArtistTableInstance._ID + " INTEGER PRIMARY KEY," +
                    ArtistTableInstance.COLUMN_NAME_NAME+ " TEXT," +
                    ArtistTableInstance.COLUMN_NAME_PHOTO+ " BLOB," +
                    ArtistTableInstance.COLUMN_NAME_ABOUT + " TEXT)";

    private static final String SQL_CREATE_SONG =
            "CREATE TABLE IF NOT EXISTS" + SongTableInstance.TABLE_NAME + " (" +
                    SongTableInstance._ID + " INTEGER PRIMARY KEY," +
                    SongTableInstance.COLUMN_NAME_NAME+ " TEXT," +
                    SongTableInstance.COLUMN_NAME_ARTISTID+ " NUMBER," +
                    SongTableInstance.COLUMN_NAME_SONGP+ " BLOB," +
                    SongTableInstance.COLUMN_NAME_SONGV + " TEXT)";

    private static final String SQL_DELETE_SONG =
            "DROP TABLE IF EXISTS " + ArtistTableInstance.TABLE_NAME;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SongTableInstance.TABLE_NAME;


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TheLyricsHub.db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ARTIST);
        db.execSQL(SQL_CREATE_SONG);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_SONG);
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
