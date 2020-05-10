package com.example.botapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText inputResponse;
    ImageButton sendQuery;
    ArrayList<BotResponse> rspList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.chatList);
        inputResponse = findViewById(R.id.editText);
        sendQuery = findViewById(R.id.senButton);

        rspList = new ArrayList<>();
        final CustomAdapter customAdapter = new CustomAdapter(this, rspList);
        Log.v("Response list", "size" + rspList.size());
        listView.setAdapter(customAdapter);

        sendQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputResponse.getText().toString();
                input = input.trim();
                if (input != null || !(input.equals(""))) {
                    inputResponse.setText("");
                    String response = null;
                    try {
                        response = new CallAPI().execute(input).get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    BotResponse newString = new BotResponse(input, response);
                    rspList.add(newString);
                    customAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
