package com.example.hw999;

import android.util.Log;

/**
 * Created by donezio on 11/24/2016.
 */

public class bills {
    public String billid;
    public String stitle;
    public String ltitle;
    public String introduce;
    public String sponsor;
    public String[] monthNames = {
            "January", "February", "March",
            "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December"
    };

    public bills() {
        this.billid = "placeholder";
        this.stitle = "placeholder";
        this.introduce = "placeholder";
        this.ltitle = "placeholder";
    }

    public String getSponsor(){
        return sponsor;
    }
    public void setSponsor(String p){
        this.sponsor = p;;
    }

    public String getId(){
        return billid;
    }
    public void setBillid(String id){
        this.billid = id;
    }

    public void setsTitle(String title){
        this.stitle = title;
    }

    public void setlTitle(String title){
        this.ltitle = title;
    }

    public String getTitle(){
        if(stitle.equals("null"))
            return ltitle;
        else
            return stitle;
    }

    public String getIntroduce(){
        //return introduce;
        String year = introduce.substring(0,4);
        String mon  = introduce.substring(5,7);
        String day  = introduce.substring(8,10);
        int mon1      = Integer.parseInt(mon);

        return monthNames[mon1-1] + " " + day + "  " + year;
    }

    public void setIntroduce(String introduce){
        this.introduce = introduce;



    }


    public boolean equals(Object other){
        Log.d("equals","is called");
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof bills))return false;
        bills temp1 = (bills)other;
        if(temp1.getId().equals(this.billid)){
            return true;
        }
        else{
            return false;
        }
    }

    public int getYear(){
        return  Integer.parseInt(introduce.substring(0,4));
    }
    public int getMonth(){
        return  Integer.parseInt(introduce.substring(5,7));
    }
    public int getDay(){
        return  Integer.parseInt(introduce.substring(8,10));
    }

    public String getRealIntroduce(){
        return this.introduce;
    }

    public String getLtitle(){
        return this.ltitle;
    }

    public String getStitle(){
        return this.stitle;
    }

}
