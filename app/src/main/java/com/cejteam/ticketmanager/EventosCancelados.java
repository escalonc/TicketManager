package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventosCancelados extends AppCompatActivity {
    ArrayList<Event> EventosCancelados;
    Button menu;
    int depCont = 0,relCont = 0,musCont = 0;
    double costoTotal = 0;
    TextView depCancelados, relCancelados, musCancelados, TotalAPagarAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_cancelados);


        menu=(Button)findViewById(R.id.menu656);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(EventosCancelados.this,MenuEvents.class);
                startActivity(intenst);
            }
        });

        depCancelados = (TextView) findViewById(R.id.deportivosCancelados);
        relCancelados = (TextView) findViewById(R.id.religiosoCancelado);
        musCancelados = (TextView) findViewById(R.id.musicalCancelado);
        TotalAPagarAll = (TextView) findViewById(R.id.montoCancelado);
        try {
            EventosCancelados = new ArrayList<>();
            for (Event e : AlmacenEventos.registrarEventoDeportivoseliminados) {
                    EventosCancelados.add(e);
                    costoTotal += Integer.parseInt(e.getAmount());
                    depCont++;            }
            for (Event e : AlmacenEventos.registrarEventoMusicalseliminados) {
                EventosCancelados.add(e);
                    costoTotal += Integer.parseInt(e.getAmount());
                    musCont++;
            }
            for (Event e : AlmacenEventos.registrarEventoReligiososeliminados) {
                    EventosCancelados.add(e);
                    costoTotal += Integer.parseInt(e.getAmount());
                    relCont++;
            }
            ListAdapter ListaPasada = new AdaptadorDeVistaDeEventos(getApplicationContext(), EventosCancelados);
            ListView EventosCandeladosList = (ListView) findViewById(R.id.eventoCancelado);
            EventosCandeladosList.setAdapter(ListaPasada);
            depCancelados.setText("Sports events: " + String.valueOf(depCont));
            relCancelados.setText("Religious events: " + String.valueOf(relCont));
            musCancelados.setText("Musical events: " + String.valueOf(musCont));
            TotalAPagarAll.setText("Total amount: " + String.valueOf(costoTotal));
        }catch (Exception e){
        }
    }

}
