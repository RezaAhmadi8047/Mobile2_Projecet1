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
        String name,family,techerId;
        Intent intent=new Intent(EnterActivity.this,ShowActivity.class);

        nameGet=findViewById(R.id.name);
        familyGet=findViewById(R.id.family);
        teacherIdGet =findViewById(R.id.techerId);

      Button btnSave = findViewById(R.id.btnSave) ;
      btnSave.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("WrongViewCast")
          @Override
          public void onClick(View v) {
              String name=nameGet.getText().toString();
              String family=familyGet.getText().toString();
              String techerId=teacherIdGet.getText().toString();

               intent.putExtra("name",name);
               intent.putExtra("family",family);
               intent.putExtra("techerId",techerId);
               startActivity(intent);

          }
      });

    }
}
