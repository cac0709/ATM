package com.chia.atm;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean logon = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
            RecyclerView recyclerView = findViewById(R.id.recycler);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new FruitAdapter());
        }
        //listView();
    }
    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder>{

    }



        private void listView() {
        List<String> fruits = Arrays.asList("香蕉","鳳梨","芭樂");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                logon = true;
                String nickname = getSharedPreferences("user", MODE_PRIVATE)
                        .getString("NICKNAME", null);
                int age = getSharedPreferences("user", MODE_PRIVATE)
                        .getInt("NICKNAME", 0);
                int gender = getSharedPreferences("user", MODE_PRIVATE)
                        .getInt("NICKNAME", 0);
                if (nickname == null || age == 0 || gender == 0) {
                    Intent nick = new Intent(this, NicknameActivity.class);
                    startActivity(nick);

                }
                TextView nickText = findViewById(R.id.ednick);
                nickText.setText("your nickname is"+nickname);
            }
        }
    }
}

