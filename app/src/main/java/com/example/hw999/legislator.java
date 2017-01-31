package com.example.hw999;

import android.util.Log;

/**
 * Created by donezio on 11/21/2016.
 */

public class legislator {
    public String first_name;
    public String last_name;
    public String party;
    public String picUrl;
    public String district;
    public String state_name;
    public String id;
    public String state;
    public String chamber;
    public String fullname;
   // public String imgUrl;


    public String getFullname(){
        return fullname;
    }
    public void setFullname(String p){
        this.fullname = p;
    }

    public String getlast(){
        return last_name;
    }
    public String getfirst(){
        return first_name;
    }

    public legislator() {
        this.first_name = "placeholder";
        this.last_name = "placeholder";
    }

    public void setChamber(String p){
        this.chamber = p;
    }

    public String getChamber() {
        return chamber;
    }

    public String getState(){
        return state;
    }

    public void setState(String p){
        this.state = p;
    }

    public String getImgUrl(){

        return "https://theunitedstates.io/images/congress/225x275/" + this.id+".jpg";
    }
    public String getName(){
        return  last_name + "," + first_name;

    }
    public String getLast_name(){
        return last_name;
    }

    public void setFirst(String Firstname ){
        this.first_name = Firstname;
    }
    public void setLast(String Lastname){
        this.last_name = Lastname;
    }

    public String getPic(){
        return picUrl;
    }
    public void setPic(String url){
        this.picUrl = url;
    }

    public String getParty(){
        return party;
    }
    public void setParty(String party){
        this.party = party;
    }

    public void setDistrict(String District){
        this.district = District;
        if(District == "null"){
            this.district = "0";
        }
    }
    public String getDistrict(){
       if(district != null)
        return district;
        else
           return "0";
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object other){
        Log.d("equals","is called");
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof legislator))return false;
        legislator temp1 = (legislator)other;
        if(temp1.getId().equals(this.id)){
            return true;
        }
        else{
            return false;
        }
    }

    public void setState_name(String p){
        this.state_name = p;
    }
    public String getState_name(){
        return state_name;
    }

    public String getDisplay(){

        return "(" + this.party + ")" + this.state_name + "-" + "District " + district;
    }
    public String getLastName(){
        return this.last_name;
    }
}
