package com.project;

public class ChaseState extends GhostState{
    public ChaseState(Ghost ghost){
        super(ghost);
    }
    @Override
    public void timerFrightenedModeOver(){
        ghost.switchChaseMode();
    }
}
