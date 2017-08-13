package com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables;

import android.provider.BaseColumns;

/**
 * Created by chwtlk on 2017-08-13.
 */

public class ArtistTable {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ArtistTable() {}

    /* Inner class that defines the table contents */
    public static class ArtistTableInstance implements BaseColumns {
        public static final String TABLE_NAME = "ArtistTable";
        public static final String COLUMN_NAME_NAME = "name";
        public static final byte[] COLUMN_NAME_PHOTO = null;
        public static final String COLUMN_NAME_ABOUT = "about";
    }
}
