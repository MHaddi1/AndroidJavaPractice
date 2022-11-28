package com.example.timecoverterbltopk;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2;
    Button btn;
    EditText ed, ed2;
    int h,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv2 = findViewById(R.id.tv2);
        btn = findViewById(R.id.btn);
        ed = findViewById(R.id.ed);
        ed2 = findViewById(R.id.ed2);
        converter();



    }
    public void converter(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                h = Integer.parseInt(ed.getText().toString());
                m = Integer.parseInt(ed2.getText().toString());
                tv2.setText(h+4+" : "+m+"Pakistan time");
            }
        });
    }

}