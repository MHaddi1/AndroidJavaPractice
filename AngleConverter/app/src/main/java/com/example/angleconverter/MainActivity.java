package com.example.angleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText ed;
Button btn;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        Converter();
    }
    public void Converter(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed = findViewById(R.id.angle);
                tv = findViewById(R.id.tv);
                double angle =Double.parseDouble(ed.getText().toString());
                double Ad = angle * 180/3.14;
                tv.setText(Ad+"*");


            }
        });
    }
}