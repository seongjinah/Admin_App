package com.example.adminapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adminapp.Data.Broker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrokerDetailActivity extends AppCompatActivity {

    private static final String TAG = "BrokerDetailActivity";

    private Broker mBroker;

    private ImageView mBack;
    private ImageView mConfirmation;
    private TextView mAllow;
    private TextView mDisallow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker_detail);

        Intent intent = getIntent();
        mBroker = (Broker) intent.getSerializableExtra("broker");
        Log.d(TAG, mBroker.toString());

        mBack = findViewById(R.id.broker_detail_btn_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mConfirmation = findViewById(R.id.broker_detail_confirmation);
        Glide.with(getApplicationContext()).load(mBroker.getLicense().getCertificateURL()).into(mConfirmation);

        mAllow = findViewById(R.id.broker_detail_btn_allow);
        mDisallow = findViewById(R.id.broker_detail_btn_disallow);

        mAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_check, null);

                TextView mComment = view.findViewById(R.id.dialog_check_comment);
                TextView mSend = view.findViewById(R.id.dialog_check_send_btn);
                TextView mCancel = view.findViewById(R.id.dialog_check_cancel_btn);

                mComment.setText(R.string.dialog_check_broker_allow);
                mSend.setText(R.string.dialog_check_send_btn);

                AlertDialog dialog = new AlertDialog.Builder(BrokerDetailActivity.this)
                        .setView(view)
                        .create();

                mSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        allow(mBroker.getUserId());
                    }
                });

                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mDisallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_check, null);

                TextView mComment = view.findViewById(R.id.dialog_check_comment);
                TextView mSend = view.findViewById(R.id.dialog_check_send_btn);
                TextView mCancel = view.findViewById(R.id.dialog_check_cancel_btn);

                mComment.setText(R.string.dialog_check_broker_disallow);
                mSend.setText(R.string.dialog_check_send_btn);

                AlertDialog dialog = new AlertDialog.Builder(BrokerDetailActivity.this)
                        .setView(view)
                        .create();

                mSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        disallow(mBroker.getUserId());
                    }
                });

                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void allow(String userId) {
        RESTApi mRESTApi = RESTApi.retrofit.create(RESTApi.class);
        mRESTApi.changeAllowMember(userId).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(BrokerDetailActivity.this, "공인중개사 허가", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable throwable) {
                Log.d(TAG, throwable.getMessage());
                Toast.makeText(BrokerDetailActivity.this, "서버와 통신이 원활하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void disallow(String userId) {
        RESTApi mRESTApi = RESTApi.retrofit.create(RESTApi.class);
        mRESTApi.changeRejectMember(userId).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(BrokerDetailActivity.this, "공인중개사 반려", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable throwable) {
                Log.d(TAG, throwable.getMessage());
                Toast.makeText(BrokerDetailActivity.this, "서버와 통신이 원활하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}