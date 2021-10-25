package com.vinayak.persondetailsdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class Add_person extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5, et6;
    Button sub;
    String fname, lname, mno, email, city, address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person);

        et1 = (EditText) findViewById(R.id.fname_addperson);
        et2 = (EditText) findViewById(R.id.lname_addperson);
        et3 = (EditText) findViewById(R.id.mno_addperson);
        et4 = (EditText) findViewById(R.id.email_addperson);
        et5 = (EditText) findViewById(R.id.city_addperson);
        et6 = (EditText) findViewById(R.id.add_addperson);
        sub = (Button) findViewById(R.id.add_addperson_btn_sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fname = et1.getText().toString();
                lname = et2.getText().toString();
                mno = et3.getText().toString();
                email = et4.getText().toString();
                city = et5.getText().toString();
                address = et6.getText().toString();

                if (fname.isEmpty() && lname.isEmpty() && mno.isEmpty() && email.isEmpty() && city.isEmpty() && address.isEmpty()) {
                    Toast.makeText(Add_person.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                } else {
                    Insert();
                    Toast.makeText(Add_person.this, "Your Value" + fname + lname + mno + email + city + address + "Added Successful", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


    private void Insert() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.CreateAccount(
                fname,lname,mno,email,city,address
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