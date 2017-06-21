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
    TextView fechainicial;
    TextView fechafinal;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_entre_dos_fechas);

        fechainicial = (TextView) findViewById(R.id.fechainicial);
        fechafinal = (TextView) findViewById(R.id.fechafinal);
        DeportivosF = (TextView) findViewById(R.id.textViewDeportivoscalc);
        ReligiososF = (TextView) findViewById(R.id.textViewReligiososcalc);
        MusicalesF = (TextView) findViewById(R.id.textViewMusicalescalc);
        MontoTotalF = (TextView) findViewById(R.id.textViewMontoTotalcalc);
        calcular = (Button) findViewById(R.id.calcularfechas);



        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                    ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosFuturos);
                    ListView ListEventosFuturos = (ListView) findViewById(R.id.List_eventos_futuros);
                    ListEventosFuturos.setAdapter(pambisitoAdapter);

                    //ahora a poner los contadores en los textViews
                    DeportivosF.setText("Eventos deportivos: " + String.valueOf(contadorDeportivos));
                    ReligiososF.setText("Eventos religiosos: " + String.valueOf(contadorReligiosos));
                    MusicalesF.setText("Eventos musicales: " + String.valueOf(contadorMusicales));
                    MontoTotalF.setText("Monto total: " + String.valueOf(montoTotal));
                }catch (Exception e){
                    Toast fmsg = Toast.makeText(EventosEntreDosFechas.this, e.getMessage(), Toast.LENGTH_SHORT);
                    fmsg.show();
                }
            }
        });
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
