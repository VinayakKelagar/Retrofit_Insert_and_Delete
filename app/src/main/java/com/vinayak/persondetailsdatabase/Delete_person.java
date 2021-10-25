package com.vinayak.persondetailsdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Delete_person extends AppCompatActivity {

    EditText mno;
    String mobile;
    Button sub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_person);

        mno=(EditText) findViewById(R.id.delete_person_mno);
        sub=(Button) findViewById(R.id.delete_person_sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobile=mno.getText().toString();

                if(mobile.isEmpty())
                {
                    Toast.makeText(Delete_person.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Delete();
                    Intent intent = new Intent(Delete_person.this, Person_details.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void Delete() {
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