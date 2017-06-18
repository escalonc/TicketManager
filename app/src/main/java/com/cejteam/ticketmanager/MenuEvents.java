package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuEvents extends AppCompatActivity implements View.OnClickListener{
    FloatingActionButton addevent;
    Button eliminar,ver,editar;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_events);
        initComponents();
    }

    public void initComponents() {
        addevent = (FloatingActionButton) findViewById(R.id.addeventsmain);
        addevent.setOnClickListener(this);
        eliminar = (Button) findViewById(R.id.eliminar);
        eliminar.setOnClickListener(this);
        editar = (Button)findViewById(R.id.editar);
        editar.setOnClickListener(this);
        ver = (Button) findViewById(R.id.ver);
        ver.setOnClickListener(this);
    }





    @Override
    public void onClick(View v) {
        try {
            int seleccion = v.getId();
            switch (seleccion) {
                case R.id.ver:
                    Intent intenst = new Intent(this,VerEvento.class);
                    startActivity(intenst);
                    finish();
                    break;
                case R.id.eliminar:
                    Intent intent = new Intent(this,EliminarEvento.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.editar:
                    Intent intents = new Intent(this,EditarEvento.class);
                    startActivity(intents);
                    finish();
                    break;
                case R.id.addeventsmain:
                    Intent intentd = new Intent(this,TipodeEvento.class);
                    startActivity(intentd);
                    finish();
                    break;
            }
        } catch (Exception e) {
        }
    }
}
