package com.example.agabil4c.jobconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText fname, lname, pnumber, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fname = (EditText) findViewById(R.id.fnam);
        lname= (EditText) findViewById(R.id.lnam);
        pnumber = (EditText) findViewById(R.id.phn);
        email = (EditText) findViewById(R.id.mail);
        password = (EditText) findViewById(R.id.passw);
        Button submit,login;
        login = (Button) findViewById(R.id.login);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String name = fname.getText().toString();
                String lnam = lname.getText().toString();
                String phone = pnumber.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (!name.isEmpty() && !lnam.isEmpty() && !phone.isEmpty() && !mail.isEmpty() && !pass.isEmpty()) {
                    // Start NewActivity
                    Intent myIntent = new Intent(Register.this, JProfile.class);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Register.this,
                        Login.class);
                startActivity(myIntent);
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
