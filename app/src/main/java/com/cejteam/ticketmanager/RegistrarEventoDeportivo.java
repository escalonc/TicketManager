package com.cejteam.ticketmanager;

/**
 * Created by joel.caballero on 24/5/2017.
 */

public class RegistrarEventoDeportivo {
private String type,tittle,description,date,amount,team1,team2,people;
int event;


    public RegistrarEventoDeportivo(String type, String s, int codeevent, String description, String date, String amount,String team1,String team2, String people) {
        this.type = type;
        this.event = codeevent;
        this.tittle = s;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.team1=team1;
        this.team2=team2;
        this.people=people;
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
