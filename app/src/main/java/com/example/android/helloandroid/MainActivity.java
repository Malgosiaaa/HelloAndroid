package com.example.android.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hides the status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //opens phone application with typed number and gives user possibility to call
    public void call(View view) {
        String number = getString(R.string.phone);
        Uri call = Uri.parse("tel:" + number);
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        if (surf.resolveActivity(getPackageManager()) != null) {
            startActivity(surf);
        }
    }

    //opens Udacity website
    public void url(View view) {
        Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
        openURL.setData(Uri.parse(getString(R.string.www)));
        if (openURL.resolveActivity(getPackageManager()) != null) {
            startActivity(openURL);
        }
    }

    //opens Google Maps with a pin on Udacity office location
    public void map(View view) {
        Uri gmmIntentUri = Uri.parse("geo:37.400011,-122.108331?q=Udacity");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
