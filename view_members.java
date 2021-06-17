package com.example.bank_sys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class view_members extends AppCompatActivity {
    RecyclerView recyclerView;
   List<model> dataholder = new ArrayList<>();
   String phonenumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_members);

        recyclerView=(RecyclerView)findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new DBmange(this).readall();

        while (cursor.moveToNext())
        {
            Double bal=Double.parseDouble(cursor.getString(2));
            NumberFormat numberFormat=NumberFormat.getNumberInstance();
            String balance=numberFormat.format(bal);
            model obj=new model(cursor.getString(1),cursor.getString(0),balance);
            dataholder.add(obj);
        }

        myAdapter adapter=new myAdapter(view_members.this,dataholder);
        recyclerView.setAdapter(adapter);

    }
    public void nextAcivity(int position)
    {
        phonenumber=dataholder.get(position).getPhone_no();
        Intent intent=new Intent(view_members.this,user_prof.class);
        intent.putExtra("phonenumber",phonenumber);
        startActivity(intent);

    }
}