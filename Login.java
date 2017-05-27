package com.eshop.fena.myprofessional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button submit,register;
        submit = (Button) findViewById(R.id.submit);
        register = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start the profile account class
                Intent myIntent = new Intent(Login.this,
                        JProfile.class);
                startActivity(myIntent);
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
}
