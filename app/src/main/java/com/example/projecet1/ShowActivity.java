package com.example.projecet1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        SharedPreferences sharedPre;
        sharedPre = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        RecyclerView recyclerView_item=findViewById(R.id.recycleviewItem);
        AdapterTeacher adapterTeacher=new AdapterTeacher();

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_item.setLayoutManager(layoutManager);

        recyclerView_item.setAdapter(adapterTeacher);

        adapterTeacher.setOnItemClickListener(new AdapterTeacher.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                TeacherClass teacher = new TeacherClass();

                String name = teacher.getNames().get(position);
                String family = teacher.getFamily().get(position);
                String teacherId = teacher.getTeacherIds().get(position);


                SharedPreferences sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("name", name);
                editor.putString("family", family);
                editor.putString("teacherId", teacherId);
                editor.apply();


            }
        });


    }



}
