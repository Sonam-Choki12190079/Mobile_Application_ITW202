package edu.gcit.todo_14iii;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnclickDate(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public void processDatePickerResult(int year, int month, int date){
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        String date_string = Integer.toString(date);
        String dateMessage =(month_string + "/" +date_string +"/" + year_string);
        Toast.makeText(this,"Date:" +dateMessage, Toast.LENGTH_SHORT).show();

    }




}