package com.example.bank_sys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class user_prof extends AppCompatActivity {

    ProgressDialog progressDialog;
    Double bal;
    TextView tv_m_name;
    TextView tv_m_contact;
    TextView tv_m_email;
    TextView tv_m_ifsc;
    TextView tv_m_accno;
    TextView tv_m_balance;
    String phonenumber;
    AlertDialog dialog;
    Button btn_transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_prof);

        tv_m_name=(TextView)findViewById(R.id.tv_m_name);
        tv_m_contact=(TextView)findViewById(R.id.tv_m_contact);
        tv_m_balance=(TextView)findViewById(R.id.tv_m_balance);
        tv_m_email=(TextView)findViewById(R.id.tv_m_email);
        tv_m_ifsc=(TextView)findViewById(R.id.tv_m_ifsc);
        tv_m_accno=(TextView)findViewById(R.id.tv_m_accno);


        btn_transfer=(Button)findViewById(R.id.btn_transfer);

        progressDialog=new ProgressDialog(user_prof.this);
        progressDialog.setTitle("Loading data..");
        progressDialog.show();

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null)
        {
            phonenumber=bundle.getString("phonenumber");
            showdata(phonenumber);
        }
        btn_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterAmount();
            }
        });

    }

    private void enterAmount() {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(user_prof.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_transfer_money, null);
        mBuilder.setTitle("Enter amount").setView(mView).setCancelable(false);

        final EditText mAmount = (EditText) mView.findViewById(R.id.enter_money);

        mBuilder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                transactionCancel();
            }
        });

        dialog = mBuilder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAmount.getText().toString().isEmpty()){
                    mAmount.setError("Amount can't be empty");
                }else if(Double.parseDouble(mAmount.getText().toString()) > bal){
                    mAmount.setError("Your account don't have enough balance");
                }else{
                    Intent intent = new Intent(user_prof.this,send_to.class);
                    intent.putExtra("phonenumber", tv_m_contact.getText().toString());
                    intent.putExtra("name", tv_m_name.getText().toString());
                    intent.putExtra("currentamount", bal.toString());
                    intent.putExtra("transferamount", mAmount.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void transactionCancel() {
        AlertDialog.Builder builder_exitbutton = new AlertDialog.Builder(user_prof.this);
        builder_exitbutton.setTitle("Do you want to cancel the transaction?").setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy, hh:mm a");
                        String date = simpleDateFormat.format(calendar.getTime());

                        new DBmange(user_prof.this).insertTransferData(date, tv_m_name.getText().toString(), "Not selected", "0", "Failed");
                        Toast.makeText(user_prof.this, "Transaction Cancelled!", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                enterAmount();
            }
        });
        AlertDialog alertexit = builder_exitbutton.create();
        alertexit.show();
    }

    private void showdata(String phonenumber) {
        Cursor cursor=new DBmange(this).readparticulardata(phonenumber);
        while (cursor.moveToNext())
        {
            bal=Double.parseDouble(cursor.getString(2));
            NumberFormat numberFormat=NumberFormat.getNumberInstance();
            String balance=numberFormat.format(bal);
            progressDialog.dismiss();
            tv_m_contact.setText(cursor.getString(0));
            tv_m_name.setText(cursor.getString(1));
            tv_m_ifsc.setText(cursor.getString(5));
            tv_m_email.setText(cursor.getString(3));
            tv_m_accno.setText(cursor.getString(4));
            tv_m_balance.setText(balance);
        }
    }
}