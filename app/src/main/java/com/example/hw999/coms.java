package com.example.hw999;

/**
 * Created by donezio on 11/26/2016.
 */

public class coms {

    public String comid = "N.A";
    public String comname = "N.A";
    public String chamber = "N.A";

    public String id = "N.A";
    public String parent ="N.A" ;
    public String contact = "N.A";
    public String office ="N.A";


    public coms(){

    }

    public String getid(){
        return this.id;
    }
    public void setid(String p){
        this.id = p;
    }
    public String getComid(){
        return this.comid;
    }
    public void setComid(String p){
        this.comid = p;
    }
    public String getComname(){
        return this.comname;
    }
    public void setComname(String p){
        this.comname = p;
    }
    public String getChamber(){
        return this.chamber;
    }
    public void setChamber(String p){
        this.chamber = p;
    }
    public void setParent(String p){
        this.parent = p;
    }
    public String getParent(){
        return parent;
    }
    public void setContact(String p){
        this.contact = p;
    }
    public String getContact(){
        return contact;
    }
    public void setOffice(String p){
        this.office = p;
    }
    public String getOffice(){
        return this.office;
    }
    @Override
    public boolean equals(Object other){

        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof coms))return false;
        coms temp1 = (coms)other;
        if(temp1.getComid().equals(this.comid)){
            return true;
        }
        else{
            return false;
        }
    }

}
