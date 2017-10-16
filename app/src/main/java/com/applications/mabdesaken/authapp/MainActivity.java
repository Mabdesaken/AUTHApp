package com.applications.mabdesaken.authapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attempts to launch another activity inside our app
        Button secondActivityButton = (Button)findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                // show how to pass information to another activity
                startIntent.putExtra("org.applications.authapp.SOMETHING", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });

        // We'll launch an activity outside of our app
        Button googleButton = (Button)findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }
            }
        });
    }
}
