package com.cejteam.ticketmanager;

import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joel.caballero on 24/5/2017.
 */

public class RegistrarEventoDeportivo {
private String type,tittle,description,date,amount,team1,team2,people;
int event,dia,mes,año;
    ImageView representacion;

    public RegistrarEventoDeportivo() {

    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }



    public RegistrarEventoDeportivo(String type, String s, int codeevent, String description, String date, String amount, String team1, String team2, String people, int año, int mes, int dia) {
        this.type = type;
        this.event = codeevent;
        this.tittle = s;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.team1=team1;
        this.team2=team2;
        this.people=people;
        this.dia = dia;
        this.mes = mes;
        this.año = año;

    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
