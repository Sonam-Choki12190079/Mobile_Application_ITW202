package com.gcit.todo_09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText EditText_One;
    private EditText EditText_Two;
    private TextView ResultTextView;
    private Calculator CalculateOperation;
    private static final String TAG = "Calculator.getSimpleName()";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculateOperation = new Calculator();
        EditText_One = findViewById(R.id.editTextOne);
        EditText_Two = findViewById(R.id.editTextTwo);
        ResultTextView = findViewById(R.id.textView1);

    }

    public void add(View view) {
        String operandOne = EditText_One.getText().toString();
        String operandTwo = EditText_Two.getText().toString();

        double Total_number =CalculateOperation.Add(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        ResultTextView.setText(String.valueOf(Total_number));


    }

    public void sub(View view) {
        String operandOne = EditText_One.getText().toString();
        String operandTwo = EditText_Two.getText().toString();

        double Total_value = CalculateOperation.Sub(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        ResultTextView.setText(String.valueOf(Total_value));
    }

    public void mul(View view) {
        String operandOne = EditText_One.getText().toString();
        String operandTwo = EditText_Two.getText().toString();

        double Total_value =CalculateOperation.Mul(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        ResultTextView.setText(String.valueOf(Total_value));
    }

    public void div(View view) {
        String operandOne = EditText_One.getText().toString();
        String operandTwo = EditText_Two.getText().toString();

        double value =CalculateOperation.Div(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        ResultTextView.setText(String.valueOf(value));
    }


}