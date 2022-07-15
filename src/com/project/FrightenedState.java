package com.project;

public class FrightenedState extends GhostState{
    public FrightenedState(Ghost ghost)
    {
        super(ghost);
    }

    @Override
    public void timerFrightenedModeOver(){
        ghost.switchChaseMode();
    }

}
