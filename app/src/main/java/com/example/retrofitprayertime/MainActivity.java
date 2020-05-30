package com.example.retrofitprayertime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofitprayertime.datas.Data;
import com.example.retrofitprayertime.datas.DataClass;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    JsonPlaceHolderApi jsonPlaceHolderApi;

    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText=findViewById(R.id.textViewList);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.aladhan.com/v1/")
//                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);


        checkDat();



    }

    private void checkDat(){
        Call<DataClass> call=jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<DataClass>() {
            @Override
            public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                if (!response.isSuccessful()) {
                    myText.setText(response.code());
                    return;
                }

                DataClass datas =  response.body();


                    String content="";

                    content+="Fajar: "+datas.getData().getTimings().getAsr()+"\n";
//                    content+="Juhur: "+datas.getJuhur()+"\n";
                Log.d("cont_tent_a", "contnt: "+content);
                    myText.append(content);

            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t) {
                myText.setText(t.getMessage());
            }
        });
    }


//    private void myData(){
//        Map<String, String>parameter=new HashMap<>();
//        parameter.put("city", "Dhaka");
//        parameter.put("country", "Bangladesh");
//        Call<List<Data>> call=jsonPlaceHolderApi.getMap(parameter);
//        call.enqueue(new Callback<List<Data>>() {
//            @Override
//            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
//                if (!response.isSuccessful()) {
//                    myText.setText(response.code());
//                    return;
//                }
//                List<Data> datas=response.body();
//                for (Data data:datas){
//                    String content="";
//                    content+="Fajar: "+data.getFajr()+"\n";
//                    content+="Juhur: "+data.getJuhur()+"\n";
//
//                    Log.d("checkVal " ,data.getFajr());
//                    Log.d("checkVal",data.getJuhur());
//
//                    myText.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Data>> call, Throwable t) {
//                myText.setText(t.getMessage());
//            }
//        });
//    }
}
