package com.example.classtaskweek4;

import static android.os.Build.VERSION_CODES.S;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    SMS();
    }

    public void SMS(){
        Button btn = findViewById(R.id.button);

     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             EditText msg =  findViewById(R.id.message);
             EditText pno= findViewById(R.id.phone_number);
             String ph = pno.getText().toString();
             String mg = msg.getText().toString();
             SmsManager sm = SmsManager.getDefault();
             sm.sendTextMessage(ph,null,mg,null,null);
             Toast.makeText(getApplicationContext(),"Sms Send Successfully",Toast.LENGTH_SHORT).show();
         }
     });
    }

}