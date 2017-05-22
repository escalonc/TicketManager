package com.cejteam.ticketmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by joel.caballero on 22/5/2017.
 */

public class Adapter extends BaseAdapter{

    private Context context;
    private ArrayList<Create_EventActivity> arrayList;
    public Adapter(Context context, ArrayList<Create_EventActivity> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView= layoutInflater.inflate(R.layout.items,null);
            TextView spinner= (TextView)convertView.findViewById(R.id.spinner);
            TextView event= (TextView)convertView.findViewById(R.id.event);
            TextView tittle= (TextView)convertView.findViewById(R.id.tittle);
            TextView fechamostrar= (TextView)convertView.findViewById(R.id.fechamostrar);
        }

        return null;
    }
}
