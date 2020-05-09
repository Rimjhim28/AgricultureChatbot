package com.example.agriculturechatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
//        inputResponse = findViewById(R.id.editText);
//        sendQuery = findViewById(R.id.sendButton);

        rspList = new ArrayList<>();
        rspList.add(new BotResponse("Query", "Response"));
        CustomAdapter customAdapter = new CustomAdapter(this, rspList);
        Log.v("Response list", "size" + rspList.size());
        listView.setAdapter(customAdapter);

//        sendQuery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String input = inputResponse.getText().toString();
//                inputResponse.setText("");
//                String response = null;
//                try {
//                    response = new CallAPI().execute(input).get();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                BotResponse newString = new BotResponse(input, "respomse");
//                rspList.add(newString);
//                synchronized(adapter){
//                    adapter.notify();
//                }
//            }
//        });
    }
}
