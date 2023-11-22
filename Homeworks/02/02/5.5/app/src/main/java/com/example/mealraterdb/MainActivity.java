// reusing the code i made in ex 4.5!!
package com.example.mealraterdb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText restaurant, dish;
    private Button rateMeal;
    private TextView rating;

    // adding new button & data source to this list
    private Button save;
    private MealRaterDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // input of restaurant & dish texts
        restaurant = findViewById(R.id.restaurant);
        dish = findViewById(R.id.dish);
        // rating button
        rateMeal = findViewById(R.id.rateMeal);
        // rating output results text
        rating = findViewById(R.id.rating);

        // datasource from meal rater helper database
        dataSource = new MealRaterDataSource(this);
        dataSource.open();

        // meal rating button method
        rateMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling method to show meal rating
                showRating();
            }
        });

        // save button method
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling method to save meal rating
                saveRating();
            }
        });
    }

    // method to alert & show rating of meal
    private void showRating() {
        // opening dialog to rate meal
        AlertDialog.Builder rm = new AlertDialog.Builder(this);
        rm.setTitle("Please Rate the Meal: ");

        // creating 1 to 5 rating scale
        String[] scale = {"1", "2", "3", "4", "5"};
        rm.setSingleChoiceItems(scale, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int select) {
                String selectedRating = scale[select];
                // returning printed results
                String result = selectedRating + " / 5";
                rating.setText(result);
                dialog.dismiss();
            }
        });

        // creating cancel button in dialog menu
        rm.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int select) {
                dialog.dismiss();
            }
        });
        // displaying dialog to rate meal
        rm.create().show();
    }

    // method to save restaurant, dish, & rating of meal
    private void saveRating() {
        String dishName = dish.getText().toString();
        String restraurantName = restaurant.getText().toString();
        String ratingText = rating.getText().toString().replace("0 / 5", " ");
        int rate = Integer.parseInt(ratingText);

        long results = dataSource.insertMeal(restraurantName, dishName, String.valueOf(rate));
         if (results != -1) {
             Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();
         }
         else {
             Toast.makeText(this, "Saving failed!", Toast.LENGTH_SHORT).show();
         }
    }
}
