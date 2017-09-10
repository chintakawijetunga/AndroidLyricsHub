package com.example.chintakawijetunga.thelyricshub.DatabaseHandling;

/**
 * Created by Chintaka Wijetunga on 12-08-2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables.ArtistTable.ArtistTableInstance;
import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables.SongTable.SongTableInstance;

import java.util.ArrayList;
import java.util.List;



public class DatabaseHandler extends SQLiteOpenHelper{
    private static final String SQL_CREATE_ARTIST =
            "CREATE TABLE " + ArtistTableInstance.TABLE_NAME + " (" +
                    ArtistTableInstance._ID + " INTEGER PRIMARY KEY," +
                    ArtistTableInstance.COLUMN_NAME_NAME+ " TEXT," +
                  //  ArtistTableInstance.COLUMN_NAME_PHOTO+ " BLOB," +
                    ArtistTableInstance.COLUMN_NAME_ABOUT + " TEXT)";

    private static final String SQL_CREATE_SONG =
            "CREATE TABLE " + SongTableInstance.TABLE_NAME + " (" +
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

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ARTIST);
        db.execSQL(SQL_CREATE_SONG);
    }
    @Override
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

    public void addArtistsInfo(String artists, String about){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ArtistTableInstance.COLUMN_NAME_NAME, artists);
        values.put(ArtistTableInstance.COLUMN_NAME_ABOUT, about);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ArtistTableInstance.TABLE_NAME, null, values);
    }

    public void readInfo()
    {
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                ArtistTableInstance._ID,
                ArtistTableInstance.COLUMN_NAME_NAME,
                ArtistTableInstance.COLUMN_NAME_ABOUT
        };

        // Filter results WHERE "username" = 'SLIIT User'
       // String selection = UsersMaster.Users._ID + " = ?";
       // String[] selectionArgs = { "SLIIT User" };

        // How you want the results sorted in the resulting Cursor
        //String sortOrder = UsersMaster.Users.COLUMN_NAME_USERNAME + " DESC";

        Cursor cursor = db.query(
                ArtistTableInstance.TABLE_NAME,    // The table to query
                projection,                      // The columns to return
                null,                            // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                            // don't group the rows
                null,                            // don't filter by row groups
                null                        // The sort order
        ); //no where statement or grouping values are set.

        List artists = new ArrayList<>();
        List abouts = new ArrayList<>();

        while(cursor.moveToNext()) {
            String artistName = cursor.getString( cursor.getColumnIndexOrThrow(ArtistTableInstance.COLUMN_NAME_NAME));
            String aboutArtist = cursor.getString( cursor.getColumnIndexOrThrow(ArtistTableInstance.COLUMN_NAME_ABOUT));
            artists.add(artistName);
            abouts.add(aboutArtist);
        }
        cursor.close();
    }

}
