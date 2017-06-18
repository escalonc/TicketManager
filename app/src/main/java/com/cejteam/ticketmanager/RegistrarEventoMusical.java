package com.cejteam.ticketmanager;

/**
 * Created by joel.caballero on 17/6/2017.
 */

public class RegistrarEventoMusical {
    private String type,tittle,description,date,amount,totalapagar,people;
    int event, dia,mes,año;



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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTotalapagar() {
        return totalapagar;
    }

    public void setTotalapagar(String totalapagar) {
        this.totalapagar = totalapagar;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public RegistrarEventoMusical(String type, String s, int codeevent, String description, String date, String amount, String people, String totalapagar,int dia,int mes, int año) {
        this.type = type;
        this.event = codeevent;
        this.tittle = s;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.people=people;
        this.totalapagar=totalapagar;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

}
