package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.usage.UsageEvents;
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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CrearEventoDeportivo extends AppCompatActivity implements View.OnClickListener {
    private int año,mes,dia;
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    int dia1,dia2,mes1,mes2,ano1,ano2;
    private Spinner spinner;
    private EditText event,tittle,eventdescription,eventamount,campofecha,team1,team2,people,member1,member2;
    private Button saved,add1,add2,eliminar1,eliminar2;
    AlmacenEventos almacenEventos=new AlmacenEventos();
    AlmacenEventos fecha=new AlmacenEventos();
    private ArrayList<String> teams1 = new ArrayList<>();
    private ArrayList<String> teams2 = new ArrayList<>();
private int codeevent=0, nuevo=0, codigorecibido=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_create__event_deportivo);
         event =(EditText)findViewById(R.id.eventcoder);
         tittle =(EditText)findViewById(R.id.eventtittler);
         eventdescription =(EditText)findViewById(R.id.eventdescriptionr);
         eventamount =(EditText)findViewById(R.id.costos);
         saved=(Button)findViewById(R.id.saved);
         team1=(EditText)findViewById(R.id.team1s);
         team2=(EditText)findViewById(R.id.team2s);
         member1=(EditText)findViewById(R.id.nameteam1out);
         member2=(EditText)findViewById(R.id.nameteam2out);
         people=(EditText)findViewById(R.id.peoples);
         saved.setOnClickListener(this);
         campofecha= (EditText)findViewById(R.id.dateeventr);
         spinner= (Spinner)findViewById(R.id.event_type);
         List list= new ArrayList();

        list.add("Futbol");
        list.add("Tenis");
        list.add("Rugby");
        list.add("Baseball");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

        add1=(Button)findViewById(R.id.addtesam1);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nuevo == 1) {
                    if (TextUtils.isEmpty(member1.getText().toString())) {
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
                        msg.show();
                    } else {
                        for (String e : teams1) {
                            if (e.equals(member1.getText().toString())) {
                                Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Already exists", Toast.LENGTH_SHORT);
                                msg.show();
                                return;
                            }
                        }
                        teams1.add(member1.getText().toString());
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Add", Toast.LENGTH_SHORT);
                        msg.show();
                        member1.setText("");
                    }
                }else if(nuevo==2){
                    almacenEventos.verificarexistencia(codigorecibido);
                    RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigorecibido);
                    if(registrarEventoDeportivo.comprobarname1(member1.getText().toString())){
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Already exists", Toast.LENGTH_SHORT);
                        msg.show();
                        return;
                    }else{
                    registrarEventoDeportivo.registrarteam1(member1.getText().toString());
                    Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Add", Toast.LENGTH_SHORT);
                    msg.show();
                    member1.setText("");
                    }
                }

            }
        });
        add2=(Button)findViewById(R.id.addtesam2);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nuevo==1){
                    if(TextUtils.isEmpty(member2.getText().toString())){
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
                        msg.show();

                    }else{
                        for (String e : teams2) {
                            if (e.equals(member2.getText().toString())) {
                                Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Already exists", Toast.LENGTH_SHORT);
                                msg.show();
                                return;
                            }
                        }

                        teams2.add(member2.getText().toString());
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Add", Toast.LENGTH_SHORT);
                        msg.show();
                        member2.setText("");
                    }
                }else if(nuevo==2){
                    almacenEventos.verificarexistencia(codigorecibido);
                    RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigorecibido);
                    if(registrarEventoDeportivo.comprobarname2(member2.getText().toString())){
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Already exists", Toast.LENGTH_SHORT);
                        msg.show();
                        return;
                    }else {

                        registrarEventoDeportivo.registrarteam2(member2.getText().toString());
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Add", Toast.LENGTH_SHORT);
                        msg.show();
                        member2.setText("");
                    }
                }
            }
        });


        if(nuevo==2){
            codigorecibido = (Integer) getIntent().getExtras().get("enviarcodigo");
            almacenEventos.verificarexistencia(codigorecibido);
            RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigorecibido);
            event.setText(String.valueOf(registrarEventoDeportivo.getEvent()));
            tittle.setText(String.valueOf(registrarEventoDeportivo.getTittle()));
            eventdescription.setText(String.valueOf(registrarEventoDeportivo.getDescription()));
            eventamount.setText(String.valueOf(registrarEventoDeportivo.getAmount()));
            campofecha.setText(String.valueOf(registrarEventoDeportivo.getDate()));
            team1.setText(String.valueOf(registrarEventoDeportivo.getTeam1()));
            team2.setText(String.valueOf(registrarEventoDeportivo.getTeam2()));
            people.setText(String.valueOf(registrarEventoDeportivo.getPeople()));
            codigorecibido = (Integer) getIntent().getExtras().get("enviarcodigo");
        }


        eliminar1=(Button)findViewById(R.id.deleteteam1);
        eliminar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
try {
    if (nuevo == 1) {
        if (TextUtils.isEmpty(member1.getText().toString())) {
            Toast msg = Toast.makeText(CrearEventoDeportivo.this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
            msg.show();
        } else {
            for (String e : teams1) {
                if (e.equals(member1.getText().toString())) {
                    teams1.remove(e);
                    member1.setText("");
                    Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Delete", Toast.LENGTH_SHORT);
                    msg.show();
                    return;
                }
            }
            Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Name not found", Toast.LENGTH_SHORT);
            msg.show();

        }
    } else if (nuevo == 2) {
        if (TextUtils.isEmpty(member1.getText().toString())) {
            Toast msg = Toast.makeText(CrearEventoDeportivo.this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
            msg.show();

        } else {
            codigorecibido = (Integer) getIntent().getExtras().get("enviarcodigo");
            almacenEventos.verificarexistencia(codigorecibido);
            RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigorecibido);
            if (registrarEventoDeportivo.deleteteam1(member1.getText().toString())) {
                member1.setText("");
                Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Delete", Toast.LENGTH_SHORT);
                msg.show();
            } else {
                Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Name not found", Toast.LENGTH_SHORT);
                msg.show();
            }

        }
    }
}catch (Exception e){
    System.out.println(e.getMessage());
}
            }
        });

        eliminar2=(Button)findViewById(R.id.deleteteam2);
        eliminar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nuevo==1){
                    if(TextUtils.isEmpty(member2.getText().toString())){
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "PLEASE FILL IN THE FIELD.", Toast.LENGTH_SHORT);
                        msg.show();
                    } else{
                        for(String  e:teams2){
                            if(e.equals(member2.getText().toString())){
                                teams2.remove(e);
                                member2.setText("");
                                Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Delete", Toast.LENGTH_SHORT);
                                msg.show();
                                return;
                            }
                        }
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Name not found", Toast.LENGTH_SHORT);
                        msg.show();
                    }
                }else if(nuevo==2){
                    if(TextUtils.isEmpty(member2.getText().toString())){
                        Toast msg = Toast.makeText(CrearEventoDeportivo.this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
                        msg.show();
                    } else{
                        codigorecibido = (Integer) getIntent().getExtras().get("enviarcodigo");
                        almacenEventos.verificarexistencia(codigorecibido);
                        RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigorecibido);
                        if(registrarEventoDeportivo.deleteteam2(member2.getText().toString())){
                            member2.setText("");
                            Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Delete", Toast.LENGTH_SHORT);
                            msg.show();
                        }else{
                            Toast msg = Toast.makeText(CrearEventoDeportivo.this, "Name not found", Toast.LENGTH_SHORT);
                            msg.show();
                        }

                    }
                }
            }
        });


    }

    public void onClick(View v) {
        int seleccion= v.getId();

        try{
            switch (seleccion) {
                case R.id.saved:
                    if (nuevo == 1) {
                        AlmacenEventos almacen = new AlmacenEventos();
                        Calendar calendario = Calendar.getInstance();
                        ano2 = calendario.get(Calendar.YEAR);
                        mes2 = calendario.get(Calendar.MONTH);
                        dia2 = calendario.get(Calendar.DAY_OF_MONTH);
                        if (TextUtils.isEmpty(spinner.toString()) || TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText()) || TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText()) || TextUtils.isEmpty(team1.getText()) || TextUtils.isEmpty(team2.getText()) || TextUtils.isEmpty(people.getText())) {
                            Toast msg = Toast.makeText(this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
                            msg.show();
                        } else if (!almacenEventos.comparardeportivo(campofecha.getText().toString()) || !almacenEventos.compararreligioso(campofecha.getText().toString()) || !almacenEventos.compararmusical(campofecha.getText().toString())) {
                            Toast msg = Toast.makeText(this, "Already exists this date", Toast.LENGTH_SHORT);
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
                            Event event = new RegistrarEventoDeportivo(spinner.toString(), tittle.getText().toString(), codeevent, eventdescription.getText().toString(), campofecha.getText().toString(), eventamount.getText().toString(), team1.getText().toString(), team2.getText().toString(), people.getText().toString(), año, mes, dia,teams1,teams2);
                            almacenEventos.registrardeportivo((RegistrarEventoDeportivo) event);
                            Toast fmsg = Toast.makeText(this, "SUCCESSFUL REGISTRATION", Toast.LENGTH_SHORT);
                            fmsg.show();
                            Intent intent = new Intent(this, MenuEvents.class);
                            intent.putExtra("nuevo",nuevo);
                            startActivity(intent);
                            finish();
                        }


                    }else if(nuevo==2){
                        RegistrarEventoDeportivo registrarEventoDeportivos = almacenEventos.buscarEventodeportivo(codigorecibido);
                        AlmacenEventos almacenes = new AlmacenEventos();
                        almacenes.verificarexistencia(Integer.parseInt(event.getText().toString()));
                        RegistrarEventoDeportivo registrarEventoDeportivosm = almacenEventos.buscarEventodeportivo(Integer.parseInt(event.getText().toString()));
                        RegistrarEventoMusical registrarEventoMusicalam= almacenEventos.buscareventomusical(Integer.parseInt(event.getText().toString()));
                        RegistrarEventoReligioso registrarEventoReligiosoam = almacenEventos.buscareventoreligioso(Integer.parseInt(event.getText().toString()));
                        if (TextUtils.isEmpty(spinner.toString()) || TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText()) || TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText()) || TextUtils.isEmpty(team1.getText()) || TextUtils.isEmpty(team2.getText()) || TextUtils.isEmpty(people.getText())) {
                            Toast msg = Toast.makeText(this, "PLEASE FILL IN THE FIELD", Toast.LENGTH_SHORT);
                            msg.show();
                        } else if (!almacenEventos.compararreligioso(campofecha.getText().toString()) || !almacenEventos.compararmusical(campofecha.getText().toString())) {
                            Toast msg = Toast.makeText(this, "Already exists this date", Toast.LENGTH_SHORT);
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
                        }else if(registrarEventoDeportivosm !=null && registrarEventoDeportivos != registrarEventoDeportivosm  ){
                            Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                            fmsg.show();
                        }else if(registrarEventoMusicalam !=null && registrarEventoDeportivos.getEvent() == registrarEventoMusicalam.getEvent()   ){
                            Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                            fmsg.show();
                        }else if(registrarEventoReligiosoam !=null  && registrarEventoDeportivos.getEvent() == registrarEventoReligiosoam.getEvent()  ) {
                            Toast fmsg = Toast.makeText(this, "THERE IS AN EVENT WITH THAT CODE", Toast.LENGTH_SHORT);
                            fmsg.show();
                        } else if(fecha.buscarfechadep(String.valueOf(campofecha.getText().toString()), registrarEventoDeportivos)){
                            Toast msg = Toast.makeText(this, "Already exists this date", Toast.LENGTH_SHORT);
                            msg.show();
                        } else if(teams1.size()==0 || teams2.size()==0){
                            Toast msg = Toast.makeText(this, "Record least one member per team", Toast.LENGTH_SHORT);
                            msg.show();
                        } else{
                            RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigorecibido);
                            registrarEventoDeportivo.setEvent((Integer.parseInt(event.getText().toString())));
                            registrarEventoDeportivo.setTittle((String.valueOf(tittle.getText().toString())));
                            registrarEventoDeportivo.setDescription((String.valueOf(eventdescription.getText().toString())));
                            registrarEventoDeportivo.setAmount((String.valueOf(eventamount.getText().toString())));
                            registrarEventoDeportivo.setDate((String.valueOf(campofecha.getText().toString())));
                            registrarEventoDeportivo.setTeam1((String.valueOf(team1.getText().toString())));
                            registrarEventoDeportivo.setTeam2((String.valueOf(team2.getText().toString())));
                            registrarEventoDeportivo.setPeople((String.valueOf(people.getText().toString())));
                            registrarEventoDeportivo.setType((String.valueOf(spinner.toString())));
                            registrarEventoDeportivo.setDia(dia);
                            registrarEventoDeportivo.setMes(mes);
                            registrarEventoDeportivo.setAño(año);
                            Toast fmsg = Toast.makeText(this, "EXCHANGE REALIZED SUCCESSFULLY", Toast.LENGTH_SHORT);
                            fmsg.show();
                            Intent intent = new Intent(this, MenuEvents.class);
                            intent.putExtra("nuevo",nuevo);
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

}
