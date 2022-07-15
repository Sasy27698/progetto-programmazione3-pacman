package com.project;

public class HouseMode extends GhostState {
    public HouseMode(Ghost ghost) {
        super(ghost);
    }
    @Override
    public int[] eaten() {
        int[] position = new int[8];
        position[0] = 241;
        position[1] = 313;
        position[2] = 25;
        position[3] = 193;
        position[4] = 193;
        position[5] = 25;
        position[6] = 193;
        position[7] = 193;
        return position;
    }
}