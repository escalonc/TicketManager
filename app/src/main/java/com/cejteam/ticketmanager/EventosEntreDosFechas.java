package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class EventosEntreDosFechas extends AppCompatActivity {
    ArrayList<Event> EventosFuturos;
    int contadorDeportivos = 0;
    int contadorReligiosos = 0;
    int contadorMusicales = 0;
    double montoTotal = 0;
    TextView DeportivosF;
    TextView ReligiososF;
    TextView MusicalesF;
    TextView MontoTotalF;
    Button calcular;
    int ano1=0,ano2=0,mes1=0,mes2=0,dia1=0,dia2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_entre_dos_fechas);

        try {
            ano1 = (Integer) getIntent().getExtras().get("ano1");
            ano2 = (Integer) getIntent().getExtras().get("ano2");
            mes1 = (Integer) getIntent().getExtras().get("mes1");
            mes2 = (Integer) getIntent().getExtras().get("mes2");
            dia1 = (Integer) getIntent().getExtras().get("dia1");
            dia2 = (Integer) getIntent().getExtras().get("dia2");
        }catch (Exception e){}


        DeportivosF = (TextView) findViewById(R.id.textViewDeportivoscalc);
        ReligiososF = (TextView) findViewById(R.id.textViewReligiososcalc);
        MusicalesF = (TextView) findViewById(R.id.textViewMusicalescalc);
        MontoTotalF = (TextView) findViewById(R.id.textViewMontoTotalcalc);



                try {

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
                    for (Event e : AlmacenEventos.registrarEventoDeportivoseliminados) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EventosFuturos.add(e);
                            montoTotal += Integer.parseInt(e.getAmount());
                            contadorDeportivos++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoMusicalseliminados) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EventosFuturos.add(e);
                            montoTotal += Integer.parseInt(e.getAmount());
                            contadorMusicales++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoReligiososeliminados) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EventosFuturos.add(e);
                            montoTotal += Integer.parseInt(e.getAmount());
                            contadorReligiosos++;
                        }
                    }






                    ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosFuturos);
                    ListView ListEventosFuturos = (ListView) findViewById(R.id.List_eventos_betwenn);
                    ListEventosFuturos.setAdapter(pambisitoAdapter);

                    //ahora a poner los contadores en los textViews
                    DeportivosF.setText("Eventos deportivos: " + String.valueOf(contadorDeportivos));
                    ReligiososF.setText("Eventos religiosos: " + String.valueOf(contadorReligiosos));
                    MusicalesF.setText("Eventos musicales: " + String.valueOf(contadorMusicales));
                    MontoTotalF.setText("Monto total: " + String.valueOf(montoTotal));
                }catch (Exception e){
                }
            }




    public boolean comparar(int anoa,int mesa, int diaa){
        if(anoa<ano1 || anoa>ano2){
            return false;
        }else if(mesa<mes1 || mesa>mes2){
            return false;
        }else if( diaa<dia1 || diaa>dia2){
            return  false;
        }

        return true;
    }
}
