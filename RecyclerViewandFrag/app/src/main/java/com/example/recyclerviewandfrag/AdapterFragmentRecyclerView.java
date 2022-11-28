package com.example.recyclerviewandfrag;

import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

public class AdapterFragmentRecyclerView extends RecyclerView.ViewHolder {
   private TextView view;
    public AdapterFragmentRecyclerView(View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.randomText);

    }
    public TextView getView(){
        return view;
    }
}
