package com.example.sqliteassignmentno3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView PreviewImage;
    FloatingActionButton SelectImage;
    int SELECT_PICTURE = 200;
    ConstraintLayout layout;
    MyDBClass myDBClass;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreviewImage = findViewById(R.id.IVPreviewImage);
        SelectImage = findViewById(R.id.BSelectImage);
        layout = findViewById(R.id.constraint);
        SelectImage.setOnClickListener(this);
        myDBClass = new MyDBClass(this);


    }

    void showMassage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        if (hasStoragePermission(MainActivity.this)) {
            OpenImageChoser();

        } else {
            ActivityCompat.requestPermissions((AppCompatActivity) MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
        }
    }

    public void OpenImageChoser() {
//        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(gallery, SELECT_PICTURE);

        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {

            if (requestCode == SELECT_PICTURE) {
                Uri selectImageUri = data.getData();
                if (selectImageUri != null) {
                    if (saveImageInDB(selectImageUri)) {
                        showMassage("Image Saved in Database in successfully!!");
                        PreviewImage.setImageURI(selectImageUri);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                PreviewImage.setVisibility(View.GONE);
                            }
                        }, 2000);

                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                           if (loadIMagefromDB()){
                              PreviewImage.setVisibility(View.VISIBLE);
                              showMassage("Image Loaded From Database successfully!!");
                           }
                        }
                    }, 3500);

                }

            }
        }
    }

    private boolean loadIMagefromDB() {
        try {
            myDBClass.Open();
            byte[] bytes = myDBClass.reteriveImageFromDB();
            myDBClass.Close();
            PreviewImage.setImageBitmap(Utils.getImage(bytes));
            return true;
        } catch (Exception e) {
            myDBClass.Close();
            return false;

        }
    }

    private boolean saveImageInDB(Uri selectedImageUri) {
        try {
            myDBClass.Open();
            InputStream iStream = getContentResolver().openInputStream(selectedImageUri);
            byte[] inputData = Utils.getByte(iStream);
            myDBClass.insertImage(inputData);
            myDBClass.Close();
            return true;
        } catch (Exception e) {
            myDBClass.Close();
            return false;
        }
    }

    private boolean hasStoragePermission(Context context) {
        int read = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        return read == PackageManager.PERMISSION_GRANTED;
    }
}