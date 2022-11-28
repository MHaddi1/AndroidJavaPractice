package com.example.fragmentgallery;

import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Gallery simpleGallery;
    
    CustomizedGalleryAdapter customGalleryAdapter;
    ImageView selectedImageView;


    int[] images = {
            R.drawable.python,
            R.drawable.javascript,
            R.drawable.java,
            R.drawable.python,
            R.drawable.c,
            R.drawable.python,
            R.drawable.javascript,
            R.drawable.python,
            R.drawable.cshape,
            R.drawable.javascript
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleGallery = (Gallery) findViewById(R.id.languagesGallery);


        selectedImageView = (ImageView) findViewById(R.id.imageView);

        customGalleryAdapter = new CustomizedGalleryAdapter(getApplicationContext(), images);


        simpleGallery.setAdapter(customGalleryAdapter);


        simpleGallery.setOnItemClickListener((parent, view, position, id) -> {
            selectedImageView.setImageResource(images[position]);
        });
    }
}
