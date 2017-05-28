package com.example.agabil4c.jobconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class JobPostings extends Fragment {

    Button pjob;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.jobposts,container,false);
        pjob = (Button) v.findViewById(R.id.job);
        pjob.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start the profile account class
                Intent myIntent = new Intent(getActivity(), CreateJob.class);
                startActivity(myIntent);
            }
        });
        return v;
    }
}
