package com.example.adminapp;

import com.example.adminapp.Data.Broker;
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

    //매물 리스트 가져오기
    @POST("/board/get/uncheckedList")
    Call<List<House>> getHouseList();

    //매물 허가
    @POST("/auth/reliable")
    Call<Boolean> changeAllowHouse(
            @Query("idx") Long idx);

    //매물 반려
    @POST("/auth/rejection")
    Call<Boolean> changeRejectionHouse(
            @Query("idx") Long idx);

    //공인중개사 가져오기
    @POST("/auth/getReady")
    Call<List<Broker>> getBrokerList();

    //공인중개사 허가
    @POST("/auth/qualification")
    Call<Boolean> changeAllowMember(
            @Query("userId") String userId);

    //공인주개사 반려
    @POST("/auth/rejectMember")
    Call<Boolean> changeRejectMember(
            @Query("userId") String userId);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://122.37.239.49:9000/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
            .build();
}
