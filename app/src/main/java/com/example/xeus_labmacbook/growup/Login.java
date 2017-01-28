package com.example.xeus_labmacbook.growup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button buttLogin;
    private TextView Linksignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttLogin = (Button)findViewById(R.id.buttLogin);
        buttLogin.setOnClickListener(this);

        Linksignup = (TextView)findViewById(R.id.Linksignup);
        Linksignup.setOnClickListener(this);
        
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.buttLogin:
                Intent access = new Intent(this, Dashboard.class);
                startActivity(access);
                break;

            case R.id.Linksignup:
                Intent link = new Intent(this, SignUp.class);
                startActivity(link);
                break;
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_login, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
