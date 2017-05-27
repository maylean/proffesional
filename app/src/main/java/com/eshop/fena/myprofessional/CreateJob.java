package com.eshop.fena.myprofessional;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.agabil4c.jobconnect.R;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class CreateJob extends AppCompatActivity {


    private String[] leftSliderData = {"Home", "Login", "Sitemap", "About", "Contact Me"};
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
}
