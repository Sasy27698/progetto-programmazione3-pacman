package com.project;

public class Clyde extends Ghost {

    public Clyde() {
        super("clyde.gif", 193, 25);
        setStrategy(new Clydestrategy());
        inithitbox();
        updatehitbox();
    }
}