package com.chia.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void next (View view){
        EditText AGE = findViewById(R.id.age);
         float userage = Float.parseFloat(AGE.getText().toString());
        getSharedPreferences("user",MODE_PRIVATE)
                .edit()
                .putString("age", String.valueOf(userage))
                .apply();
        Intent gender = new Intent(this,genderActivity.class);
        startActivity(gender);
    }
    public void back(View view) {
        finish();
   }
}


