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

public class Login extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button submit,register;
        email = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        register = (Button) findViewById(R.id.register);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (!mail.isEmpty() && !pass.isEmpty()) {
                    // Start the profile account class
                    Intent myIntent = new Intent(Login.this, ViewJobs.class);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start a register account
                Intent myIntent = new Intent(Login.this,
                        Register.class);
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
