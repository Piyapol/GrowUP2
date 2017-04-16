package com.example.xeus_labmacbook.growup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Flowerpot_Add extends AppCompatActivity {

    int TAKE_PHOTO_CODE = 0;
    public static int count = 0;

    private Spinner profileSpinner;
    private ArrayList<String> mProfile = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerpot__add);

        this.setTitle(" Add My Flowerpot");

        profileSpinner = (Spinner)findViewById(R.id.spinner_profile);
        createProfileData();

        ArrayAdapter<String> profileAdapter = new ArrayAdapter<String>(
                getBaseContext(),android.R.layout.simple_spinner_dropdown_item, mProfile
        );

        profileAdapter.setDropDownViewResource(
                android.R.layout.simple_dropdown_item_1line
        );

        profileSpinner.setAdapter(profileAdapter);

        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();

        Button capture = (Button) findViewById(R.id.btnCapture);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Here, the counter will be incremented each time, and the
                // picture taken by camera will be stored as 1.jpg,2.jpg
                // and likewise.
                count++;
                String file = dir+count+".jpg";
                File newfile = new File(file);
                try {
                    newfile.createNewFile();
                }
                catch (IOException e)
                {
                }

                Uri outputFileUri = Uri.fromFile(newfile);

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Log.d("CameraDemo", "Pic saved");
        }
    }

    private void createProfileData(){
        mProfile.add("Peace lily");
        mProfile.add("Chrysanthemum");
        mProfile.add("Rose");
    }

}
