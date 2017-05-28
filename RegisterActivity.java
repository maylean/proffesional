package com.example.agabil4c.jobconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class RegisterActivity extends AppCompatActivity {


    private android.support.v7.widget.Toolbar toolbar;
    Button login;
    Button register;
    private EditText fname, lname, pnumber, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fname = (EditText) findViewById(R.id.fname);
        lname= (EditText) findViewById(R.id.lname);
        pnumber = (EditText) findViewById(R.id.phonenumber);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        login = (Button)findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        register = (Button)findViewById(R.id.sign_up);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fname.getText().toString();
                String lnam = lname.getText().toString();
                String phone = pnumber.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (!name.isEmpty() && !lnam.isEmpty() && !phone.isEmpty() && !mail.isEmpty() && !pass.isEmpty()) {
                    Intent i = new Intent(RegisterActivity.this, CreateProfile.class);
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