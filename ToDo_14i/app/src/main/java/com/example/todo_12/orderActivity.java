package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.todo_12.MainActivity.EXTRA_MESSAGE;

public class orderActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
   RadioButton SameDay, NextDay, PickUp;
   private String textString;
   private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        textString = intent.getExtras().getString(EXTRA_MESSAGE);
        textView = (TextView)findViewById(R.id.Ordered_message);
        textView.setText(textString);

        SameDay = findViewById(R.id.sameday);
        NextDay = findViewById(R.id.nextday);
        PickUp = findViewById(R.id.pickup);
        Spinner spinner = findViewById(R.id.spinner);
       // call setOnItemselectedLister if spinner is not null
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.phonetype, android.R.layout.simple_dropdown_item_1line);
        if(spinner != null){
            spinner.setAdapter(arrayAdapter);
        }
    }
    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void radioClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.sameday:
                if(checked)
                displayToast(getString(R.string.same_day_messenger_service));
                break;

            case R.id.nextday:
                if (checked)
                displayToast(getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if (checked)
                displayToast(getString(R.string.pick_up));
                break;

            default:
                break;
        }

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        displayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}