package com.paddy.desi.dime.app.utils;

import android.app.Activity;
import android.os.AsyncTask;

import com.paddy.desi.dime.app.models.ServiceHandlerAuthentication;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prashant Patil on 09-06-2015.
 */
public class AsyncReuse extends AsyncTask<Void,Void,Void> {
    String Url;
    int RequestType;
    String Response = null;
    Activity activtiy;
    List<NameValuePair> paramslist = new ArrayList<NameValuePair>();
    public GetResponse getResponse = null;
    Boolean DialogShow = false;
    SweetAlertDialogManager dialog;

    public AsyncReuse(Activity activtiy, String url, int requestType, List<NameValuePair> params, Boolean DialogShow) {
        this.activtiy = activtiy;
        this.Url = url;
        this.RequestType = requestType;
        this.paramslist = params;
        this.DialogShow = DialogShow;
        dialog = new SweetAlertDialogManager();

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (DialogShow) {
            dialog.showAlertDialog(activtiy);
        }
    }

    @Override
    protected Void doInBackground(Void... params) {

        ServiceHandlerAuthentication sh = new ServiceHandlerAuthentication();
        // Making a request to url and getting response
        Response = sh.makeServiceCall(Url, RequestType,paramslist);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (Response!= null){
            getResponse.GetData(Response);
        }
        if (DialogShow) {
            dialog.Hide();
        }

    }
}
