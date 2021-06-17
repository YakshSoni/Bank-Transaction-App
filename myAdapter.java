package com.example.bank_sys;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myviewholder>
{
    private List<model> dataholder;
    view_members viewMembers;

    public myAdapter(view_members viewMembers,List<model> dataholder) {
        this.dataholder = dataholder;
        this.viewMembers=viewMembers;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        myviewholder myview = new myviewholder(view);
        myview.setOnClickListener(new myviewholder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               viewMembers.nextAcivity(position);

            }
        });
        return myview;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dusername.setText(dataholder.get(position).getName());
        holder.dphonenumber.setText(dataholder.get(position).getPhone_no());
        holder.dbalance.setText(dataholder.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }




}
