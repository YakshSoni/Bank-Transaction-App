package com.example.bank_sys;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder {

    TextView dusername,dphonenumber,dbalance, mRupee, mRupeeslash, mName1, mName2, mDate, mTransc_status;
    ImageView mPhone, mArrow;
    View mView;
    public myviewholder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        dusername=(TextView)itemView.findViewById(R.id.disp_username);
        dphonenumber=(TextView)itemView.findViewById(R.id.disp_phonenumber);
        dbalance=(TextView)itemView.findViewById(R.id.disp_balance);
        mRupee = itemView.findViewById(R.id.rupee);
        mRupeeslash = itemView.findViewById(R.id.rupeeslash);
        mPhone = itemView.findViewById(R.id.phone);
        mName1 = itemView.findViewById(R.id.name1);
        mName2 = itemView.findViewById(R.id.name2);
        mDate = itemView.findViewById(R.id.date);
        mArrow = itemView.findViewById(R.id.arrow);
        mTransc_status = itemView.findViewById(R.id.transaction_status);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclicklistener.onItemClick(v,getAdapterPosition());
            }
        });

    }
    private myviewholder.ClickListener mclicklistener;
    public interface ClickListener{
        void onItemClick(View view,int position);
    }
    public void setOnClickListener(myviewholder.ClickListener clicklistener)
    {
        mclicklistener=clicklistener;
    }
}
