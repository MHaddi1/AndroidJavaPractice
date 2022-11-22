package com.example.roompresence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button submit;
EditText title,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.editText);
        amount = findViewById(R.id.editText2);
        submit = findViewById(R.id.btn);
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = title.getText().toString();
                String Amount = amount.getText().toString();
                databaseHelper.expenseDao().addData(new Expense(Title,Amount));
                showMassage("Data Enter Successfully");
               ArrayList<Expense> arrayList = (ArrayList<Expense>) databaseHelper.expenseDao().expenseList();
               for (int i=0;i<arrayList.size();i++){
                   Log.d("DATA"," Title: "+arrayList.get(i).getTitle()+" Amount: "+arrayList.get(i).getAmount());
               }
            }
        });


    }
    public void showMassage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}