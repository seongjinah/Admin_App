package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCardHouse, mCardBroker;
    private TextView mTextHouse, mTextBroker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardHouse = findViewById(R.id.main_card_house);
        mCardBroker = findViewById(R.id.main_card_broker);
        mTextHouse = findViewById(R.id.main_text_house);
        mTextBroker = findViewById(R.id.main_text_broker);

        mCardHouse.setOnClickListener(this);
        mCardBroker.setOnClickListener(this);
        mTextHouse.setOnClickListener(this);
        mTextBroker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_card_house:
            case R.id.main_text_house:
                Intent intent_house = new Intent(MainActivity.this, HouseListActivity.class);
                intent_house.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_house);
                break;

            case R.id.main_card_broker:
            case R.id.main_text_broker:
                Intent intent_broker = new Intent(MainActivity.this, BrokerListActivity.class);
                intent_broker.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_broker);
                break;
        }
    }
}