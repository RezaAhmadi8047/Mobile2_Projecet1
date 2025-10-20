package com.example.projecet1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class EnterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        EditText nameGet, familyGet, teacherIdGet;
        Intent intent=new Intent(EnterActivity.this,ShowActivity.class);

        nameGet=findViewById(R.id.name);
        familyGet=findViewById(R.id.family);
        teacherIdGet =findViewById(R.id.teacherId);

      Button btnSave = findViewById(R.id.btnSave) ;
      btnSave.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("WrongViewCast")
          @Override
          public void onClick(View v) {
               TeacherClass.addTeacher(nameGet.getText().toString(),familyGet.getText().toString(),teacherIdGet.getText().toString());

               nameGet.setText("");
               familyGet.setText("");
               teacherIdGet.setText("");

          }
      });

      Button btnShow=findViewById(R.id.btnShow);
      btnShow.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(intent);
          }
      });
    }
}
