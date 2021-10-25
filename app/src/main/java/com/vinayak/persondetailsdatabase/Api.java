package com.vinayak.persondetailsdatabase;

import android.app.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://christological-art.000webhostapp.com/api/";

    @POST("https://anhedonic-comfort.000webhostapp.com/API%20For%20Person%20Database/insert_api.php")
    Call<IsExist> CreateAccount(
            @Query("f1") String fname,
            @Query("f2") String lname,
            @Query("f3") String mno,
            @Query("f4") String email,
            @Query("f5") String city,
            @Query("f6") String address
    );

    @POST("https://anhedonic-comfort.000webhostapp.com/API%20For%20Person%20Database/delete_api.php")
    Call<IsExist> DeleteAccount(
            @Query("f3") String mno );

    @GET("https://anhedonic-comfort.000webhostapp.com/API%20For%20Person%20Database/display_api.php")
    Call<List<person>> getPersonDetails(
            @Query("f3") String mobile);
}

