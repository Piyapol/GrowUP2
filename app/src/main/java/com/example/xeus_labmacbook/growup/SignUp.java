package com.example.xeus_labmacbook.growup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xeus_labmacbook.growup.model.RegisterModel;
import com.example.xeus_labmacbook.growup.network.APIClient;
import com.example.xeus_labmacbook.growup.service.APIService;
import com.mukesh.tinydb.TinyDB;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import butterknife.Bind;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "SignupActivity";
    private Context mContext;
    private TinyDB tinyDB;

    @BindView(R.id.input_name) EditText _nameText;
//    @Bind(R.id.input_address) EditText _addressText;
    @BindView(R.id.input_email) EditText _emailText;
//    @Bind(R.id.input_mobile) EditText _mobileText;
    @BindView(R.id.input_password) EditText _passwordText;
//    @Bind(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_up);
        ButterKnife.bind(this);

        tinyDB = new TinyDB(getApplicationContext());
        mContext = this;

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();
                checkNetworkConnection();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        checkSignup();
    }

    public void signup() {
        Log.e(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUp.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString().trim().toLowerCase();
//        String address = _addressText.getText().toString();
        String email = _emailText.getText().toString().trim().toLowerCase();
//        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();

        // TODO: Implement your own signup logic here.

        APIService service = APIClient.getRetrofit().create(APIService.class);

        Call<RegisterModel> call = service.Register(email, password,name);

        call.enqueue(new Callback<RegisterModel>() {

            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {

                progressDialog.dismiss();

                Log.e(TAG,"Success");

                if(response.body().isError()== true){
                    onSignupFailed();
                }
                else{
                    tinyDB.putBoolean("check_sig",true);
                    tinyDB.putString("user_id",response.body().getId()+"");
                    tinyDB.putString("user_uid",response.body().getUid()+"");
                    tinyDB.putString("user_name",response.body().getUser().getName()+"");
                    tinyDB.putString("user_email",response.body().getUser().getEmail()+"");

                    onSignupSuccess();
//                    Intent intent = new Intent(getApplicationContext(), Home.class);
//                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                // handle execution failures like no internet connectivity
                progressDialog.dismiss();
                onSignupFailed();
                Log.e(TAG,"False");
            }
        });
    }


    public void onSignupSuccess() {
        Toast.makeText(getBaseContext(), "Signup Success", Toast.LENGTH_LONG).show();
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);

    }

    public void onSignupFailed() {
//        Toast.makeText(getBaseContext(), "Signup failed", Toast.LENGTH_LONG).show();
        createMessageDialog();
        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
//        String address = _addressText.getText().toString();
        String email = _emailText.getText().toString();
//        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

//        if (address.isEmpty()) {
//            _addressText.setError("Enter Valid Address");
//            valid = false;
//        } else {
//            _addressText.setError(null);
//        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

//        if (mobile.isEmpty() || mobile.length()!=10) {
//            _mobileText.setError("Enter Valid Mobile Number");
//            valid = false;
//        } else {
//            _mobileText.setError(null);
//        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
//
//        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
//            _reEnterPasswordText.setError("Password Do not match");
//            valid = false;
//        } else {
//            _reEnterPasswordText.setError(null);
//        }

        return valid;
    }

    private void checkSignup()
    {
        if(tinyDB.getBoolean("check_sig") == true)
        {
            Intent intent = new Intent(SignUp.this,Flowerpot.class);
            startActivity(intent);
        }

    }

    public void createMessageDialog(){
        new AlertDialog.Builder(SignUp.this)
                .setIcon(R.drawable.warning)
                .setTitle("Alert")
                .setMessage("Signup Fail !!")
                .show();
    }

    private void checkNetworkConnection(){
        ConnectivityManager connectMan =
                (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = connectMan.getActiveNetworkInfo(); //เครือข่ายที่กำลังเชื่อมต่อ
        String str = "";
        if(netInfo != null && netInfo.isConnected())  {
            str = "Connect with: " + netInfo.getTypeName();

        } else {
            str = "Not Connect";
            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        }

        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }


//    private void GetData(User user) {
//        APIService apiService = Config.getClient().create(APIService.class);
//
//        Call<User> call = apiService.CreateAcount(user);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                Toast.makeText(SignUp.this, "Excellent" + response.body().getId(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(SignUp.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        buttSignup = (Button)findViewById(R.id.btn_signup);
//        buttSignup.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_signup:
//                Intent access = new Intent(this, Dashboard.class);
//                startActivity(access);
//                break;
//        }
//    }
//}



