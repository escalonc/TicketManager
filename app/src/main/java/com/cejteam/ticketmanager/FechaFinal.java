package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class FechaFinal extends AppCompatActivity {
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    EditText fecha;
    int año,mes,dia,dia1,mes1,ano1,anopasado=0,mespasado=0,diapasado=0;
    Button next,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_final);



        menu=(Button)findViewById(R.id.menu67898);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(FechaFinal.this,MenuEvents.class);
                startActivity(intenst);
            }
        });











try {
    anopasado = (Integer) getIntent().getExtras().get("ano1");
    mespasado = (Integer) getIntent().getExtras().get("mes1");
    diapasado = (Integer) getIntent().getExtras().get("dia1");
}catch (Exception e){}

/////////////////////////////////////////////////////////////////
        Calendar calendar= Calendar.getInstance();
        año= calendar.get(Calendar.YEAR);
        mes= calendar.get(Calendar.MONTH);
        dia= calendar.get(Calendar.DAY_OF_MONTH);
        mostrarfecha();
        oyenteSelectorFecha = new  DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año=year;
                mes=month;
                dia=dayOfMonth;
                mostrarfecha();
            }

        };
        /////////////////////////////////////////////////////////////////


        fecha= (EditText)findViewById(R.id.fechafinalcalendar);
        next=(Button)findViewById(R.id.fechafinalcalc);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(comparar(anopasado,mespasado,diapasado,ano1,mes1,dia1)){

                        Intent intenst = new Intent(FechaFinal.this,EventosEntreDosFechas.class);
                        intenst.putExtra("ano1",anopasado);
                        intenst.putExtra("mes1",mespasado);
                        intenst.putExtra("dia1",diapasado);
                        intenst.putExtra("ano2",ano1);
                        intenst.putExtra("mes2",mes1);
                        intenst.putExtra("dia2",dia1);
                        startActivity(intenst);
                        finish();

                    } else{
                        Toast msg = Toast.makeText(FechaFinal.this, "Enter a date greater than the previous one", Toast.LENGTH_SHORT);
                        msg.show();
                    }

                }catch (Exception e){}


            }
        });
    }

    /////////////////////////////////////////////////////////////////

    public void mostrarfecha() {
        try {
            dia1 = dia;
            mes1 = mes;
            ano1 = año;


            fecha.setText(dia + "/" + (mes + 1) + "/" + año);
        }catch (Exception e){}
    }
    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case 0:
                return new DatePickerDialog(this, oyenteSelectorFecha, año, mes, dia);

            /*
            POR SI LA FECHA APARECE EN 1900 INICIALIZADA
            return new DatePickerDialog(this,oyenteSelectorFecha,año,mes,dia)
            */

        }
        return null;
    }
    public void mostrarCalendar2(View control){
        showDialog(tipo_dialogo);
    }






    public boolean comparar(int anopasado,int mespasado, int diapasado, int anoactual,int mesactual,int diaactual ){
        if(anopasado>anoactual){
            return false;
        }else if(anopasado==anoactual && mespasado>mesactual){
            return false;
        }else if(anopasado==anoactual && mespasado == mesactual && diapasado>diaactual){
            return false;
        }

        return true;
    }







}







