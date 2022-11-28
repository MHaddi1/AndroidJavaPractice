package com.example.recylerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Lang> langList = new ArrayList<>();
    langList = getData();

    int [] img = {R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView  = findViewById(R.id.recyclerView);

        MyAdapter adapter = new MyAdapter(this,langList);
        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);




    }
    private  <Lang> getData()
    {

        langList.add(new Lang("First Exam",
                "May 23, 2015",
                R.drawable.c));
        langList.add(new Lang("Second Exam",
                "June 09, 2015",
                R.drawable.java));
        langList.add(new Lang("My Test Exam",
                "April 27, 2017",
                R.drawable.cplus));

        return langList;
    }

//    private void initName() {
//        String [] Name = getResources().getStringArray(R.array.Programming_array);
//        String [] Des = getResources().getStringArray(R.array.Description_array);
//        for (int i = 0; i<Name.length;i++){
//            langList.add(new Lang(Name[i],Des[i],img[i]));
//        }

//        langList = new ArrayList<>();
//        langList.add(new Lang(
//           1,
//           "C Language",
//           "This Is a Description"
////           R.drawable.c
//        ));
//        langList.add(new Lang(
//                1,
//                "C Language",
//                "This Is a Description"
////                R.drawable.c
//        ));
//        langList.add(new Lang(
//                1,
//                "C Language",
//                "This Is a Description"
////                R.drawable.c
//        ));
//        langList.add(new Lang(
//                1,
//                "C Language",
//                "This Is a Description"
////                R.drawable.c
//        ));
//        langList.add(new Lang(
//                1,
//                "C Language",
//                "This Is a Description"
////                R.drawable.c
//        ));

    }



