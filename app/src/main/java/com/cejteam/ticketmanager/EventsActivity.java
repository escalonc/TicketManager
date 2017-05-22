package com.cejteam.ticketmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
private ListView lista;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Create_EventActivity> model=new ArrayList<>();

        Create_EventActivity create_eventActivity= new Create_EventActivity("Musical","Prueba1","Mundial","Sudafrica",2,"termino");


        adapter= new Adapter(this, model);
        lista=(ListView)findViewById(R.id.ma_lv_lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try{
                    Create_EventActivity create_eventActivity=(Create_EventActivity) adapter.getItem(position);
                    Log.e("Create event", create_eventActivity.getTittle().toString() + "  " + create_eventActivity.getEvent().toString());
                    Toast.makeText(getBaseContext(),"Tu titulo es:" + create_eventActivity.getTittle().toString(), Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
