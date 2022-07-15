package com.project;


public class Pinky extends Ghost {
    public Pinky() {
        super("pinky.gif", 241, 313);
        setStrategy(new Pinkystrategy());
        inithitbox();
        updatehitbox();

    }

}
