package com.project;

import java.util.Random;

public class Pinkystrategy implements IAGhost {
    final private Random random;
    private int position;
    public Pinkystrategy(){random = new Random();}

    @Override
    public int[] getChaseposition(Ghost ghost)
    {
            int[] position = new int[2];
            position[0] = ghost.getXpos();
            position[1] = ghost.getYpos();
            return position;
    }
    @Override
    public int getFrightenedposition()
    {
        position = random.nextInt(4);
        return position;
    }
}
