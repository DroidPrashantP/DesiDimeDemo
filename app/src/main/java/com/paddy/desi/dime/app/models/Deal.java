package com.paddy.desi.dime.app.models;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Prashant Patil on 09-06-2015.
 */

// Json parsing class
public class Deal {

    private JSONObject topdealsobject;

    public Deal(JSONObject topdealsobject) {

        this.topdealsobject = topdealsobject;
    }

    public int getid() {
        return (int) JSONUtil.getJSONProperty(topdealsobject, "id");
    }

    public String gettitle() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "title");
    }

    public String getoff_percent() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "off_percent");
    }

    public double getcurrent_price() {
        return (double) JSONUtil.getJSONProperty(topdealsobject, "current_price");
    }

    public int getoriginal_price() {
        return (int) JSONUtil.getJSONProperty(topdealsobject, "original_price");
    }

    public int getshipping_charge() {
        return (int) JSONUtil.getJSONProperty(topdealsobject, "shipping_charge");
    }

    public String getshare_url() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "share_url");
    }

    public String getdeal_url() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "deal_url");
    }

    public int getpopularity_count() {
        return (int) JSONUtil.getJSONProperty(topdealsobject, "popularity_count");
    }

    public String getdeal_detail() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "deal_detail");
    }

    public String getimage_thumb() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "image_thumb");
    }

    public String getimage_large() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "image_large");
    }

    public int getcomments_count() {
        return (int) JSONUtil.getJSONProperty(topdealsobject, "comments_count");
    }

    public String getcreated_at() {
        return (String) JSONUtil.getJSONProperty(topdealsobject, "created_at");
    }

    public int getrating() {
        return (int) JSONUtil.getJSONProperty(topdealsobject, "rating");
    }

    public JSONArray getcategories() {
        return (JSONArray) JSONUtil.getJSONProperty(topdealsobject, "categories");
    }

    public JSONObject getmerchant() {
        return (JSONObject) JSONUtil.getJSONProperty(topdealsobject, "merchant");
    }

    public JSONObject getuser() {
        return (JSONObject) JSONUtil.getJSONProperty(topdealsobject, "user");
    }

    public JSONObject gettopic() {
        return (JSONObject) JSONUtil.getJSONProperty(topdealsobject, "topic");
    }

    public JSONObject gettopdealsobject() {
        return topdealsobject;
    }

}
