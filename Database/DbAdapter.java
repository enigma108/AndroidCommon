package com.example.mapproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class DbAdapter {

    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE = "marker";
    private static final int DATABASE_VERSION = 1;

    private static final String KEY_TITLE = "title";
    private static final String KEY_LAT = "latitude";
    private static final String KEY_LNG = "longitude";
    private static final String KEY_MARKID = "mark_id";
    private static final String KEY_ROWID = "_id";

    private DatabaseHelper mDbHelper;

    private SQLiteDatabase mDb;

    private static final String DATABASE_CREATE = "create table "
            + DATABASE_TABLE + " (" + KEY_ROWID
            + " integer primary key autoincrement, " + KEY_MARKID
            + " text not null, " + KEY_TITLE + " text not null, " + KEY_LAT
            + " double not null, " + KEY_LNG + " double not null);";

    private final Context mCtx;

    public DbAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public DbAdapter open() throws SQLException {

        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public long createMarker(String markId, String title, double lat, double lng) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_MARKID, markId);
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_LAT, lat);
        initialValues.put(KEY_LNG, lng);

        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteMarker(String markId) {

        return mDb.delete(DATABASE_TABLE, KEY_MARKID + " = " + "'" + markId + "'", null) > 0;
    }

    public Cursor fetchAllMarkers() {

        return mDb.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_MARKID, KEY_TITLE,
                KEY_LAT, KEY_LNG }, null, null, null, null, null);
    }

    public Cursor fetchMarker(String markId) {

        Cursor mCursor = mDb.query(true, DATABASE_TABLE, new String[] {
                KEY_ROWID, KEY_MARKID, KEY_TITLE, KEY_LAT, KEY_LNG }, KEY_MARKID + "="
                + markId, null, null, null, null, null);

        if (mCursor != null) {

            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateMarker(String markId, String title, double lat, double lng) {

        ContentValues args = new ContentValues();
        args.put(KEY_TITLE, title);
        args.put(KEY_LAT, lat);
        args.put(KEY_LNG, lng);

        return mDb.update(DATABASE_TABLE, args, KEY_MARKID + "=" + markId, null) > 0;
    }
}
