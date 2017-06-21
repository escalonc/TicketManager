package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CrearEventoReligioso extends AppCompatActivity implements View.OnClickListener{
    private int año,mes,dia;
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    int dia1,dia2,mes1,mes2,ano1,ano2;
    private EditText event,tittle,eventdescription,eventamount,campofecha,people;
    private Button saved,calculate;
    double total=0;
    TextView totalapagar;
    AlmacenEventos almacenEventos=new AlmacenEventos();
    AlmacenEventos fecha=new AlmacenEventos();
    private int codeevent=0,nuevo=0,codigorecibido=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento_religioso);
        event =(EditText)findViewById(R.id.eventcoderreligioso);
        totalapagar= (TextView)findViewById(R.id.costostotalreligioso);
        tittle =(EditText)findViewById(R.id.eventdescriptionrreligioso);
        eventdescription =(EditText)findViewById(R.id.peoplesreligioso);
        eventamount =(EditText)findViewById(R.id.costosreligioso);
        saved=(Button)findViewById(R.id.religiososs);
        people=(EditText)findViewById(R.id.peoplesreligioso);
        saved.setOnClickListener(this);
        campofecha= (EditText)findViewById(R.id.dateeventrreligioso);

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

        nuevo = (Integer) getIntent().getExtras().get("nuevo");

        calculate=(Button)findViewById(R.id.calculatereligioso);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(eventamount.getText().toString())){
                    Toast msg = Toast.makeText(CrearEventoReligioso.this, "PLEASE, FILL THE FIELD", Toast.LENGTH_SHORT);
                    msg.show();
                }else{
                    total= Integer.parseInt(eventamount.getText().toString()) +2000;
                    totalapagar.setText(String.valueOf(total));
                }
            }
        });


        if(nuevo==2){
            codigorecibido = (Integer) getIntent().getExtras().get("enviarcodigo");
            almacenEventos.verificarexistencia(codigorecibido);
            RegistrarEventoReligioso registrarEventoReligioso = almacenEventos.buscareventoreligioso(codigorecibido);
            event.setText(String.valueOf(registrarEventoReligioso.getEvent()));
            tittle.setText(String.valueOf(registrarEventoReligioso.getTittle()));
            eventdescription.setText(String.valueOf(registrarEventoReligioso.getDescription()));
            eventamount.setText(String.valueOf(registrarEventoReligioso.getAmount()));
            campofecha.setText(String.valueOf(registrarEventoReligioso.getDate()));
            people.setText(String.valueOf(registrarEventoReligioso.getPeople()));

        }

    }

    public void onClick(View v) {
        int seleccion= v.getId();

        try{
            switch (seleccion) {
                case R.id.religiososs:
                    if (nuevo == 1) {
                        AlmacenEventos almacen = new AlmacenEventos();
                        Calendar calendario = Calendar.getInstance();
                        ano2 = calendario.get(Calendar.YEAR);
                        mes2 = calendario.get(Calendar.MONTH);
                        dia2 = calendario.get(Calendar.DAY_OF_MONTH);
                        if (TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText()) || TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText()) || TextUtils.isEmpty(people.getText())) {
                            Toast msg = Toast.makeText(this, "PLEASE, FILL THE FIELD", Toast.LENGTH_SHORT);
                            msg.show();
                        } else if (!almacenEventos.comparardeportivo(campofecha.getText().toString()) || !almacenEventos.compararreligioso(campofecha.getText().toString()) || !almacenEventos.compararmusical(campofecha.getText().toString())) {
                            Toast msg = Toast.makeText(this, "This date already exists", Toast.LENGTH_SHORT);
                            msg.show();
                        } else if (ano1 < ano2) {
                            Toast fmsg = Toast.makeText(this, "THAT DATE IS NOT VALID", Toast.LENGTH_SHORT);
                            fmsg.show();
                        } else if (ano1 == ano2 && mes1 < mes2) {
                            Toast fmsg = Toast.makeText(this, "THAT DATE IS NOT VALID", Toast.LENGTH_SHORT);
                            fmsg.show();
                        } else if (ano1 == ano2 && mes1 == mes2 && dia1 < dia2) {
                            Toast fmsg = Toast.makeText(this, "THAT DATE IS NOT VALID", Toast.LENGTH_SHORT);
                            fmsg.show();
                        } else if (Integer.parseInt(people.getText().toString()) > 20000) {
                            Toast fmsg = Toast.makeText(this, "THE MAXIMUM AMOUNT IS 20000 PEOPLE", Toast.LENGTH_SHORT);
                            fmsg.show();
                        } else if (almacen.verificarexistencia(Integer.parseInt(event.getText().toString()))) {
                            Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                            fmsg.show();
                        } else {
                            codeevent = Integer.parseInt(event.getText().toString());
                            String costo= String.valueOf(Integer.parseInt(eventamount.getText().toString())+ 2000) ;
                            Event event = new RegistrarEventoReligioso(tittle.getText().toString(),codeevent, eventdescription.getText().toString(), campofecha.getText().toString(), costo, people.getText().toString(), dia, mes, año);
                            almacenEventos.registrarreligioso((RegistrarEventoReligioso) event);
                            Toast fmsg = Toast.makeText(this, "SUCCESSFUL REGISTRATION", Toast.LENGTH_SHORT);
                            fmsg.show();
                            Intent intent = new Intent(this, MenuEvents.class);
                            startActivity(intent);
                            finish();
                        }
                    }else if(nuevo==2){

                            RegistrarEventoReligioso registrarEventoReligioso = almacenEventos.buscareventoreligioso(codigorecibido);
                            AlmacenEventos almacenes = new AlmacenEventos();
                            almacenes.verificarexistencia(Integer.parseInt(event.getText().toString()));
                            RegistrarEventoDeportivo registrarEventoDeportivosm = almacenEventos.buscarEventodeportivo(Integer.parseInt(event.getText().toString()));
                            RegistrarEventoMusical registrarEventoMusicalam = almacenEventos.buscareventomusical(Integer.parseInt(event.getText().toString()));
                            RegistrarEventoReligioso registrarEventoReligiosoam = almacenEventos.buscareventoreligioso(Integer.parseInt(event.getText().toString()));
                            if ( TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText()) || TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText()) || TextUtils.isEmpty(people.getText())) {
                                Toast msg = Toast.makeText(this, "PLEASE, FILL THE FIELD", Toast.LENGTH_SHORT);
                                msg.show();
                            } else if (!almacenEventos.comparardeportivo(campofecha.getText().toString()) || !almacenEventos.compararmusical(campofecha.getText().toString())) {
                                Toast msg = Toast.makeText(this, "This date already exists", Toast.LENGTH_SHORT);
                                msg.show();
                            } else if (ano1 < ano2) {
                                Toast fmsg = Toast.makeText(this, "THAT DATE IS NOT VALID", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if (ano1 == ano2 && mes1 < mes2) {
                                Toast fmsg = Toast.makeText(this, "THAT DATE IS NOT VALID", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if (ano1 == ano2 && mes1 == mes2 && dia1 < dia2) {
                                Toast fmsg = Toast.makeText(this, "THAT DATE IS NOT VALID", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if (Integer.parseInt(people.getText().toString()) > 20000) {
                                Toast fmsg = Toast.makeText(this, "THE MAXIMUM AMOUNT IS 20000 PEOPLE", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if (registrarEventoReligioso != registrarEventoReligiosoam && registrarEventoReligiosoam != null) {
                                Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if (registrarEventoMusicalam != null && registrarEventoReligioso.getEvent() == registrarEventoMusicalam.getEvent() ) {
                                Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if ( registrarEventoDeportivosm != null && registrarEventoReligioso.getEvent() == registrarEventoDeportivosm.getEvent() ) {
                                Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                                fmsg.show();
                            } else if (fecha.buscarfecharel(String.valueOf(campofecha.getText().toString()), registrarEventoReligioso)){
                                Toast msg = Toast.makeText(this, "This date already exists", Toast.LENGTH_SHORT);
                                msg.show();
                            } else {
                                RegistrarEventoReligioso registrarEventoReligioso1 = almacenEventos.buscareventoreligioso(codigorecibido);
                                registrarEventoReligioso1.setEvent((Integer.parseInt(event.getText().toString())));
                                registrarEventoReligioso1.setTittle((String.valueOf(tittle.getText().toString())));
                                registrarEventoReligioso1.setDescription((String.valueOf(eventdescription.getText().toString())));
                                registrarEventoReligioso1.setAmount((String.valueOf(total())));
                                registrarEventoReligioso1.setDate((String.valueOf(campofecha.getText().toString())));
                                registrarEventoReligioso1.setPeople((String.valueOf(people.getText().toString())));
                                registrarEventoReligioso1.setDia(dia);
                                registrarEventoReligioso1.setMes(mes);
                                registrarEventoReligioso1.setAño(año);
                                Toast fmsg = Toast.makeText(this, "EXCHANGE REALIZED SUCCESSFULLY", Toast.LENGTH_SHORT);
                                fmsg.show();
                                Intent intent = new Intent(this, MenuEvents.class);
                                startActivity(intent);
                                finish();
                            }

                    }
                    break;
            }


        }catch (Exception e){

        }
    }


    public void mostrarfecha(){
        dia1=dia;
        mes1=mes;
        ano1=año;


        campofecha.setText(dia+"/"+(mes+1)+"/"+año);
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
    public void mostrarCalendar(View control){
        showDialog(tipo_dialogo);
    }

    public double total() {
        if (TextUtils.isEmpty(eventamount.getText().toString())) {
            Toast msg = Toast.makeText(CrearEventoReligioso.this, "PLEASE, FILL THE FIELD", Toast.LENGTH_SHORT);
            msg.show();
            return -1;
        } else {
            return total = Integer.parseInt(eventamount.getText().toString()) + 2000;
        }
    }
}
