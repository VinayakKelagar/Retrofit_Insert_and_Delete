package com.vinayak.persondetailsdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class View_person extends AppCompatActivity {

    EditText mno;
    Button sub, viewall;
    String mobile;
    SharedPrefHandler shp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_person);

        shp = new SharedPrefHandler(this);


        mno = (EditText) findViewById(R.id.view_person_mno);
        sub = (Button) findViewById(R.id.view_person_sub);
        viewall = (Button) findViewById(R.id.view_person_vall);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = mno.getText().toString();

                if (mobile.isEmpty()) {
                    Toast.makeText(View_person.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                } else {
                    shp.setSharedPreferences("mno", mobile);
//                    Intent i= new Intent(getApplicationContext(),Person_details.class);      ------------ this also works with the one line in it
                    Toast.makeText(View_person.this, "You have entered" + mobile, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(View_person.this, Person_details.class);
                    startActivity(intent);
                }
            }
        });

    }
}