package com.paddy.desi.dime.app.models;

import android.annotation.TargetApi;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Prashant Patil on 09-06-2015.
 */
public class ProductResponseParser {

    public static ProductResponseParser instance = null;
    private ArrayList<Deal> TopDealsList;
    private ArrayList<Deal> PopularDealsList;

    public static ProductResponseParser getInstance() {
        if (instance == null) {
            instance = new ProductResponseParser();
        }
        return instance;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void parseTopDealsResponse(String _response) {
        try {
            setResultTopDeals(new JSONArray(_response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setResultTopDeals(JSONArray _jsonArray) {
        TopDealsList = new ArrayList<Deal>();
        JSONArray jsonArray = _jsonArray;
        for (int i = 0; i < jsonArray.length(); i++) {
            Deal offer_obj = new Deal((JSONObject) JSONUtil.get(jsonArray, i));
            // add deal item into Top list
            TopDealsList.add(offer_obj);
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void parsePopularDealsResponse(String _response) {
        try {
            setResultPopularDeals(new JSONArray(_response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setResultPopularDeals(JSONArray _jsonArray) {
        PopularDealsList = new ArrayList<Deal>();
        JSONArray jsonArray = _jsonArray;
        for (int i = 0; i < jsonArray.length(); i++) {
            Deal offer_obj = new Deal((JSONObject) JSONUtil.get(jsonArray, i));
            // add deal item into Popular list
            PopularDealsList.add(offer_obj);
        }
    }

    public ArrayList<Deal> getResultTopDeals() {
        if (TopDealsList == null)
            return null;
        return TopDealsList;
    }

    public ArrayList<Deal> getResultPopularDeals() {
        if (PopularDealsList == null)
            return null;
        return PopularDealsList;
    }

}
