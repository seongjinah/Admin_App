package com.example.adminapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.BrokerDetailActivity;
import com.example.adminapp.Data.Broker;
import com.example.adminapp.R;

import java.util.List;

public class BrokerListAdapter extends RecyclerView.Adapter<BrokerListAdapter.ViewHolder> {

    private Context mContext;
    private List<Broker> mBrokers;

    public BrokerListAdapter(Context context, List<Broker> brokers) {
        mContext = context;
        mBrokers = brokers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_broker_list, parent, false);
        return new BrokerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Broker broker = mBrokers.get(position);
        holder.broker_name.setText(broker.getName() + " (" + broker.getIdNum() + "-******)");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BrokerDetailActivity.class);
                intent.putExtra("broker", broker);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBrokers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView broker_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            broker_name = itemView.findViewById(R.id.item_broker_list_name);
        }
    }
}
