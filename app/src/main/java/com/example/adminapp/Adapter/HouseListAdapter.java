package com.example.adminapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.Data.House;
import com.example.adminapp.HouseDetailActivity;
import com.example.adminapp.R;

import java.util.List;

public class HouseListAdapter extends RecyclerView.Adapter<HouseListAdapter.ViewHolder> {

    private List<House> mHouseList;
    private Context mContext;

    public HouseListAdapter(List<House> houseList, Context context) {
        mHouseList = houseList;
        mContext = context;
    }

    @NonNull
    @Override
    public HouseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_house_list, parent, false);
        return new HouseListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseListAdapter.ViewHolder holder, int position) {
        House house = mHouseList.get(position);

        String house_name = house.getResidence_name() + " " + house.getHo() + "호 " + house.getDong() + "동";
        holder.mTextHouse.setText(house_name);
        holder.mTextBargainer.setText(house.getSellerName());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HouseDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("house", house);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHouseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView mTextHouse, mTextBargainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mCardView = itemView.findViewById(R.id.item_house_list_card_view);
            mTextHouse = itemView.findViewById(R.id.item_house_list_text_home);
            mTextBargainer = itemView.findViewById(R.id.item_house_list_text_bargainer);
        }
    }
}
