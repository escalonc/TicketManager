package com.cejteam.ticketmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class EventosFuturosActivity extends AppCompatActivity {
    ArrayList<Event> EventosFuturos;
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
        setContentView(R.layout.activity_eventos_futuros);

        DeportivosF = (TextView) findViewById(R.id.textViewDeportivosF);
        ReligiososF = (TextView) findViewById(R.id.textViewReligiososF);
        MusicalesF = (TextView) findViewById(R.id.textViewMusicalesF);
        MontoTotalF = (TextView) findViewById(R.id.textViewMontoTotalF);
        try {
        /*/lo que voy a hacer es que voy a crear otro arrayList que contenga los eventos ya
        realizados, extrayendo la info del arrayList que esta en el MainClass, para asi no alterar
        la info que hay en el arraylist original
        */
            EventosFuturos = new ArrayList<>();
            for (Event e : AlmacenEventos.registrarEventoDeportivos) {
                if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                    EventosFuturos.add(e);
                    montoTotal += Integer.parseInt(e.getAmount());
                    contadorDeportivos++;
                }
            }
            for (Event e : AlmacenEventos.registrarEventoMusicals) {
                if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                    EventosFuturos.add(e);
                    montoTotal += Integer.parseInt(e.getAmount());
                    contadorMusicales++;
                }
            }
            for (Event e : AlmacenEventos.registrarEventoReligiosos) {
                if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                    EventosFuturos.add(e);
                    montoTotal += Integer.parseInt(e.getAmount());
                    contadorReligiosos++;
                }
            }
            ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosFuturos);
            ListView ListEventosFuturos = (ListView) findViewById(R.id.List_eventos_futuros);
            ListEventosFuturos.setAdapter(pambisitoAdapter);

            //ahora a poner los contadores en los textViews
            DeportivosF.setText("Eventos deportivos: " + String.valueOf(contadorDeportivos));
            ReligiososF.setText("Eventos religiosos: " + String.valueOf(contadorReligiosos));
            MusicalesF.setText("Eventos musicales: " + String.valueOf(contadorMusicales));
            MontoTotalF.setText("Monto total: " + String.valueOf(montoTotal));
        }catch (Exception e){
            Toast fmsg = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            fmsg.show();
        }
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
