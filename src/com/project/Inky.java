package com.project;

public class Inky extends Ghost{

    public Inky()
    {
        super("inky.gif",193,193);
        setStrategy(new Inkystrategy());
        inithitbox();
        updatehitbox();
    }
}
