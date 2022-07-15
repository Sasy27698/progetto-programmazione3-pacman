package com.project;

public abstract class GhostState {
    protected Ghost ghost;

    public GhostState(Ghost ghost) {
        this.ghost = ghost;
    }
    public int[] eaten() {
        return new int[8];
    }
    public void timerFrightenedModeOver() {}


}
