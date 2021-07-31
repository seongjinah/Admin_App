package com.example.adminapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.Data.House;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HouseDetailActivity extends AppCompatActivity {

    private static final String TAG = "HouseDetailActivity";
    private static final int REQUEST_CODE_ALLOW = 1;
    private static final int REQUEST_CODE_DISALLOW = 2;

    private TextView mHouseAddress;
    private TextView mHouseArea;
    private TextView mHouseProprietary;
    private TextView mAllow;
    private TextView mDisAllow;

    private House mHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        mHouseAddress = findViewById(R.id.house_detail_address);
        mHouseArea = findViewById(R.id.house_detail_area);
        mHouseProprietary = findViewById(R.id.house_detail_proprietary);
        mAllow = findViewById(R.id.house_detail_btn_allow);
        mDisAllow = findViewById(R.id.house_detail_btn_disallow);

        Intent intent = getIntent();
        mHouse = (House) intent.getSerializableExtra("house");

        mHouseAddress.setText(mHouse.getAddress() + " " + mHouse.getResidence_name() + " " +
                mHouse.getDong() + "동 " + mHouse.getHo() + "호");
        mHouseArea.setText(mHouse.getNet_leaseable_area() + "m²");

        String seller = mHouse.getSellerName() + " (" + mHouse.getSellerIdNum() + "-******)";
        mHouseProprietary.setText(seller);

        mAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_check, null);

                TextView mComment = view.findViewById(R.id.dialog_check_comment);
                TextView mSend = view.findViewById(R.id.dialog_check_send_btn);
                TextView mCancel = view.findViewById(R.id.dialog_check_cancel_btn);

                mComment.setText(R.string.dialog_check_allow);
                mSend.setText(R.string.dialog_check_send_btn);

                AlertDialog dialog = new AlertDialog.Builder(HouseDetailActivity.this)
                        .setView(view)
                        .create();

                mSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        allow(mHouse.getIdx());
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

        mDisAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_check, null);

                TextView mComment = view.findViewById(R.id.dialog_check_comment);
                TextView mSend = view.findViewById(R.id.dialog_check_send_btn);
                TextView mCancel = view.findViewById(R.id.dialog_check_cancel_btn);

                mComment.setText(R.string.dialog_check_disallow);
                mSend.setText(R.string.dialog_check_send_btn);

                AlertDialog dialog = new AlertDialog.Builder(HouseDetailActivity.this)
                        .setView(view)
                        .create();

                mSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        disallow(mHouse.getIdx());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "취소됨!", Toast.LENGTH_SHORT).show();
        }

        if(requestCode == REQUEST_CODE_ALLOW){
            Toast.makeText(this, "allow!!", Toast.LENGTH_SHORT).show();
//            allow(mHouse.getIdx());
        } else if(requestCode == REQUEST_CODE_DISALLOW) {
//            disallow(mHouse.getIdx());
            Toast.makeText(this, "disAllow!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void allow(Long idx) {
        RESTApi mRESTApi = RESTApi.retrofit.create(RESTApi.class);
        mRESTApi.changeReliable(idx).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                finish();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable throwable) {
                Log.d(TAG, throwable.getMessage());
                Toast.makeText(HouseDetailActivity.this, "서버와 통신이 원활하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void disallow(Long idx) {
        RESTApi mRESTApi = RESTApi.retrofit.create(RESTApi.class);
        mRESTApi.changeRejection(idx).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                finish();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable throwable) {
                Log.d(TAG, throwable.getMessage());
                Toast.makeText(HouseDetailActivity.this, "서버와 통신이 원활하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}