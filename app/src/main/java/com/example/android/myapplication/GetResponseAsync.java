package com.example.android.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GetResponseAsync extends AsyncTask<String, Integer, String> {
    protected String doInBackground(String... urls) {

        String baseUrl = "http://localhost:5000/api";
        HttpURLConnection httpURLConnection = null;
        int a = -1;
        try {
            httpURLConnection = (HttpURLConnection) new URL(baseUrl).openConnection();
        } catch (IOException e) {
            Log.v("Anubhav", "Exception 1");
            e.printStackTrace();
        }
        try {
            httpURLConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            Log.v("Anubhav", "Exception 2");
            e.printStackTrace();
        }
        try {
             a =  +httpURLConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("Anubhav", "Response: " +a);
        return "";
    }

    protected void onPostExecute(Long result) {
        //showDialog("Downloaded " + result + " bytes");
    }
}
