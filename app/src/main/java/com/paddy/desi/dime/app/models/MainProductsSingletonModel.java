package com.paddy.desi.dime.app.models;

import java.util.ArrayList;

/**
 * Created by Prashant Patil on 01-07-2015.
 */

 // Singleton class
public class MainProductsSingletonModel {
    private static MainProductsSingletonModel instance;


    public static MainProductsSingletonModel getInstance() {
        if (instance == null) {
            instance = new MainProductsSingletonModel();
        }
        return instance;
    }

    public static void setInstance(MainProductsSingletonModel instance) {
        MainProductsSingletonModel.instance = instance;
    }

    public void GetTopDealsDataFromServer(String response) {
        //  Parse top list data
        ProductResponseParser.getInstance().parseTopDealsResponse(response);
    }
    public ArrayList<Deal> getTopDealsList() {
        // return Top list
        return ProductResponseParser.getInstance().getResultTopDeals();
    }

    public void GetPopularDealsDataFromServer(String response) {
        // Parse Popular list data
        ProductResponseParser.getInstance().parsePopularDealsResponse(response);
    }
    public ArrayList<Deal> getPopularDealsList() {
        // return Popular list
        return ProductResponseParser.getInstance().getResultPopularDeals();
    }
}
