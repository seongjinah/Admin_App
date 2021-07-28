package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminapp.Adapter.HouseListAdapter;
import com.example.adminapp.Data.House;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HouseListActivity extends AppCompatActivity {

    private static final String TAG = "HouseListActivity.java";

    private RecyclerView mRecyclerView;
    private ImageView mHouseListBack;

    private HouseListAdapter mAdapter;

    private List<House> mHouseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_list);

        init();
        getDataFromServer();
        //getDataFromCSV();

        //mListAdapter 만들기
        //mRecyclerView에 Adapter 달기기

    }

    private void init() {
        mHouseListBack = findViewById(R.id.house_list_btn_back);
        mHouseListBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mRecyclerView = findViewById(R.id.house_list_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(HouseListActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }

    private void getDataFromServer() {
        RESTApi mRESTApi = RESTApi.retrofit.create(RESTApi.class);
        mRESTApi.getList().enqueue(new Callback<List<House>>() {
            @Override
            public void onResponse(Call<List<House>> call, Response<List<House>> response) {
                List<House> Response = (List<House>) response.body();
                mHouseList = (ArrayList) Response;
            }

            @Override
            public void onFailure(Call<List<House>> call, Throwable throwable) {
                Toast.makeText(HouseListActivity.this, "승인대기 매물을 가져올 수 없습니다", Toast.LENGTH_SHORT).show();
                Log.d(TAG, throwable.getMessage());
            }
        });
    }

    private void getDataFromCSV() {

        InputStreamReader is = new InputStreamReader(getResources().openRawResource(R.raw.apartmentinfo));
        CSVReader reader = new CSVReader(is);
        List<String[]> list = null;
        try {
            list = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(House house : mHouseList) {
            String code = house.getCode();

            int idx = list.indexOf(new String[]{code, });

            Log.d(TAG, "idx: " + idx);
        }
    }
}