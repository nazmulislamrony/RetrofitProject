package com.example.retrofitprayertime;

import com.example.retrofitprayertime.datas.DataClass;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET
    Call<DataClass> getPost(Response<DataClass> response);
}
