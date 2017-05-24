package com.cejteam.ticketmanager;

/**
 * Created by joel.caballero on 24/5/2017.
 */

public class Register_events {
private String type,event,tittle,description,date,amount;

    public Register_events(String type, String event, String tittle, String description, String date, String amount) {
        this.type = type;
        this.event = event;
        this.tittle = tittle;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
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
