package com.example.hw999;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by donezio on 11/25/2016.
 */

public class leginfo {
    public String party;
    public String id;
    public String name;
    public String email;
    public String chamber;
    public String contact;
    public String start;
    public String end;
    public String office;
    public String state;
    public String fax;
    public String birthday;
    public String website;
    public String twitter;
    public String facebook;
    public String facebookurl  = "https://www.facebook.com/";
    public String twitterurl   = "https://twitter.com/";
    public String[] monthNames = {
            "January", "February", "March",
            "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December"
    };


    public void setName(String t, String f, String l){
        this.name = t + " " + f + " " + l;
    }
    public String getName(){
        return this.name;
    }

    public void setParty(String p){
        this.party = p;
    }
    public String getParty(){
        return this.party;
    }

    public void setId(String p){
        this.id = p;
    }
    public String getId(){
        return this.id;
    }

    public void setEmail(String p){
        this.email = p;
    }
    public String getEmail(){
        return this.email;
    }

    public void setChamber(String p){
        this.chamber = p;
    }
    public String getChamber(){
        return this.chamber;
    }

    public void setContact(String p){
        this.contact = p;
    }
    public String getContact(){
        return this.contact;
    }

    public void setStart(String p){
        this.start = p;
    }
    public String getStart(){
        //return this.start;
        String year = start.substring(0,4);
        String mon  = start.substring(5,7);
        String day  = start.substring(8,10);
        int mon1      = Integer.parseInt(mon);

        return monthNames[mon1] + " " + day + "  " + year;
    }

    public void setEnd(String p){
        this.end = p;
    }
    public String getEnd(){

        String year = end.substring(0,4);
        String mon  = end.substring(5,7);
        String day  = end.substring(8,10);
        int mon1      = Integer.parseInt(mon);

        return monthNames[mon1] + " " + day + "  " + year;
        //return this.end;
    }

    public void setOffice(String p){
        this.office = p;
    }
    public String getOffice(){
        return this.office;
    }

    public void setState(String p){
        this.state = p;
    }
    public String getState(){
        return this.state;
    }

    public void setFax(String p){
        this.fax = p;
    }
    public String getFax(){
        return this.fax;
    }

    public void setBirthday(String p){
        this.birthday = p;
    }
    public String getBirthday(){

        String year = birthday.substring(0,4);
        String mon  = birthday.substring(5,7);
        String day  = birthday.substring(8,10);
        int mon1      = Integer.parseInt(mon);

        return monthNames[mon1-1] + " " + day + "  " + year;
        //return this.birthday;
    }
    public String getImgUrl(){

        return "https://theunitedstates.io/images/congress/225x275/" + this.id+".jpg";
    }

    public String getWebsite(){
        if(website == "null") {
            return "no";
        }
        else{
            return website;
        }
    }
    public void setWebsite(String p){
        this.website = p;
    }
    public String getFacebook(){
        if(facebook.equals("no"))
            return facebook;
        else{
            return facebookurl+facebook;
        }
    }
    public void setFacebook(String p){
        this.facebook = p;
    }
    public void setTwitter(String p){
        this.twitter = p;
    }
    public String getTwitter(){
        if(twitter.equals("no"))
            return twitter;
        else{
            return twitterurl+twitter;
        }
    }


    public int getProgress(){

       // SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        int year  = cal.get(Calendar.YEAR);
        int day   = cal.get(Calendar.DAY_OF_MONTH);
        if(day<10) {
            day='0'+day;
        }

        if(month<10) {
            month='0'+month;
        }
        String today1 = year + "-" + month + "-" + day;


        String year1 = end.substring(0,4);
        String mon1  = end.substring(5,7);
        String day1  = end.substring(8,10);
        int mon11      = Integer.parseInt(mon1);
        int year11     = Integer.parseInt(year1);
        int day11     = Integer.parseInt(day1);



        String year2 = start.substring(0,4);
        String mon2  = start.substring(5,7);
        String day2  = start.substring(8,10);
        int mon22    = Integer.parseInt(mon2);
        int year22   = Integer.parseInt(year2);
        int day22    = Integer.parseInt(day2);

        //Date date1 = format.parse(start);

        //Double whole  =  year22-year1
        double result = 10;

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            Date df1 = format.parse(start);
            Date df2 = format.parse(end);
            Date today = format.parse(today1);
            long difference = df2.getTime() - df1.getTime();
            difference = difference/(1000 * 3600 * 24);
            long difference2 = today.getTime() - df1.getTime();
            difference2 =  difference2/(1000 * 3600 * 24);
            //return int bar = toIntExact(difference2/difference;
            //return new BigDecimal(difference2/difference).intValueExact();
            result =  (double)difference2/difference;
            //return (int)result*100;
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return (int)(result*(double)100);

    }

}
