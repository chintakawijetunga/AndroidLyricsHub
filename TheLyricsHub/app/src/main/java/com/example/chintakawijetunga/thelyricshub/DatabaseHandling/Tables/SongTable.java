package com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables;

import android.provider.BaseColumns;

/**
 * Created by chwtlk on 2017-08-13.
 */

public class SongTable {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SongTable() {}

    /* Inner class that defines the table contents */
    public static class SongTableInstance implements BaseColumns {
        public static final String TABLE_NAME = "SongTable";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SONGV = null;
        public static final byte[] COLUMN_NAME_SONGP = null;
        public static final int COLUMN_NAME_ARTISTID = 0;
    }
}


/*

you have to use "blob" to store image.

ex: to store a image in to db

public void insertImg(int id , Bitmap img ) {


    byte[] data = getBitmapAsByteArray(img); // this is a function

    insertStatement_logo.bindLong(1, id);
    insertStatement_logo.bindBlob(2, data);

    insertStatement_logo.executeInsert();
    insertStatement_logo.clearBindings() ;

}

 public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    bitmap.compress(CompressFormat.PNG, 0, outputStream);
    return outputStream.toByteArray();
}
to retrieve a image from db

public Bitmap getImage(int i){

    String qu = "select img  from table where feedid=" + i ;
    Cursor cur = db.rawQuery(qu, null);

    if (cur.moveToFirst()){
        byte[] imgByte = cur.getBlob(0);
        cur.close();
        return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
    }
    if (cur != null && !cur.isClosed()) {
        cur.close();
    }

    return null ;
}

 */