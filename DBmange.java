package com.example.bank_sys;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmange extends SQLiteOpenHelper {
    private static final String dbname="Users";
    private static final String tbl_user="Userdetail";
    private static final String tbl_transact="Transactiondetails";
    public DBmange(@Nullable Context context) {
        super(context,dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdetail (PHONENUMBER char(10) PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table Transactiondetails (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into Userdetail values('9874564630','Rushi',13000.00,'harshit@gmail.com','XXXXXXXXXXXX1234','ABC09876543')");
        db.execSQL("insert into Userdetail values('9737123564','bakul',7820.67,'ashok@gmail.com','XXXXXXXXXXXX2341','BCA98765432')");
        db.execSQL("insert into Userdetail values('9222592222','Chetan',11359.56,'chetan@gmail.com','XXXXXXXXXXXX3412','CAB87654321')");
        db.execSQL("insert into Userdetail values('9335335333','Parth',15400.01,'parth@gmail.com','XXXXXXXXXXXX4123','ABC76543210')");
        db.execSQL("insert into Userdetail values('8443444494','Rahul',26033.48,'rahul@gmail.com','XXXXXXXXXXXX2345','BCA65432109')");
        db.execSQL("insert into Userdetail values('9550355525','Roshani',9450.16,'roshani@gmail.com','XXXXXXXXXXXX3452','CAB54321098')");
        db.execSQL("insert into Userdetail values('9616646066','Gita',35936.00,'gita@gmail.com','XXXXXXXXXXXX4523','ABC43210987')");
        db.execSQL("insert into Userdetail values('9170774757','Vishnu',8579.22,'vishnu@gmail.com','XXXXXXXXXXXX5234','BCA32109876')");
        db.execSQL("insert into Userdetail values('7283563412','Salman',43398.46,'salman@gmail.com','XXXXXXXXXXXX3456','CAB21098765')");
        db.execSQL("insert into Userdetail values('1234567890','Sam',27331.00,'sam@gmail.com','XXXXXXXXXXXX4563','ABC10987654')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Userdetail");
        db.execSQL("drop Table if exists Transactiondetails");
        onCreate(db);
    }
    public Cursor readall(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Userdetail",null);
        return cursor;
    }
    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetail where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetail except select * from Userdetail where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update Userdetail set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Transactiondetails", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(tbl_transact, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
