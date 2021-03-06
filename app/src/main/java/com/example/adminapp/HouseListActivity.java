package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.Adapter.HouseListAdapter;
import com.example.adminapp.Data.House;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HouseListActivity extends AppCompatActivity {

    private static final String TAG = "HouseListActivity.java";

    private RecyclerView mRecyclerView;
    private ImageView mHouseListBack;
    private TextView mHouseCount;

    private List<House> mHouseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_list);

        init();
        getData();
    }

    private void init() {
        mHouseListBack = findViewById(R.id.house_list_btn_back);
        mHouseListBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mHouseCount = findViewById(R.id.house_list_count);

        mRecyclerView = findViewById(R.id.house_list_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(HouseListActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }

    private void getData() {

        mHouseList = new ArrayList<>();

        RESTApi mRESTApi = RESTApi.retrofit.create(RESTApi.class);
        mRESTApi.getHouseList().enqueue(new Callback<List<House>>() {
            @Override
            public void onResponse(Call<List<House>> call, Response<List<House>> response) {
                List<House> Response = (List<House>) response.body();
                mHouseList = (ArrayList) Response;

                mHouseCount.setText(mHouseList.size() + "?????? ?????? ???????????????");
                HouseListAdapter houseListAdapter = new HouseListAdapter(mHouseList, HouseListActivity.this);
                mRecyclerView.setAdapter(houseListAdapter);
//                getDataFromCSV();
            }

            @Override
            public void onFailure(Call<List<House>> call, Throwable throwable) {
                Toast.makeText(HouseListActivity.this, "???????????? ????????? ????????? ??? ????????????", Toast.LENGTH_SHORT).show();
                Log.d(TAG, throwable.getMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }
}