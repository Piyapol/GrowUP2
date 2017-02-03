package com.example.xeus_labmacbook.growup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button buttSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttSignup = (Button)findViewById(R.id.btn_signup);
        buttSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_signup:
                Intent access = new Intent(this, Dashboard.class);
                startActivity(access);
                break;
        }
    }
}
