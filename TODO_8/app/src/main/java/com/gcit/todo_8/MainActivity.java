package com.gcit.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText OpenUri;
    private EditText OpenLocation;
    private EditText ShareText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenUri = findViewById(R.id.editText1);
        OpenLocation= findViewById(R.id.editText2);
        ShareText = findViewById(R.id.editText3);


    }

    public void OpenWebsite(View view) {

        String url = OpenUri.getText().toString();
        Uri website = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, website);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intents", "Can't handle this project");
        }

    }

    public void OpenLocation(View view) {

        String location = OpenLocation.getText().toString();

        Uri locationUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intents", "Can't handle this project");
        }
    }
    public void Share(View view) {
        String text = ShareText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
        }
}