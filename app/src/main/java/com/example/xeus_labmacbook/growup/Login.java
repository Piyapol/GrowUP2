package com.example.xeus_labmacbook.growup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xeus_labmacbook.growup.model.ServerResponse;
import com.example.xeus_labmacbook.growup.network.APIClient;
import com.example.xeus_labmacbook.growup.service.APIService;
import com.mukesh.tinydb.TinyDB;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import butterknife.Bind;


public class Login extends AppCompatActivity  {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private  static  final int REQUEST_LOGIN = 0;

    private TinyDB tinyDB;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        tinyDB = new TinyDB(getApplicationContext());

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
                checkNetworkConnection();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        checkLogin();
    }


    public void login() {
        Log.e(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(Login.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString().trim().toLowerCase();
        String password = _passwordText.getText().toString().trim();



        APIService service = APIClient.getRetrofit().create(APIService.class);

        Call<ServerResponse> call = service.Login(email, password);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                progressDialog.dismiss();
//                onLoginSuccess();
                Log.e(TAG,"Success");

                if(response.body().isError()== true){
                   onLoginFailed();
                }
                else{

                    tinyDB.putBoolean("check_login", true);
                    tinyDB.putString("user_id", response.body().getId());
                    tinyDB.putString("user_uid", response.body().getUid());
                    tinyDB.putString("user_name", response.body().getUser().getName());
                    tinyDB.putString("user_email", response.body().getUser().getEmail());

                    onLoginSuccess();
                    Intent intent = new Intent(getApplicationContext(), Flowerpot.class);
                    startActivityForResult(intent, REQUEST_LOGIN);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                progressDialog.dismiss();
                onLoginFailed();
                Log.e(TAG,"False");
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public void onLoginFailed() {
//        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        createMessageDialog();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    public void createMessageDialog(){
        new AlertDialog.Builder(Login.this)
                .setIcon(R.drawable.warning)
                .setTitle("Alert")
                .setMessage("Login Fail !!")
               .show();
    }

    private void checkLogin()
    {
        if(tinyDB.getBoolean("check_login") == true)
        {
            Intent intent = new Intent(Login.this,Flowerpot.class);
            startActivity(intent);
        }

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
}