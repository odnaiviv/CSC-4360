package com.example.hotspots;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText place, address;
    private Button rate, save;
    private TextView showRatings;
    private HotSpotsDataSource dataSource;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // input of bar/nightclub name & address texts
        place = findViewById(R.id.place);
        address = findViewById(R.id.address);
        // rating & save buttons
        rate = findViewById(R.id.rate);
        save = findViewById(R.id.save);
        // rating output results text
        showRatings = findViewById(R.id.showRatings);

        // data sourcing from hot spots helper database
        dataSource = new HotSpotsDataSource(this);
        dataSource.open();

        // place rating button method
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling method to rate place
                showRating();
            }
        });
        // save button method
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling method to save rating
                saveRating();
            }
        });
        // updates the average of the ratings
        updateRatings();
    }

    // closing datasource
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }

    // method to alert & show rating of place
    private void showRating() {
        AlertDialog.Builder rp = new AlertDialog.Builder(this);
        rp.setTitle("Please Rate This Place: ");
        rp.setMessage("For each category, give a rating on a scale of 1 to 5: ");

        // creating custom layout for alert dialog
        View ratingDialog = getLayoutInflater().inflate(R.layout.rating_scale, null);
        final EditText beerRating = ratingDialog.findViewById(R.id.beer);
        final EditText wineRating = ratingDialog.findViewById(R.id.wine);
        final EditText musicRating = ratingDialog.findViewById(R.id.music);
        rp.setView(ratingDialog);

        rp.setPositiveButton("Rate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // getting ratings from each selection's editTexts
                int beerInt = Integer.parseInt(beerRating.getText().toString());
                int wineInt = Integer.parseInt(wineRating.getText().toString());
                int musicInt = Integer.parseInt(musicRating.getText().toString());

                // saving ratings to database
                long place_id = dataSource.insertPlace(place.getText().toString(), address.getText().toString());

                // checking if ratings saved correctly
                if (place_id != -1) {
                    long rating_id = dataSource.insertRating(place_id, beerInt, wineInt, musicInt);
                    if (rating_id != -1) {
                        Toast.makeText(MainActivity.this, "Successfully saved rating!", Toast.LENGTH_SHORT).show();
                        updateRatings();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to save ratings!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Saving results failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // creating cancel button to exit alert dialog
        rp.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int select) {
                dialog.dismiss();
            }
        });

        AlertDialog getRatings = rp.create();
        getRatings.show();
    }

    // method to save ratings of beer, wine & music selections
    private void saveRating() {
        String placeName = place.getText().toString();
        String addressName = address.getText().toString();
        // checking if place & addresses are empty
        if (!placeName.isEmpty() && !addressName.isEmpty()) {
            long place_id = dataSource.insertPlace(placeName, addressName);
            // reseting place & address
            if (place_id != -1) {
                place.setText("");
                address.setText("");
            }
            else {
                Toast.makeText(this, "Failed to save data.", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Please re-enter name & address.", Toast.LENGTH_SHORT).show();
        }
    }

    // method to update average of ratings
    private void updateRatings() {
        double[] averages = dataSource.calculateAverages();
        double beerAvg = averages[0];
        double wineAvg = averages[1];
        double musicAvg = averages[2];

        // printing results
        showRatings.setText(String.format("\nBeer: %.2f\n\nWine: %.2f\n\nMusic: %.2f", beerAvg, wineAvg, musicAvg));
    }
}
