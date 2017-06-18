package com.cejteam.ticketmanager;

/**
 * Created by joel.caballero on 17/6/2017.
 */

public class RegistrarEventoReligioso {
    private String tittle,description,date,amount,totalapagar,people;
    int event;

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

    public RegistrarEventoReligioso(String s, int codeevent, String description, String date, String amount, String people, String totalapagar) {
        this.event = codeevent;
        this.tittle = s;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.people=people;
        this.totalapagar=totalapagar;
    }

}

