package com.example.hotspots;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HotSpotsDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HotSpots.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_PLACES =
            "create table place (" + "_id integer primary key autoincrement, " +
            "place text, " + "address text);";
    private static final String CREATE_TABLE_RATINGS =
            "create table RATINGS (" + "_id integer primary key autoincrement, " +
                    "place_id integer, " + "beerRating integer, " + "wineRating integer, " + "musicRating integer);";

    public HotSpotsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLACES);
        db.execSQL(CREATE_TABLE_RATINGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        Log.w(HotSpotsDBHelper.class.getName(),
                "Upgrading database from version " + oldVer + " to " + newVer + " which will destroy all old data.");
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }
}
