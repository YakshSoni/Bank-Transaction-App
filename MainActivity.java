package com.example.bank_sys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_v_members,btn_v_transact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_v_members=(Button)findViewById(R.id.btn_v_members);
        btn_v_transact=(Button)findViewById(R.id.btn_v_transact);


        btn_v_members.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,view_members.class);
                startActivity(intent);
               
            }
        });

        btn_v_transact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,list_history.class);
                startActivity(intent);

            }
        });
    }
}