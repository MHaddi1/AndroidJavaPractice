package com.example.recylerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Lang> langList = Collections.emptyList();



    public MyAdapter(Context context, List<Lang>langList){
        this.context=context;
        this.langList=langList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.language,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.textView1.setText(langList.get(position).getTitle());
        holder.textView2.setText(langList.get(position).getShortdesc());
        holder.imageView.setImageResource(langList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return langList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = imageView .findViewById(R.id.imageView2);
            textView1 = textView1.findViewById(R.id.Name);
            textView2 = textView2.findViewById(R.id.des);

        }
    }
}


