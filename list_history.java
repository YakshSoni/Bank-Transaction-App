package com.example.bank_sys;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class list_history extends AppCompatActivity {
    List<model> modelList_historylist = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomeAdapterHistory adapter;

    TextView history_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transact_history);

        mRecyclerView = findViewById(R.id.transact_recview);
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        history_empty = findViewById(R.id.empty_text);
        showData();
    }

    private void showData() {
        modelList_historylist.clear();
        Cursor cursor = new com.example.bank_sys.DBmange(this).readtransferdata();

        while (cursor.moveToNext()) {
            String balancefromdb = cursor.getString(4);
            Double balance = Double.parseDouble(balancefromdb);

            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setGroupingUsed(true);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            String price = nf.format(balance);

            model model = new model(cursor.getString(2), cursor.getString(3), price, cursor.getString(1), cursor.getString(5));
            modelList_historylist.add(model);
        }

        adapter = new CustomeAdapterHistory(list_history.this, modelList_historylist);
        mRecyclerView.setAdapter(adapter);

        if(modelList_historylist.size() == 0){
            history_empty.setVisibility(View.VISIBLE);
        }

    }

}
