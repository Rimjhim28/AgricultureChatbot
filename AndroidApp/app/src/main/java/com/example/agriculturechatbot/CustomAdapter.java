package com.example.agriculturechatbot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<BotResponse> {

    private Context mContext;
    private List<BotResponse> rspList = new ArrayList<>();

    public CustomAdapter(@NonNull Context context, ArrayList<BotResponse> list) {
        super(context, 0 , list);
        mContext = context;
        rspList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_listview,parent,false);
        BotResponse curr = rspList.get(position);
        TextView queryText = listItem.findViewById(R.id.textQuery);
            TextView responseText = listItem.findViewById(R.id.textResponse);
            queryText.setText(curr.query);
            responseText.setText(curr.response);
        return listItem;
    }

}
