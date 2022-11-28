package com.example.fragmentp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.sax.RootElement;
import android.service.media.MediaBrowserService;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button fragA,fragB,fragC,DEL_a,DEL_b,DEL_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragA = findViewById(R.id.fragbtnA);
        fragB = findViewById(R.id.fragbtnB);
        fragC = findViewById(R.id.fragbtnC);


        LoadFragment(new BFragment(),1);
        fragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            LoadFragment(new AFragment(),0);
            }
        });
        fragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadFragment(new BFragment(),0);
            }
        });
        fragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadFragment(new CFragment(),0);
            }
        });

//DEL_a.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        getSupportFragmentManager().beginTransaction().remove(new AFragment()).commit();
//    }
//});
//DEL_b.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        getSupportFragmentManager().beginTransaction().remove(new BFragment()).commit();
//    }
//});
//DEL_c.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        getSupportFragmentManager().beginTransaction().remove(new CFragment()).commit();
//    }
//});
    }
    public void LoadFragment(Fragment fragment,  int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==1) {
            ft.add(R.id.frag1, fragment);
            fm.popBackStack(ROLE_SERVICE,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        else {
            ft.replace(R.id.frag1, fragment);
            ft.addToBackStack(null);
        }

        ft.commit();
    }

}