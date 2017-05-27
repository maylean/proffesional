package com.example.agabil4c.jobconnect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by agabil4c on 5/27/2017.
 */
public class JobPostings extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static JobPostings newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        JobPostings fragment = new JobPostings();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.jobposts,container,false);
        return v;
    }
}
