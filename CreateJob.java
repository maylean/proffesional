package com.example.agabil4c.jobconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class CreateJob extends EmpBaseActivity {


    //private String[] leftSliderData = {"Home", "Login", "Sitemap", "About", "Contact Me"};
    private android.support.v7.widget.Toolbar toolbar;
    private EditText job, desc, skills, amount;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.job, contentFrameLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        job = (EditText) findViewById(R.id.job);
        desc= (EditText) findViewById(R.id.description);
        skills = (EditText) findViewById(R.id.skills);
        amount = (EditText) findViewById(R.id.amount);


        submit = (Button)findViewById(R.id.post_job);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjob = job.getText().toString();
                String jdesc = desc.getText().toString();
                String skill = skills.getText().toString();
                String amnt = amount.getText().toString();


                if (!cjob.isEmpty() && !jdesc.isEmpty() && !skill.isEmpty() && !amnt.isEmpty()) {
                    Intent i = new Intent(CreateJob.this, JobPostings.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }


            }
        });



    }
}
