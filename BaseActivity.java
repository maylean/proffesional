package com.example.agabil4c.jobconnect;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private android.support.v7.app.ActionBarDrawerToggle mActionBarDrawerToggle;
    private android.support.v7.widget.Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_d);
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primary_material_dark));
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.getMenu().getItem(0).setChecked(true);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {



                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent a = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(a);
                        finish();
                        break;
                    case R.id.profile:
                        Intent b = new Intent(BaseActivity.this, CreateProfile.class);
                        startActivity(b);
                        finish();
                        break;
                    case R.id.job:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, new JobPostings());
                        ft.commit();
                        finish();
                        break;
                    case R.id.bids:
                        Intent d = new Intent(BaseActivity.this, Bidding.class);
                        startActivity(d);
                        finish();
                        break;
                    case R.id.logout:
                        Intent e = new Intent(BaseActivity.this, LoginActivity.class);
                        startActivity(e);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }





}
