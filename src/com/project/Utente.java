package com.project;

import java.util.Random;
public class Utente {
    private String username;
    private int punteggio;
    private int ID;
    private Random random;
    public Utente(String username,int punteggio,int ID){
        this.username=username;
        this.punteggio=punteggio;
        this.ID=ID;
        random = new Random();
        this.ID=random.nextInt(10000);
    }
    public void setID() {
        random = new Random();
        this.ID=random.nextInt(10000);
    }
    public int getID() {
        return ID;
    }
    public void setPunteggio(int Punteggio) {
        this.punteggio = Punteggio;
    }
    public int getPunteggio() {
        return punteggio;
    }
    public void setUsername(String Username) {
        this.username = Username;
    }
    public String getUsername() {
        return this.username;
    }
}
