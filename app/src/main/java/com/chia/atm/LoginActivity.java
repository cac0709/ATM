package com.chia.atm;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       EditText eduid = findViewById(R.id.ed_userid);
        String uid = getSharedPreferences("ATM",MODE_PRIVATE).getString(
                "USERID","");
        eduid.setText(uid);
        MydbHelper helper = new MydbHelper(this,"expense.db",null,1);
        ContentValues values = new ContentValues();
        values.put("cdate", "2018-12-19");
        values.put("info", "Parking");
        values.put("amount", 30);
        helper.getWritableDatabase().insert("exp", null, values);


    }




    public void login(View view) {
        Log.d("LoginActivity", "login");
        String userid = ((EditText)findViewById(R.id.ed_userid)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.ed_passwd)).getText().toString();
        if ("yuchia".equals(userid) && "000000".equals(passwd)) {
            setResult(RESULT_OK);
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USERID",userid)
                    .apply();
            finish();
        }
    }
}

