package com.chia.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText ed_userid;
    private EditText ed_passwd;
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void login(View view) {
        Log.d("LoginActivity", "login");
        ed_userid = findViewById(R.id.ed_userid);
        ed_passwd = findViewById(R.id.ed_passwd);
        username = ed_userid.getText().toString();
        password = ed_passwd.getText().toString();
        if ("yuchia".equals(username) && "000000".equals(password)) {
            finish();

        }
        }
    public void cancel(View view){
        Log.d("LoginActivity","cancel");
    }

}

