package com.paddy.desi.dime.app.models;

import android.util.Base64;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ServiceHandlerAuthentication {

	static String response = null;
	public final static int GET = 1;
	public final static int POST = 2;

	public ServiceHandlerAuthentication() {
	}
	/*
	 * Making service call
	 * @url - url to make request
	 * @method - http request method
	 * */
	public String makeServiceCall(String url, int method) {
		return this.makeServiceCall(url, method, null);
	}
	/*
	 * Making service call
	 * @url - url to make request
	 * @method - http request method
	 * @params - http request params
	 * */
	public String makeServiceCall(String url, int method,
			List<NameValuePair> params) {
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
		
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;
			
			// Checking http request method type
			if (method == POST) {			
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("X-Desidime-Client", "7d7c5cacb355d043f07c7c9e4b38257ea5683f8d643b578683877a9b6a8bee1b");

				// adding post params
				if (params != null) {
					for(int i = 0; i < params.size() ; i++){
					    Log.d("string is", params.get(i).toString());
					}
					httpPost.setEntity(new UrlEncodedFormEntity(params));
				}else{
					
				}
				httpResponse = httpClient.execute(httpPost);
			} else if (method == GET) {
				// appending params to url
				if (params != null) {
					String paramString = URLEncodedUtils
							.format(params, "utf-8");
					url += "?" + paramString;
				}
				HttpGet httpGet = new HttpGet(url);
                httpGet.setHeader("X-Desidime-Client", "7d7c5cacb355d043f07c7c9e4b38257ea5683f8d643b578683877a9b6a8bee1b");
				httpResponse = httpClient.execute(httpGet);
			}
			httpEntity = httpResponse.getEntity();
			response = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return response;
	}
	
	

}
