package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TipodeEvento extends AppCompatActivity implements View.OnClickListener{
    Button deportivo,musical,religioso,menu;
    int nuevo=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipode_evento);
        deportivo = (Button) findViewById(R.id.deportivo);
        deportivo.setOnClickListener(this);
        musical = (Button) findViewById(R.id.musical);
        musical.setOnClickListener(this);
        religioso = (Button)findViewById(R.id.religioso);
        religioso.setOnClickListener(this);



        menu=(Button)findViewById(R.id.menu2);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(TipodeEvento.this,MenuEvents.class);
                startActivity(intenst);
            }
        });


    }

    @Override
    public void onClick(View v) {
        try {
            int seleccion = v.getId();
            switch (seleccion) {
                case R.id.deportivo:
                    Intent intenst = new Intent(this,CrearEventoDeportivo.class);
                    intenst.putExtra("nuevo",nuevo);
                    startActivity(intenst);
                    finish();
                    break;
                case R.id.musical:
                    Intent intent = new Intent(this,CrearEventoMusical.class);
                    intent.putExtra("nuevo",nuevo);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.religioso:
                    Intent intents = new Intent(this,CrearEventoReligioso.class);
                    intents.putExtra("nuevo",nuevo);
                    startActivity(intents);
                    finish();
                    break;
            }
        } catch (Exception e) {
        }

    }




}
