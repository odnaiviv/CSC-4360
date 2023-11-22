package com.example.mealraterdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MealRaterDataSource {
    private SQLiteDatabase database;
    private DBMealRaterHelper helper;

    public MealRaterDataSource(Context context) {
        helper = new DBMealRaterHelper(context);
    }
    public void open() throws SQLException {
        database = helper.getWritableDatabase();
    }
    public void close() {
        helper.close();
    }

    public long insertMeal(String restaurant, String dish, String rating) {
        ContentValues value = new ContentValues();
        value.put("restaurant", restaurant);
        value.put("dish", dish);
        value.put("rating", rating);
        return database.insert("meals", null, value);
    }
}
