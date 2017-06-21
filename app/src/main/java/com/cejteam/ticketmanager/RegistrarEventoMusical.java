package com.cejteam.ticketmanager;

import android.app.usage.UsageEvents;

import java.util.ArrayList;

/**
 * Created by joel.caballero on 17/6/2017.
 */

public class RegistrarEventoMusical extends Event{
    private String type;
    private ArrayList<String> peopleOfSupport = new ArrayList<>();

    public  boolean deletemembers(String name) {
        for (String e : peopleOfSupport) {
            if (e.equals(name)) {
                peopleOfSupport.remove(e);
                return true;
            }
        }
        return false;
    }

    public RegistrarEventoMusical() {

    }

    public void registrarmembers(ArrayList<String> teams1) {
        this.peopleOfSupport = teams1;
    }



    public ArrayList<String> getPeopleOfSupport() {
        return peopleOfSupport;
    }

    public void setPeopleOfSupport(ArrayList<String> peopleOfSupport) {
        this.peopleOfSupport = peopleOfSupport;
    }

    public void addpeoplesupport(String name){
        peopleOfSupport.add(name);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public RegistrarEventoMusical(String type, String s, int codeevent, String description, String date, String amount, String people,int dia,int mes, int año, ArrayList<String> members) {
        super(codeevent, s, description, date, amount, people, dia, mes, año);
        this.type=type;
        this.peopleOfSupport=members;
    }

}
