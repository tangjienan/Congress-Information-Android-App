package com.example.hw999;

/**
 * Created by donezio on 11/26/2016.
 */

public class billinfo {
    public String id = "N.A";
    public String title = "N.A";
    public String type = "N.A";
    public String Sponsor = "N.A";
    public String chamber = "N.A";
    public String status = "N.A";
    public String introduce = "N.A";
    public String cURL = "N.A";
    public String version = "N.A";
    public String bURL = "N.A";

    public void setId(String p){
        this.id = p;
    }
    public String getId(){
        return this.id;
    }
    public void setTitle(String p){
        this.title = p;
    }
    public String getTitle(){
        return this.title;
    }
    public void setType(String p){
        this.type = p;
    }
    public String getType(){
        return this.type;
    }
    public void setSponsor(String t,String f, String l){
        this.Sponsor = t + f + l;
    }
    public String getSponsor(){
        return this.Sponsor;
    }
    public void setChamber(String p){
        this.chamber = p;
    }
    public String getChamber(){
        return this.chamber;
    }
    public void setStatus(String p){
        this.status = p;
    }
    public String getStatus(){
        return status;
    }
    public void setIntroduce(String p ){
        this.introduce = p;
    }
    public String getIntroduce(){
        return this.introduce;
    }
    public void setcURL(String p){
        this.cURL = p;
    }
    public String getcURL(){
        return this.cURL;
    }
    public void setVersion(String p){
        this.version = p;
    }
    public String getVersion(){
        return this.version;
    }
    public void setbURL(String p){
        this.bURL = p;
    }
    public String getbURL(){
        return this.bURL;
    }
}
