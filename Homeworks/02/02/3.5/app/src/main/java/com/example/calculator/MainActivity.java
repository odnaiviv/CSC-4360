package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Button add, subtract, multiply, divide;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // input of first & second numbers
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        // math operations
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        // output result text
        answer = findViewById(R.id.answer);

        // add button operations method
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                // adding numbers together to find sum
                double sum = n1 + n2;
                // answer results + sum
                answer.setText("Answer: " + sum);
            }
        });

        // subtract button operations method
        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                // subtracting numbers together to find difference
                double diff = n1 - n2;
                // answer results + difference
                answer.setText("Answer: " + diff);
            }
        });

        // multiply button operations method
        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                // multiplying numbers together to find product
                double prod = n1 * n2;
                // answer results + product
                answer.setText("Answer: " + prod);
            }
        });

        // divide button operations method
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                // dividing numbers together to find quotient
                double quot = n1 / n2;
                // answer results + quotient
                answer.setText("Answer: " + quot);
            }
        });
    }
}
