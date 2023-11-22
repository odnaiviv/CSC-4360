package com.example.hotspots;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class HotSpotsDataSource {
    private SQLiteDatabase database;
    private HotSpotsDBHelper helper;

    public HotSpotsDataSource(Context context) {
        helper = new HotSpotsDBHelper(context);
    }

    public void open() throws SQLException {
        database = helper.getWritableDatabase();
    }
    public void close() {
        helper.close();
    }

    public long insertPlace(String name, String address) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);

        return database.insert("places", null, values);
    }

    public long insertRating(long placeid, int beerRating, int wineRating, int musicRating) {
        ContentValues values = new ContentValues();
        values.put("place_id", placeid);
        values.put("beerRating", beerRating);
        values.put("wineRating", wineRating);
        values.put("musicRating", musicRating);

        return database.insert("ratings", null, values);
    }

    public double[] calculateAverages() {
        String query = "SELECT AVG(beerRating) AS beeravg, AVG(wineRating) AS wineavg, AVG(musicRating) AS musicavg FROM ratings";

        SQLiteStatement statement = database.compileStatement(query);
        double[] averages = new double[3];

        averages[0] = statement.simpleQueryForLong();
        statement.clearBindings();

        averages[1] = statement.simpleQueryForLong();
        statement.clearBindings();

        averages[2] = statement.simpleQueryForLong();
        statement.close();

        return averages;
    }
}
