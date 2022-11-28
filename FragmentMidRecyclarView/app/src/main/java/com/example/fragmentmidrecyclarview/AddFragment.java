package com.example.fragmentmidrecyclarview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class AddFragment extends Fragment {



    public AddFragment() {
        // Required empty public constructor
    }
RecyclerView recyclerView;
    List <Model> list;
    List <Model> getList(){
        list = new ArrayList<>();
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        list.add(new Model("Haddi"));
        return list;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_add, container, false);
       recyclerView = view.findViewById(R.id.frag);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       recyclerView.setAdapter(new FragmentAdapter(getList(),getContext()));
        return view;
    }
}