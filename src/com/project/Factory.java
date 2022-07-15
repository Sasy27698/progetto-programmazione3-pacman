package com.project;

public class Factory {
    public Drawpoint getShape(String shapetype){
        if(shapetype == null){
            return null;
        }
        if(shapetype.equals("PacGum")){
            return new PacGum();
        } else if (shapetype.equals("SuperPacGum")) {
            return new SuperPacGum();

        }
        return null;
    }
}
