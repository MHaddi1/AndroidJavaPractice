package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
int MonthDay = 0,Year = 0,date= 0;
    DatePickerDialog datePickerDialog;
    TextView t1;
    Calendar newDate;
    Button btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn = findViewById(R.id.btn);
        t1 = findViewById(R.id.t1);
        Calculation();
    }
    public void Calculation(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 newDate = Calendar.getInstance();
                Year = newDate.get(Calendar.YEAR);
                MonthDay = newDate.get(Calendar.DAY_OF_MONTH);
                date = newDate.get(Calendar.DATE);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                t1.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, Year, MonthDay, date);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
               datePickerDialog.show();

            }
        });

    }

}