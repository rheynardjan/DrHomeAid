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

public class Categories extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_categories,null);

        //RecyclerView
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.myRecyclerCategories);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new MyRecyclerAdapter(this.getActivity(), getCategoriesIllness()));

        return v;
    }

    private ArrayList<Illness> getCategoriesIllness() {

        ArrayList<Illness> illnesses = new ArrayList<>();

        Illness illness = new Illness("Abcess");
        illnesses.add(illness);

        illness = new Illness("Acid Reflux");
        illnesses.add(illness);

        illness = new Illness("Acne");
        illnesses.add(illness);

        illness = new Illness("Anemia");
        illnesses.add(illness);

        illness = new Illness("Arthritis");
        illnesses.add(illness);

        illness = new Illness("Asthma");
        illnesses.add(illness);

        return illnesses;
    }

    //Set Title for Fragment

    @Override
    public String toString() {
        return "Categories";
    }
}
