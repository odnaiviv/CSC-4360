package com.example.mealraterdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBMealRaterHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MealRater.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_MEALS =
            "create table meals (" + "_id integer primary key autoincrement, " +
            "restaurant text, " + "dish text, " + "rating integer);";
    public DBMealRaterHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MEALS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        Log.w(DBMealRaterHelper.class.getName(),
                "Upgrading database from version " + oldVer + " to " + newVer + " which will destroy all old data.");
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }
}
