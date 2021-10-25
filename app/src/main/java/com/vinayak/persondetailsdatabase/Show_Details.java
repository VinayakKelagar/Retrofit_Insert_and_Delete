package com.vinayak.persondetailsdatabase;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Show_Details extends AppCompatActivity {

    EditText mno,name;
    String mobile,fname;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        mno=(EditText) findViewById(R.id.delete_person_mno);
        name=(EditText) findViewById(R.id.delete_person_name);
        sub=(Button) findViewById(R.id.delete_person_sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobile=mno.getText().toString();
                fname=name.getText().toString();

                if(mobile.isEmpty() && fname.isEmpty())
                {
                    Toast.makeText(Show_Details.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Show();
                    Intent intent = new Intent(Show_Details.this, Person_details.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void Show() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.DeleteAccount(
                mobile
        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if (responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if (isSuccess) {

//                    showCreateSuccessToast();

                } else {
                    // Show Creation Failed Message
//                    showCreateFailedToast();
                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                //  Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}