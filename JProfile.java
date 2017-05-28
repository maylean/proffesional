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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class JProfile extends EmpBaseActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText prof, skill, proj_links, exp, education;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_jprofile, contentFrameLayout);

        Button submit;
        prof = (EditText) findViewById(R.id.profession);
        skill= (EditText) findViewById(R.id.skillz);
        proj_links = (EditText) findViewById(R.id.p_links);
        exp = (EditText) findViewById(R.id.experience);
        education = (EditText) findViewById(R.id.educ);

        submit = (Button) findViewById(R.id.submit_pfl);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String profession = prof.getText().toString();
                String skillz = skill.getText().toString();
                String links = proj_links.getText().toString();
                String experience = exp.getText().toString();
                String educ = education.getText().toString();

                if (!profession.isEmpty() && !skillz.isEmpty() && !links.isEmpty() && !experience.isEmpty() && !educ.isEmpty()) {
                    // Start NewActivity.class
                    Intent myIntent = new Intent(JProfile.this, ViewJobs.class);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }


            }
        });

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
