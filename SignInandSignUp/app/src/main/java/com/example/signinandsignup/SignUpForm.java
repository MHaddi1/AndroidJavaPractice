package com.example.signinandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);
        Button btn;
        EditText ed,ed2,ed3;
        btn = findViewById(R.id.btn);
        ed = findViewById(R.id.email);
        ed2 = findViewById(R.id.password);
        ed3 = findViewById(R.id.Username);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               btn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String email,password,username;
                       email = ed.getText().toString();
                       password = ed2.getText().toString();
                       username = ed3.getText().toString();
                       if((email.isEmpty() && password.isEmpty() && username.isEmpty())){
                           Toast.makeText(getApplicationContext(), "Please Fill The Sign Up Form", Toast.LENGTH_SHORT).show();
                       }
                       else {
                           Intent i = new Intent(getApplicationContext(),ProfileCreated.class);
                           startActivity(i);
                       }
                   }
               });
            }
        });

    }

}