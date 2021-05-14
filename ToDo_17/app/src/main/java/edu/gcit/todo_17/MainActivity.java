package edu.gcit.todo_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mScore1, mScore2;
    private TextView mText1, mText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText1 = (TextView) findViewById(R.id.score1);
        mText2 = (TextView) findViewById(R.id.score2);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
                mScore1--;
                mText1.setText(String.valueOf(mScore1));
                break;

            case R.id.decreaseTeam2:
                mScore2--;
                mText2.setText(String.valueOf(mScore2));
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                mScore1 ++;
                mText1.setText(String.valueOf(mScore1));
                break;

            case R.id.increaseTeam2:
                mScore2++;
                mText2.setText(String.valueOf(mScore2));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return true;
    }
}