package com.project;

public class Blinky extends Ghost{
    public Blinky()
    {
        super("blinky.gif",25,193);
        setStrategy(new Blinkystrategy());
        inithitbox();
        updatehitbox();
    }
}
