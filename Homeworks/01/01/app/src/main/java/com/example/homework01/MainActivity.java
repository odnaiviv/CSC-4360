package com.example.homework01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText yourName;
    private TextView outputName;

    // method to print hello + name
    public void printHello(View v) {
        Button helloButton = (Button) v;
        ((Button)v).setText("Hi!");

        yourName = (EditText) findViewById(R.id.inputText);
        outputName = (TextView)  findViewById(R.id.outputText);
        outputName.setText("Hello " + yourName.getText() + "!");
        outputName.setVisibility(View.VISIBLE);
    }

    // method to print goodbye + name
    public void printGoodbye(View v) {
        Button helloButton = (Button) v;
        ((Button)v).setText("Bye!");

        yourName = (EditText) findViewById(R.id.inputText);
        outputName = (TextView)  findViewById(R.id.outputText);
        outputName.setText("Goodbye " + yourName.getText() + "!");
        outputName.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
