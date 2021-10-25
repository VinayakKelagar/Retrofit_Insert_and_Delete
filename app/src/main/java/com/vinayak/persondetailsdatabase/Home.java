package com.vinayak.persondetailsdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        b1=(Button) findViewById(R.id.home_ap);
        b2=(Button) findViewById(R.id.home_vp);
        b3=(Button) findViewById(R.id.home_dp);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenti = new Intent(Home.this,Add_person.class);
                startActivity(intenti);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentj = new Intent(Home.this,View_person.class);
                startActivity(intentj);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentk = new Intent(Home.this,Delete_person.class);
                startActivity(intentk);
            }
        });
    }
}
