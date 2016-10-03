package com.example.nard.myapplication.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nard.myapplication.R;
import com.example.nard.myapplication.Recycler.Illness;
import com.example.nard.myapplication.Recycler.MyRecyclerAdapter;

import java.util.ArrayList;

public class HomeRemedies extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_homerem,null);

        //RecyclerView
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.myRecyclerHomeRem);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new MyRecyclerAdapter(this.getActivity(), getHomeRem()));

        return v;
    }

    private ArrayList<Illness> getHomeRem() {

        ArrayList<Illness> illnesses = new ArrayList<>();

        Illness illness = new Illness("Remedy");
        illnesses.add(illness);

        illness = new Illness("Remedy");
        illnesses.add(illness);

        illness = new Illness("Remedy");
        illnesses.add(illness);

        illness = new Illness("Remedy");
        illnesses.add(illness);

        illness = new Illness("Remedy");
        illnesses.add(illness);

        illness = new Illness("Remedy");
        illnesses.add(illness);

        return illnesses;
    }

    //Set Title for Fragment

    @Override
    public String toString() {
        return "Home Remedies";
    }
}
