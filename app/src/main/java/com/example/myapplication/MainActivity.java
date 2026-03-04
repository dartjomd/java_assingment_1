package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputFirstNumber = findViewById(R.id.inputFirstNumber);
        EditText inputSecondNumber = findViewById(R.id.inputSecondNumber);
        TextView textResult = findViewById(R.id.textResult);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(v -> {
            calculate(inputFirstNumber, inputSecondNumber, textResult, "+");
        });

        buttonMinus.setOnClickListener(v -> {
            calculate(inputFirstNumber, inputSecondNumber, textResult, "-");
        });

        buttonMultiply.setOnClickListener(v -> {
            calculate(inputFirstNumber, inputSecondNumber, textResult, "*");
        });

        buttonDivide.setOnClickListener(v -> {
            calculate(inputFirstNumber, inputSecondNumber, textResult, "/");
        });
    }

    private void calculate(EditText input1, EditText input2, TextView resultView, String operation) {
        if (input1.getText().toString().isEmpty() || input2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(input1.getText().toString());
        double n2 = Double.parseDouble(input2.getText().toString());
        double res = 0;

        switch (operation) {
            case "+": res = n1 + n2; break;
            case "-": res = n1 - n2; break;
            case "*": res = n1 * n2; break;
            case "/":
                if (n2 != 0) {
                    res = n1 / n2;
                } else {
                    resultView.setText("Error: division by 0");
                    return;
                }
                break;
        }

        resultView.setText(String.valueOf(res));
    }
}