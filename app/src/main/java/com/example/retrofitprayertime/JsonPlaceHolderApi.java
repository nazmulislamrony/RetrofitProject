package com.example.retrofitprayertime;

import com.example.retrofitprayertime.datas.DataClass;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("/timingsByCity")
    Call<DataClass> getPost(@Query("city") String city, @Query("country") String country);
}
