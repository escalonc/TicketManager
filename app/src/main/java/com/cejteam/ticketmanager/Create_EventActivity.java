package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Create_EventActivity extends AppCompatActivity implements View.OnClickListener {
    private int año,mes,dia;
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;

    private Spinner spinner;
    private EditText event,tittle,eventdescription,eventamount,campofecha;
    private Button saved;
    private ArrayList<Create_EventActivity> items;

    public Create_EventActivity() {

    }

    public Create_EventActivity(String musical, String prueba1, String mundial, String sudafrica, int i, String termino) {
    }


    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }

    public EditText getEvent() {
        return event;
    }

    public void setEvent(EditText event) {
        this.event = event;
    }

    public EditText getTittle() {
        return tittle;
    }

    public void setTittle(EditText tittle) {
        this.tittle = tittle;
    }

    public EditText getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(EditText eventdescription) {
        this.eventdescription = eventdescription;
    }

    public EditText getEventamount() {
        return eventamount;
    }

    public void setEventamount(EditText eventamount) {
        this.eventamount = eventamount;
    }

    public EditText getCampofecha() {
        return campofecha;
    }

    public void setCampofecha(EditText campofecha) {
        this.campofecha = campofecha;
    }

    public ArrayList<Create_EventActivity> getItems() {
        return items;
    }

    public void setItems(ArrayList<Create_EventActivity> items) {
        this.items = items;
    }

    public Create_EventActivity(Spinner spinner, EditText event, EditText tittle, EditText eventdescription, EditText campofecha, EditText eventamount) {
        this.spinner= spinner;
        this.event=event;
        this.tittle=tittle;
        this.eventdescription=eventdescription;
        this.campofecha=campofecha;
        this.eventamount=eventamount;
        items=new ArrayList<Create_EventActivity>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_create__event);
         event =(EditText)findViewById(R.id.eventcoder);
         tittle =(EditText)findViewById(R.id.eventtittler);
         eventdescription =(EditText)findViewById(R.id.eventdescriptionr);
         eventamount =(EditText)findViewById(R.id.eventamountr);
         saved=(Button)findViewById(R.id.saved);
         saved.setOnClickListener(this);
         campofecha= (EditText)findViewById(R.id.dateeventr);
         spinner= (Spinner)findViewById(R.id.event_type);
        List list= new ArrayList();
        list.add("Deportivo");
        list.add("Musical");
        list.add("Religioso");

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

    }

    public void onClick(View v) {
        int seleccion= v.getId();

        try{
            switch (seleccion){
                case R.id.saved:
                    if(TextUtils.isEmpty(spinner.toString()) ||TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText())|| TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText())){
                        Toast msg = Toast.makeText(this, "POR FAVOR, LLENE LOS CAMPOS QUE ESTAN VACIOS", Toast.LENGTH_SHORT);
                        msg.show();
                    }
                    for (int i = 0; i <items.size(); i++) {
                        Calendar fechaActual= Calendar.getInstance();
                        if(items.get(i).campofecha.equals(campofecha)){
                            Toast msg = Toast.makeText(this, "YA HAY UN EVENTO PARA ESA FECHA", Toast.LENGTH_SHORT);
                            msg.show();
                            break;
                        }else{
                            Toast msg = Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT);
                            msg.show();
                            items.add(new Create_EventActivity(spinner,event,tittle,eventdescription,campofecha,eventamount));
                        }
                    }
                    Toast msg = Toast.makeText(this, items.get(0).event.toString(), Toast.LENGTH_SHORT);
                    msg.show();
                    break;
            }

        }catch (Exception e){
            Toast msg = Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT);
            msg.show();
        };
}
    public void mostrarfecha(){
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
