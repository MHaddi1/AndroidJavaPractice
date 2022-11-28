package com.example.recyclerviewandfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class RandomNumberListAdopter extends RecyclerView.Adapter<AdapterFragmentRecyclerView> {
    private Random random;

    public RandomNumberListAdopter(int num) {
        this.random = new Random(num);

    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.fragment_second;
    }


    @Override
    public AdapterFragmentRecyclerView onCreateViewHolder(ViewGroup parent, int viewType) {
      View view =  LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new AdapterFragmentRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(AdapterFragmentRecyclerView holder, int position) {
        holder.getView().setText(String.valueOf(random.nextInt()));
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
