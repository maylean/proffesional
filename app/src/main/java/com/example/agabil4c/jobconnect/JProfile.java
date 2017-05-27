package com.example.agabil4c.jobconnect;

import android.content.Intent;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class JProfile extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jprofile);
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button submit;
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(JProfile.this,
                        ViewJobs.class);
                startActivity(myIntent);
            }
        });
        init_navigation();
    }

    private DrawerLayout mDrawerLayout;
    private android.support.v7.app.ActionBarDrawerToggle mActionBarDrawerToggle;
    private ScrimInsetsFrameLayout mScrimInsetsFrameLayout;

    private void init_navigation(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primary_material_dark));
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        // TODO - Do something
                        break;
                    // TODO - Handle other items
                }
                return true;
            }
        });

        mActionBarDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            public void onDrawerSlide(View drawerview, float slideOffset){
                super.onDrawerSlide(drawerview, 0);
            }
        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        mActionBarDrawerToggle.syncState();
        /*int possibleMinDrawerWidth = UtilsDevice.getScreenWidth(this)- UtilsMiscellaneous.getThemeAttributeDimensionSize(this, android.R.attr.actionBarSize);
        int maxDrawerWidth =getResources().getDimensionPixelSize(R.dimen.navigation_drawer_width);
        mScrimInsetsFrameLayout.getLayoutParams().width = Math.min(possibleMinDrawerWidth, maxDrawerWidth);*/
        getSupportActionBar().setTitle(R.string.toolbar_title_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
