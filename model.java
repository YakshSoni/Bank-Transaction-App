package com.example.bank_sys;

public class model {
    String IFSC_code,acc_no,email,name,name1,name2,date,transaction_status;
    String phone_no;
    String balance;

    public model(String name, String phone_no, String balance) {
        this.name = name;
        this.phone_no = phone_no;
        this.balance = balance;
    }
    public model(String name1, String name2, String balance, String date, String transaction_status) {
        this.name1 = name1;
        this.name2 = name2;
        this.balance = balance;
        this.date = date;
        this.transaction_status = transaction_status;
    }
    public model(String name , String acc_no, String IFSC_code, String email , String phone_no,String balance) {
        this.IFSC_code = IFSC_code;
        this.acc_no = acc_no;
        this.email = email;
        this.name = name;
        this.phone_no = phone_no;
        this.balance = balance;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getIFSC_code() {
        return IFSC_code;
    }

    public void setIFSC_code(String IFSC_code) {
        this.IFSC_code = IFSC_code;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
