package com.example.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    EditText websiteEditText;
    Button openWebsite;
    EditText locationEditText;
    Button openLocation;
    EditText shareEditText;
    Button shareThisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websiteEditText = findViewById(R.id.website_edit_text);
        locationEditText = findViewById(R.id.location_edit_text);
        shareEditText = findViewById(R.id.share_edit_text);

        openWebsite = findViewById(R.id.open_website_button);
        openLocation = findViewById(R.id.open_location_button);
        shareThisText = findViewById(R.id.share_text_button);

        openWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse(websiteEditText.getText().toString());
                Intent sendIntent = new Intent(ACTION_VIEW,webPage);
                if (sendIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(sendIntent);
                } else {
                    Log.d("Implicit_Intents", "Can't handle this!");
                }
            }
        });




    }
}
