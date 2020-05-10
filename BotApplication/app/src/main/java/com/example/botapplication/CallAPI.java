package com.example.botapplication;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallAPI extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String response= "Sorry! I don't know the answer :(";
        try {
            String urlString = "https://agriculturebot.herokuapp.com/api";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "*/*");

            connection.setDoOutput(true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            String query = params[0];
            JSONObject queryRequest = new JSONObject();
            try {
                queryRequest.put("exp", query);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            writer.write(String.valueOf(queryRequest));
            writer.close();

            connection.connect();

            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                while((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Response: 400
            response = sb.toString();
        } catch (Exception e) {
            Log.e(e.toString(), "Something wrong with request");
        }

        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.v("Post Execute","Response: " +s);
    }
}
