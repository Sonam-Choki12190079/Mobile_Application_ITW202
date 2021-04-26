package edu.gcit.todo_intentreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Mmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Mmessage = findViewById(R.id.text_uri_message);

        Intent obj = getIntent();
        Uri message = obj.getData();

        if (message != null) {
            String txt = message.toString();
            Mmessage.setText(txt);

        }
    }
}