package com.example.projecet1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String family = intent.getStringExtra("family");
        String teacherId = intent.getStringExtra("teacherId");

        TextView infoTecher = findViewById(R.id.infoTecher);
        infoTecher.setText("نام: " + name + "\n"
                + "نام خانوادگی: " + family + "\n"
                + "شماره استاد: " + teacherId);

        SharedPreferences sharedPre;
        sharedPre = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        infoTecher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPre.edit();
                editor.putString("saved_text", infoTecher.getText().toString());
                editor.apply();
            }
        });

    }



}
