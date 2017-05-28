package com.example.xeus_labmacbook.growup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.xeus_labmacbook.growup.model.AddProfile;
import com.example.xeus_labmacbook.growup.model.ServerResponse;
import com.example.xeus_labmacbook.growup.network.APIClient;
import com.example.xeus_labmacbook.growup.service.APIService;
import com.github.mikephil.charting.utils.FileUtils;
import com.mukesh.tinydb.TinyDB;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Flowerpot_Add extends AppCompatActivity {

    int TAKE_PHOTO_CODE = 0;
    public static int count = 0;
    private static final String TAG = "FlowerAddActivity";
    private TinyDB  tinydb;
    private EditText name;
    String dir;
    private Button btn_save;
    String id ;
    private Spinner profileSpinner;
    private ArrayList<String> mProfile = new ArrayList<String>();
    private String Temp_selectedItem = "";
    private Uri Store_path_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerpot__add);

        this.setTitle(" Add My Flowerpot");

        tinydb = new TinyDB(getApplicationContext());


        id = tinydb.getString("user_id");

        btn_save = (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SentData();
                Intent intent = new Intent(getApplicationContext(), Flowerpot.class);
                startActivity(intent);
                Log.e(TAG,"Save Data Success");
            }
        });

        //name
        name = (EditText)findViewById(R.id.input_name);

        //Spinner
        profileSpinner = (Spinner)findViewById(R.id.spinner_profile);
        createProfileData();

        final ArrayAdapter<String> profileAdapter = new ArrayAdapter<String>(
                getBaseContext(),android.R.layout.simple_spinner_dropdown_item, mProfile
        );

        profileAdapter.setDropDownViewResource(
                android.R.layout.simple_dropdown_item_1line
        );

        profileSpinner.setAdapter(profileAdapter);
        profileSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem = profileSpinner.getSelectedItem().toString();
                        if(selectedItem.equals("Peace Lilly"))
                        {
                            profileSpinner.setSelection(0);
                        }else if(selectedItem.equals("Chrysanthemum")){
                            profileSpinner.setSelection(1);
                        }
                        selectedItem = profileSpinner.getItemAtPosition(position).toString();
                        Temp_selectedItem = selectedItem;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );


        //Camera
        dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();

        Button capture = (Button) findViewById(R.id.btnCapture);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Here, the counter will be incremented each time, and the
                // picture taken by camera will be stored as 1.jpg,2.jpg
                // and likewise.
                count++;
                //String file = dir+count+".jpg";
               // String file = dir+System.currentTimeMillis()+".jpg";
                String file = System.currentTimeMillis()+".jpg";
                //File newfile = new File(file);
                File newfile = new File(Environment.getExternalStorageDirectory(), "/picFolder/"+file);
                try {
                    newfile.createNewFile();
                }
                catch (IOException e)
                {

                }

                Uri outputFileUri = Uri.fromFile(newfile);
                Store_path_image = outputFileUri;
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
    }


    private void SentData(){

        File file = new File(Store_path_image.getPath());

        RequestBody reqFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part image = MultipartBody.Part.createFormData("file_img", file.getName(), reqFile);

        Log.e(TAG, " uid : "+id);
        Log.e(TAG, " Store_path_image.getPath() : "+Store_path_image.getPath());

        RequestBody uid_form = RequestBody.create( okhttp3.MultipartBody.FORM, id);
        RequestBody name_form = RequestBody.create( okhttp3.MultipartBody.FORM, name.getText().toString());
        RequestBody profileSpinner_form = RequestBody.create( okhttp3.MultipartBody.FORM, Temp_selectedItem);

        APIService service = APIClient.getRetrofit().create(APIService.class);

        Call<AddProfile> call = service.AddProfile2(uid_form, name_form,profileSpinner_form,image);

        call.enqueue(new Callback<AddProfile>(){
            @Override
            public void onResponse(Call<AddProfile> call, Response<AddProfile> response) {

                tinydb.putString("fp_name",response.body().getPot().getName());
                tinydb.putString("fp_type",response.body().getPot().getType());
                tinydb.putString("fp_image",response.body().getPot().getImage());
                Log.e(TAG,"Success");
            }

            @Override
            public void onFailure(Call<AddProfile> call, Throwable t) {
                Log.e(TAG,"False");
            }
        });
    }
}
