package com.tts.addressBook;

public class AddressRow {
    private String FName;
    private String LName ;
    private String Number;
    private String email ;

    //constructor
    public AddressRow(String FName, String LName, String number, String email) {
        this.FName = FName;
        this.LName = LName;
        Number = number;
        this.email = email;
    }

    //getter & setter methods
    public String getFName(){
        return this.FName ;

    }

    public String getLName(){
        return this.LName ;

    }
    public String getNumber(){
        return this.Number;
    }

    public String getEmail(){
        return this.email ;
    }

    public void updateAddressEntry(String FName, String LName, String Number, String email){
        this.FName = FName ;
        this.LName = LName ;
        this.Number = Number ;
        this.email = email ;

    }

}
