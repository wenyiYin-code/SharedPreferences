package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveData = (Button) findViewById(R.id.save_data);
        Button restoreData = (Button) findViewById(R.id.restore_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","tom");
                editor.putInt("age",16);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });

        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                Log.d(TAG, "name："+ pref.getString("name",""));
                Log.d(TAG, "age："+ pref.getInt("age",0));
                Log.d(TAG, "married："+ pref.getBoolean("married",true));
            }
        });
    }
}