package com.example.bank_sys;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapterSendToUser extends RecyclerView.Adapter<myviewholder> {

    send_to sendto;
    List<model> modelList;
    Context context;

    public CustomeAdapterSendToUser(send_to sentoUser, List<model> modelList) {
        this.sendto = sentoUser;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);

        myviewholder viewHolder = new myviewholder(itemView);
        viewHolder.setOnClickListener(new myviewholder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                sendto.selectuser(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dusername.setText(modelList.get(position).getPhone_no());
        holder.dphonenumber.setText(modelList.get(position).getName());
        holder.dbalance.setText(modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    /*public void setFilter(ArrayList<model> newList){
        modelList = new ArrayList<>();
        modelList.addAll(newList);
        notifyDataSetChanged();
    }*/
}
