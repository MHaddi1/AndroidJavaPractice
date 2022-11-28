package com.example.recycfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class NewFragment extends Fragment {


    public NewFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    List<Model> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_new, container, false);

        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();

        recyclerView.setAdapter(new ItemAdapter(initData(),getContext()));



        return view;
    }

    private List<Model> initData() {

        itemList=new ArrayList<>();
        itemList.add(new Model("C Language",R.drawable.c,"This Is Description"));
        itemList.add(new Model("C++ Language",R.drawable.cplus,"This Is Description"));
        itemList.add(new Model("C# Language",R.drawable.cshape,"This Is Description"));
        itemList.add(new Model("Java Language",R.drawable.java,"This Is Description"));
        itemList.add(new Model("JavaScript Language",R.drawable.javascript,"This Is Description"));
        itemList.add(new Model("Python Language",R.drawable.python,"This Is Description"));
        itemList.add(new Model("Android Development",R.drawable.ic_launcher_foreground,"This Is Description"));

        return itemList;
    }
}