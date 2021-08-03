package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminapp.Adapter.BrokerListAdapter;
import com.example.adminapp.Data.Broker;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrokerListActivity extends AppCompatActivity {

    private List<Broker> mBrokerList;

    private TextView mCount;
    private ImageView mBrokerListBack;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker_list);

        init();
        getData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }

    private void getData() {

        mBrokerList = new ArrayList<>();

        RESTApi restApi = RESTApi.retrofit.create(RESTApi.class);
        restApi.getBrokerList().enqueue(new Callback<List<Broker>>() {
            @Override
            public void onResponse(Call<List<Broker>> call, Response<List<Broker>> response) {
                String code = response.headers().get("code");
                if(code.equals("00")){
                    mBrokerList = response.body();

                    mCount.setText(mBrokerList.size() + "개의 공인중개사 승인대기중");

                    BrokerListAdapter brokerListAdapter = new BrokerListAdapter(BrokerListActivity.this, mBrokerList);
                    mRecyclerView.setAdapter(brokerListAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Broker>> call, Throwable throwable) {

            }
        });
    }

    private void init() {
        mCount = findViewById(R.id.broker_list_count);

        mBrokerListBack = findViewById(R.id.broker_list_btn_back);
        mBrokerListBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mRecyclerView = findViewById(R.id.broker_list_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BrokerListActivity.this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}