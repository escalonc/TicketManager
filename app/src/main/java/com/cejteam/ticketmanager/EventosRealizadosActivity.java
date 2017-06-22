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

public class EventosRealizadosActivity extends AppCompatActivity {
    Button menu;
    ArrayList<Event> eventReal;
    int depCont = 0;
    int relCont = 0;
    int musCont = 0;
    double TotaldePago = 0;
    TextView depRea;
    TextView relRea;
    TextView musRea;
    TextView TotalAPagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_realizados);
        menu=(Button)findViewById(R.id.menu8765);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(EventosRealizadosActivity.this,MenuEvents.class);
                startActivity(intenst);
            }
        });
        depRea = (TextView) findViewById(R.id.realizadoDeporte);
        relRea = (TextView) findViewById(R.id.realizadoReligion);
        musRea = (TextView) findViewById(R.id.realizadoMusical);
        TotalAPagar = (TextView) findViewById(R.id.realizadoMonto);
try {
    eventReal = new ArrayList<>();
    for (Event e : AlmacenEventos.registrarEventoDeportivos) {
        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
            eventReal.add(e);
            TotaldePago += Integer.parseInt(e.getAmount());
            depCont++;
        }
    }
    for (Event e : AlmacenEventos.registrarEventoMusicals) {
        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
            eventReal.add(e);
            TotaldePago += Integer.parseInt(e.getAmount());
            musCont++;
        }
    }
    for (Event e : AlmacenEventos.registrarEventoReligiosos) {
        if (comparar(e.getAño(), e.getMes(), e.getDia())) {
            eventReal.add(e);
            TotaldePago += Integer.parseInt(e.getAmount());
            relCont++;
        }
    }
    ListAdapter ListaDelAdaptador = new AdaptadorDeVistaDeEventos(getApplicationContext(), eventReal);
    ListView ListaDeLosEventos = (ListView) findViewById(R.id.eventoRealizado);
    ListaDeLosEventos.setAdapter(ListaDelAdaptador);
    depRea.setText("Sports events: " + String.valueOf(depCont));
    relRea.setText("Religious events: " + String.valueOf(relCont));
    musRea.setText("Musical events: " + String.valueOf(musCont));
    TotalAPagar.setText("Total amount: " + String.valueOf(TotaldePago));
}catch (Exception e){}
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
