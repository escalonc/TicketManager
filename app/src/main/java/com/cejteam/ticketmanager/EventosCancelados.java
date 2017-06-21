package com.cejteam.ticketmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class EventosCancelados extends AppCompatActivity {
    ArrayList<Event> EventosCancelados;
    int contadorDeportivos = 0;
    int contadorReligiosos = 0;
    int contadorMusicales = 0;
    double montoTotal = 0;
    TextView DeportivosF;
    TextView ReligiososF;
    TextView MusicalesF;
    TextView MontoTotalF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_cancelados);



        DeportivosF = (TextView) findViewById(R.id.textViewDeportivosc);
        ReligiososF = (TextView) findViewById(R.id.textViewReligiososc);
        MusicalesF = (TextView) findViewById(R.id.textViewMusicalesc);
        MontoTotalF = (TextView) findViewById(R.id.textViewMontoTotalc);
        try {
        /*/lo que voy a hacer es que voy a crear otro arrayList que contenga los eventos ya
        realizados, extrayendo la info del arrayList que esta en el MainClass, para asi no alterar
        la info que hay en el arraylist original
        */
            EventosCancelados = new ArrayList<>();
            for (Event e : AlmacenEventos.registrarEventoDeportivoseliminados) {
                    EventosCancelados.add(e);
                    montoTotal += Integer.parseInt(e.getAmount());
                    contadorDeportivos++;
            }
            for (Event e : AlmacenEventos.registrarEventoMusicalseliminados) {
                EventosCancelados.add(e);
                    montoTotal += Integer.parseInt(e.getAmount());
                    contadorMusicales++;

            }
            for (Event e : AlmacenEventos.registrarEventoReligiososeliminados) {
                    EventosCancelados.add(e);
                    montoTotal += Integer.parseInt(e.getAmount());
                    contadorReligiosos++;

            }
            ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosCancelados);
            ListView ListEventosFuturos = (ListView) findViewById(R.id.List_eventos_cancelados);
            ListEventosFuturos.setAdapter(pambisitoAdapter);

            //ahora a poner los contadores en los textViews
            DeportivosF.setText("Sports events: " + String.valueOf(contadorDeportivos));
            ReligiososF.setText("Religious events: " + String.valueOf(contadorReligiosos));
            MusicalesF.setText("Musical events: " + String.valueOf(contadorMusicales));
            MontoTotalF.setText("Total amount: " + String.valueOf(montoTotal));
        }catch (Exception e){
            Toast fmsg = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            fmsg.show();
        }
    }

}
