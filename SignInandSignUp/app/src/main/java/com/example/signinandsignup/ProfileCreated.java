package com.example.signinandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ProfileCreated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_created);
        Toast.makeText(this, "Profile Created", Toast.LENGTH_SHORT).show();
    }
}