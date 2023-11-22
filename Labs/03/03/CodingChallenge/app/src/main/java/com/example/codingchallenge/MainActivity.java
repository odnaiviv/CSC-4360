package com.example.codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// main activity
public class MainActivity extends AppCompatActivity {

    // listing variables as private
    private Button b1;
    private Button b2;
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing private variables
        b1 = findViewById(R.id.button_t1);
        b2 = findViewById(R.id.button_t2);
        b3 = findViewById(R.id.button_t3);

        // making buttons work when clicked on
        // button 1
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            // method for buttons to work
            public void onClick(View view) {
                // some story i guess
                showTextOn2nd(
                        "Lost in the woods, a child found a hidden door. Inside, a magical garden flourished with talking animals. They all shared wisdom, teaching kindness. The child returned, spreading love, and transformed their village into a place of harmony and laughter.");
            }
        });

        // button 2
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextOn2nd(
                        "2B and 9S are androids fighting machines in a post-apocalyptic world. They develop a deep bond while unraveling the mysteries of humanity's demise. Tragedy ensues as they discover truths about their existence, leading to a poignant exploration of identity, emotions, and the cost of war.");
            }
        });

        // button 3
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextOn2nd(
                        "We're no strangers to love, you know the rules and so do I. A full commitment's what I'm thinking of, you wouldn't get this from any other guy. I just wanna tell you how I'm feeling, gotta make you understand. Never gonna give you up, Never gonna let you down, Never gonna run around and desert you.");
            }
        });
    }

    // method to bring user to second activity
    public void showTextOn2nd(String text) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("text", text);
        startActivity(intent);
    }
}
