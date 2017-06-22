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
import java.util.Calendar;

public class EventosFuturosActivity extends AppCompatActivity {
    ArrayList<Event> EventosAPasar;
    Button menu;
    int depCont = 0, relCont = 0, musCont = 0;
    double TotalAPagar = 0;
    TextView depFut, relFut, musFut, MontoAPagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_futuros);


        menu=(Button)findViewById(R.id.menu87);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(EventosFuturosActivity.this,MainActivity.class);
                startActivity(intenst);
            }
        });
        depFut = (TextView) findViewById(R.id.futuroDeporte);
        relFut = (TextView) findViewById(R.id.futuroReligion);
        musFut = (TextView) findViewById(R.id.futuroMusica);
        MontoAPagar = (TextView) findViewById(R.id.futuroMonto);
        try {
            EventosAPasar = new ArrayList<>();
            for (Event e : AlmacenEventos.registrarEventoDeportivos) {
                if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                    EventosAPasar.add(e);
                    TotalAPagar += Integer.parseInt(e.getAmount());
                    depCont++;
                }
            }
            for (Event e : AlmacenEventos.registrarEventoMusicals) {
                if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                    EventosAPasar.add(e);
                    TotalAPagar += Integer.parseInt(e.getAmount());
                    musCont++;
                }
            }
            for (Event e : AlmacenEventos.registrarEventoReligiosos) {
                if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                    EventosAPasar.add(e);
                    TotalAPagar += Integer.parseInt(e.getAmount());
                    relCont++;
                }
            }
            ListAdapter ListaDelAdaptador = new AdaptadorDeVistaDeEventos(getApplicationContext(), EventosAPasar);
            ListView ListaFinal = (ListView) findViewById(R.id.eventosFuturo);
            ListaFinal.setAdapter(ListaDelAdaptador);
            depFut.setText("Sports events: " + String.valueOf(depCont));
            relFut.setText("Religious events: " + String.valueOf(relCont));
            musFut.setText("Musical events: " + String.valueOf(musCont));
            MontoAPagar.setText("Total amount: " + String.valueOf(TotalAPagar));
        }catch (Exception e){}
    }

    public boolean comparar(int ano,int mes, int dia){
        Calendar calendar=  Calendar.getInstance();
        int anoa= calendar.get(Calendar.YEAR);
        int mesa= calendar.get(Calendar.MONTH);
        int diaa= calendar.get(Calendar.DAY_OF_MONTH);
        if(anoa>ano){
            return false;
        }else if(anoa==ano && mesa>mes){
            return false;
        }else if(anoa==ano && mesa == mes && diaa>dia){
            return false;
        }

        return true;
    }

}
