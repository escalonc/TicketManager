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

public class EventosEntreDosFechas extends AppCompatActivity {
    ArrayList<Event> EntreFechas;
    int depCont = 0,relCont = 0,musCont = 0;
    double TotalDePago = 0;
    Button menu;
    TextView depEntreFechas, relEntreFechas, musEntreFechas, TotalAPagar;
    int ano1=0,ano2=0,mes1=0,mes2=0,dia1=0,dia2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_entre_dos_fechas);


        menu=(Button)findViewById(R.id.menu56565);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(EventosEntreDosFechas.this,MainActivity.class);
                startActivity(intenst);
            }
        });
        try {
            ano1 = (Integer) getIntent().getExtras().get("ano1");
            ano2 = (Integer) getIntent().getExtras().get("ano2");
            mes1 = (Integer) getIntent().getExtras().get("mes1");
            mes2 = (Integer) getIntent().getExtras().get("mes2");
            dia1 = (Integer) getIntent().getExtras().get("dia1");
            dia2 = (Integer) getIntent().getExtras().get("dia2");
        }catch (Exception e){}
        depEntreFechas = (TextView) findViewById(R.id.dosFechasDeporte);
        relEntreFechas = (TextView) findViewById(R.id.dosFechasReligioso);
        musEntreFechas = (TextView) findViewById(R.id.dosFechasMusical);
        TotalAPagar = (TextView) findViewById(R.id.dosFechasMonto);
                try {

                    EntreFechas = new ArrayList<>();
                    for (Event e : AlmacenEventos.registrarEventoDeportivos) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EntreFechas.add(e);
                            TotalDePago += Integer.parseInt(e.getAmount());
                            depCont++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoMusicals) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EntreFechas.add(e);
                            TotalDePago += Integer.parseInt(e.getAmount());
                            musCont++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoReligiosos) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EntreFechas.add(e);
                            TotalDePago += Integer.parseInt(e.getAmount());
                            relCont++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoDeportivoseliminados) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EntreFechas.add(e);
                            TotalDePago += Integer.parseInt(e.getAmount());
                            depCont++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoMusicalseliminados) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EntreFechas.add(e);
                            TotalDePago += Integer.parseInt(e.getAmount());
                            musCont++;
                        }
                    }
                    for (Event e : AlmacenEventos.registrarEventoReligiososeliminados) {
                        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
                            EntreFechas.add(e);
                            TotalDePago += Integer.parseInt(e.getAmount());
                            relCont++;
                        }
                    }
                    ListAdapter ListaDeAdaptador = new AdaptadorDeVistaDeEventos(getApplicationContext(), EntreFechas);
                    ListView ListaAMostrar = (ListView) findViewById(R.id.eventoEntreDosFechas);
                    ListaAMostrar.setAdapter(ListaDeAdaptador);
                    depEntreFechas.setText("Sports events: " + String.valueOf(depCont));
                    relEntreFechas.setText("Religious events: " + String.valueOf(relCont));
                    musEntreFechas.setText("Musical events: " + String.valueOf(musCont));
                    TotalAPagar.setText("Total amount: " + String.valueOf(TotalDePago));
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
