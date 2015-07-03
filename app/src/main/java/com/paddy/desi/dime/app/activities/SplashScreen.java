package com.paddy.desi.dime.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.paddy.desi.dime.app.R;
import com.paddy.desi.dime.app.models.MainProductsSingletonModel;
import com.paddy.desi.dime.app.utils.AlertDialogManager;
import com.paddy.desi.dime.app.utils.AsyncReuse;
import com.paddy.desi.dime.app.utils.Constants;
import com.paddy.desi.dime.app.utils.GetResponse;
import com.paddy.desi.dime.app.utils.InternetConnectionDetector;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mainthread = new Thread(){
            public void run() {
                try{
                    sleep(2*1000);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        mainthread.start();
    }
}
