package com.example.nard.myapplication.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nard.myapplication.R;

/**
 * Created by nard on 24/09/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameText;
    ItemClickListener itemClickListener;

    public MyViewHolder(View itemView){
        super(itemView);

        nameText = (TextView) itemView.findViewById(R.id.nameText);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }
}
