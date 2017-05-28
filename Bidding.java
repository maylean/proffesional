package com.example.agabil4c.jobconnect;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class Bidding extends BaseActivity {


    private String[] leftSliderData = {"Home", "Login", "Sitemap", "About", "Contact Me"};
    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.biders, contentFrameLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Bids");


    }
}
