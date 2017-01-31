package com.example.hw999;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donezio on 11/24/2016.
 */

public class global {

    static public int call;
    static public List<legislator> legislatorList = new ArrayList<legislator>();
    static public List<bills> billsList = new ArrayList<bills>();
    //static public List<commitees> commiteesList = new ArrayList<lcommitees>();

    static public List<legislator> FavlegislatorList = new ArrayList<legislator>();
    static public List<bills> FavBillList = new ArrayList<bills>();
    static public List<coms> FavComList = new ArrayList<coms>();




    public static void setLeg( List<legislator>  list1 ){
        legislatorList = list1;
    }

    public static void setFavLeg( List<legislator>  list1 ){
        FavlegislatorList = list1;
    }

    public static void setFavBill( List<bills>  list1 ){
        FavBillList = list1;
    }

    public static void setFavCom( List<coms>  list1 ){
        FavComList = list1;
    }


    public static  List<legislator> getFavLeg( ){
        return FavlegislatorList;
    }

    public static  List<bills> getFavBill( ){
        return FavBillList;
    }

    public static  List<coms> getFavCom( ){
        return FavComList;
    }


    public static void setBills( List<bills>  list2 ){
        billsList = list2;
    }

    public static List<legislator> getLegislatorList(){
        return legislatorList;
    }

    public static List<bills> getBillsList(){
        return billsList;
    }
}
