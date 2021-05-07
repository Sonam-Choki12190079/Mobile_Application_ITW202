package com.example.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String text;
    public static final String EXTRA_MESSAGE = "com.example.todo_12.extra.MESSAGE";

    //private TextView mOrderMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // mOrderMessage = getString(R.string.donutMessage);
    }
   private  void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void donut(View view) {
        text = getString(R.string.donutMessage);
        displayToast(getString(R.string.donutMessage));
    }

    public void icecream(View view) {
        text = getString(R.string.IcecreamMessage);
        displayToast(getString(R.string.IcecreamMessage));
    }

    public void froyo(View view) {
        text = getString(R.string.FroyoMessage);
        displayToast(getString(R.string.FroyoMessage));
    }


    public void ShoppingCart(View view) {
        // String message = textView.getText().toString();
        Intent intent = new Intent(this, orderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_Order:
                Intent intent = new Intent(this, orderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, text);
                startActivity(intent);
                return true;

            case R.id.Action_Contact:
                displayToast("you selected contact.");
                return true;
            case R.id.action_favourite:
                displayToast("you selected favourite.");
                return true;
            case R.id.Action_shopping:
                displayToast("you selected shopping.");
                return true;
        }
        return true;

    }
}

