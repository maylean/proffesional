package com.example.agabil4c.jobconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class EmpBaseActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private android.support.v7.app.ActionBarDrawerToggle mActionBarDrawerToggle;
    private ScrimInsetsFrameLayout mScrimInsetsFrameLayout;
    private android.support.v7.widget.Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emply_nav);
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primary_material_dark));
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent a = new Intent(EmpBaseActivity.this, ViewJobs.class);
                        startActivity(a);
                        finish();
                        break;
                    case R.id.profile:
                        Intent b = new Intent(EmpBaseActivity.this, JProfile.class);
                        startActivity(b);
                        finish();
                        break;
                    case R.id.job:
                        Intent c = new Intent(EmpBaseActivity.this, ViewJobs.class);
                        startActivity(c);
                        finish();
                        break;
                    case R.id.login:
                        Intent d = new Intent(EmpBaseActivity.this, Login.class);
                        startActivity(d);
                        finish();
                        break;

                    default:
                        break;
                    // TODO - Handle other items
                }
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

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
}
