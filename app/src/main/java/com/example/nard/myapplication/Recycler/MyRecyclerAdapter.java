package com.example.nard.myapplication.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nard.myapplication.Fragments.Favourites;
import com.example.nard.myapplication.IllnessActivity;
import com.example.nard.myapplication.Login;
import com.example.nard.myapplication.R;

import java.util.ArrayList;

/**
 * Created by nard on 24/09/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Illness> illness;

    public MyRecyclerAdapter(Context c, ArrayList<Illness> illness) {
        this.c = c;
        this.illness = illness;
    }

    //Intialize Holder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    //Bind date to views
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.nameText.setText(illness.get(position).getIllnessName());

        //Listener
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                Intent newIntent = new Intent(v.getContext(), IllnessActivity.class);
                Toast.makeText(c, illness.get(pos).getIllnessName(), Toast.LENGTH_SHORT).show();
                c.startActivity(newIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return illness.size();
    }
}
