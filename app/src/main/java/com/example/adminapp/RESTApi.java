package com.example.adminapp;

import com.example.adminapp.Data.House;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RESTApi {

    final String BASE_URL = "http://122.37.239.49:9000/";

    @Headers(value = "Content-Type: application/json")

    @POST("/board/get/uncheckedList")
    Call<List<House>> getList();

    @POST("/auth/reliable")
    Call<Boolean> changeReliable(
            @Query("idx") Long idx);

    @POST("/auth/rejection")
    Call<Boolean> changeRejection(
            @Query("idx") Long idx);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://122.37.239.49:9000/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
            .build();
}
