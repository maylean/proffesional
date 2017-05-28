package com.example.agabil4c.jobconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class CreateProfile extends BaseActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText cname, location, phone_num, tin_num,c_desc;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.company_profile, contentFrameLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Create Profile");
        cname = (EditText) findViewById(R.id.cname);
        location= (EditText) findViewById(R.id.location);
        phone_num = (EditText) findViewById(R.id.phonenumber);
        tin_num = (EditText) findViewById(R.id.tnumber);
        c_desc = (EditText) findViewById(R.id.cdesc);


        submit = (Button)findViewById(R.id.submit_prfl);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = cname.getText().toString();
                String loc = location.getText().toString();
                String phone = phone_num.getText().toString();
                String tin = tin_num.getText().toString();
                String desc = c_desc.getText().toString();

                if (!name.isEmpty() && !loc.isEmpty() && !phone.isEmpty() && !tin.isEmpty() && !desc.isEmpty()) {
                    Intent i = new Intent(CreateProfile.this, MainActivity.class);
                    startActivity(i);
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