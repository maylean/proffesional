package com.eshop.fena.myprofessional;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agabil4c.jobconnect.R;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class JobPostings extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.jobposts,container,false);
        return v;
    }
}