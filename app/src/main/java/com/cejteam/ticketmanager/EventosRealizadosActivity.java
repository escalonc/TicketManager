package com.cejteam.ticketmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class EventosRealizadosActivity extends AppCompatActivity {
    ArrayList<Event> EventosRealizados;
    int contadorDeportivos = 0;
    int contadorReligiosos = 0;
    int contadorMusicales = 0;
    double montoTotal = 0;
    TextView DeportivosR;
    TextView ReligiososR;
    TextView MusicalesR;
    TextView MontoTotalR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_realizados);
        DeportivosR = (TextView) findViewById(R.id.textViewDeportivosp);
        ReligiososR = (TextView) findViewById(R.id.textViewReligiososp);
        MusicalesR = (TextView) findViewById(R.id.textViewMusicalesp);
        MontoTotalR = (TextView) findViewById(R.id.textViewMontoTotalp);

        EventosRealizados = new ArrayList<>();
        for(Event e : AlmacenEventos.registrarEventoDeportivos) {
            if(comparar(e.getAño(),e.getMes(),e.getDia())) {
                EventosRealizados.add(e);
                montoTotal += Integer.parseInt(e.getAmount());
                    contadorDeportivos++;
            }
        }
        for(Event e : AlmacenEventos.registrarEventoMusicals) {
            if(comparar(e.getAño(),e.getMes(),e.getDia())) {
                EventosRealizados.add(e);
                montoTotal += Integer.parseInt(e.getAmount());
                contadorMusicales++;
            }
        }
        for(Event e : AlmacenEventos.registrarEventoReligiosos) {
            if(comparar(e.getAño(),e.getMes(),e.getDia())) {
                EventosRealizados.add(e);
                montoTotal += Integer.parseInt(e.getAmount());
                contadorReligiosos++;
            }
        }

        ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosRealizados);
        ListView ListEventosRealizados = (ListView) findViewById(R.id.List_eventos_realizados);
        ListEventosRealizados.setAdapter(pambisitoAdapter);

        DeportivosR.setText("Eventos deportivos: "+String.valueOf(contadorDeportivos));
        ReligiososR.setText("Eventos religiosos: "+String.valueOf(contadorReligiosos));
        MusicalesR.setText("Eventos musicales: "+String.valueOf(contadorMusicales));
        MontoTotalR.setText("Monto total: "+String.valueOf(montoTotal));



    }

    public boolean comparar(int ano,int mes, int dia){
       Calendar calendar=  Calendar.getInstance();

        int anoa= calendar.get(Calendar.YEAR);
        int mesa= calendar.get(Calendar.MONTH);
        int diaa= calendar.get(Calendar.DAY_OF_MONTH);
        if(anoa<ano){
            return false;
        }else if(anoa==ano && mesa<mes){
            return false;
        }else if(anoa==ano && mesa == mes && diaa<dia){
            return false;
        }

        return true;
    }



}
