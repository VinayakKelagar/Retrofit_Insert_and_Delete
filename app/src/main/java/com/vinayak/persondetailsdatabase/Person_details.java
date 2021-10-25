package com.vinayak.persondetailsdatabase;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Person_details extends AppCompatActivity {

    TextView f1, f2, f3, f4, f5, f6;
    String mobile;
    List<person> productList;
    SharedPrefHandler shp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_details);

//        TO get the value from the server
        shp = new SharedPrefHandler(this);
        mobile = shp.getSharedPreferences("mno");
        Toast.makeText(Person_details.this, "Get Value" + mobile, Toast.LENGTH_SHORT).show();


        f1 = (TextView) findViewById(R.id.person_details_fname);
        f2 = (TextView) findViewById(R.id.person_details_lname);
        f3 = (TextView) findViewById(R.id.person_details_mno);
        f4 = (TextView) findViewById(R.id.person_details_email);
        f5 = (TextView) findViewById(R.id.person_details_city);
        f6 = (TextView) findViewById(R.id.person_details_address);

        getPersonDetails(mobile);
    }



    private void getPersonDetails(final String mobile) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<person>> call = api.getPersonDetails(mobile);

        call.enqueue(new Callback<List<person>>() {
            @Override
            public void onResponse(Call<List<person>> call, Response<List<person>> response) {
                productList = response.body();
                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    f1.setText( productList.get(0).getfname());
                    f2.setText( productList.get(0).getlname());
                    f3.setText( productList.get(0).getmno());
                    f4.setText( productList.get(0).getemail());
                    f5.setText( productList.get(0).getcity());
                    f6.setText( productList.get(0).getaddress());
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<person>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
