package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Ghost implements ActionListener {
    private final Timer timer;
    private final Random random;
    private final int DIRECTION_UP = 2;
    private final int DIRECTION_DOWN = 3;
    private final int DIRECTION_LEFT = 1;
    private final int DIRECTION_RIGHT = 0;
    private  int DIRECTION = 4;
    private   GhostState State;
    private final GhostState frightened;
    final private GhostState house;
    final private GhostState chase;
    private  IAGhost ghost_strategy;
    private int frightenedTimer = 0;//fare get e set
    private int xpos;
    private int ypos;
    private boolean cont = false;
    private final int speed=1;
    private int xpos1,ypos1;
    private Rectangle ghitbox;//fare get e set
    private final int Mindistance=100;
    String spritename;
    final private Loadimg img;


    public enum StateGhost //stati dei fantasmi
    {
        spaventato,
        nospaventato
    }



    private StateGhost state = StateGhost.nospaventato;


    public Ghost(String spritename, int xpos, int ypos) {
        random = new Random();
        img = new Loadimg();
        this.spritename = spritename;
        this.xpos = xpos;
        this.ypos = ypos;
        frightened = new FrightenedState(this);
        chase = new ChaseState(this);
        house = new HouseMode(this);
        State = house;
        timer = new Timer(1000,this);
        timer.start();
    }
    public int gettimer(){return frightenedTimer;}
    public int settimer(){return frightenedTimer=0;}
    public void setXpos(int xpos){this.xpos=xpos;}
    public void setYpos(int ypos){this.ypos=ypos;}
    public int getXpos(){return xpos;}
    public int getYpos(){return ypos;}
    public void inithitbox(){
        ghitbox= new Rectangle(22,22);
    }
    public void updatehitbox(){
        ghitbox.x=xpos;
        ghitbox.y=ypos;
    }
    public Rectangle getghitbox(){return ghitbox;}



    public void DrawGhost(Graphics2D g)
    {
        img.loadimg();
        if (state == Ghost.StateGhost.nospaventato)
        {
            g.drawImage(new ImageIcon("src//img//" + spritename).getImage(), this.xpos+1, this.ypos+1, null);
            ghoststate();
        } else if (state == Ghost.StateGhost.spaventato) {
            g.drawImage(new ImageIcon("src//img//scary_ghost.png").getImage(), this.xpos + 1, this.ypos + 1, null);
            ghoststate();
        }
    }
    public void ghoststate(){
        if(State == house)
        {
            state = StateGhost.nospaventato;
        }
        if(State == chase)
        {
            state = StateGhost.nospaventato;
        }
        if(State == frightened)
        {
            state = StateGhost.spaventato;
        }
        if (frightenedTimer == 30) {
            State.timerFrightenedModeOver();
            frightenedTimer=0;
        }
    }
    public IAGhost getStrategy() { return this.ghost_strategy;}

    public int[] gethome()
    {
        return State.eaten();
    }
    public void setStrategy(IAGhost ghost_strategy) { //Lo prende
        this.ghost_strategy = ghost_strategy;
    }

    public void switchChaseMode() { State = chase; }
    public void switchFrightenedMode() {
        frightenedTimer = 0;
        State = frightened;
    }
    public void switchHouseMode()
    {
        State = house;
    }

    public void moveghost(Maze maze) {
        if (xpos % maze.getblocksize() == 1 && ypos % maze.getblocksize() == 1) {
            if (DIRECTION == DIRECTION_UP) {
                ypos1 = 1;
                xpos1 = 0;
            }
            if (DIRECTION == DIRECTION_DOWN) {
                ypos1 = -1;
                xpos1 = 0;
            }
            if (DIRECTION == DIRECTION_LEFT) {
                xpos1 = -1;
                ypos1 = 0;
            }
            if (DIRECTION == DIRECTION_RIGHT) {
                xpos1 = 1;
                ypos1 = 0;
            }
            if(xpos1==-1 && ypos1==0 && xpos==25){
                xpos1=0;
            }
            if(xpos1==1 && ypos1==0 && xpos==337){
                xpos1=0;
            }
            if(xpos1==0 && ypos1==1 && ypos==337){
                ypos1=0;
            }
            if(xpos1==0 && ypos1==-1 && ypos==25){
                ypos1=0;
            }
            if (xpos1 == 1 && ypos1 == 0 && (xpos == 49 || xpos == 241) && (ypos == 73 || ypos == 97 || ypos == 265 || ypos == 289)) {
                xpos1 = 0;
            }
            if (xpos1 == -1 && ypos1 == 0 && (xpos == 121 || xpos == 313) && (ypos == 73 || ypos == 97 || ypos == 265 || ypos == 289)) {
                xpos1 = 0;
            }
            if(xpos1==0 && ypos1==1 &&(ypos==49|| ypos==241)&&(xpos==73||xpos==97||xpos==265||xpos==289)){
                ypos1=0;
            }
            if(xpos1==0 && ypos1==-1 &&(ypos==121||ypos==313)&&(xpos==73||xpos==97||xpos==265||xpos==289)){
                ypos1=0;
            }
            if (xpos1==1  && ypos1 == 0 && (xpos == 73||xpos==217 ) && (ypos == 169||ypos==193 )) {
                xpos1 = 0;
            }
            if (xpos1 == -1 && ypos1 == 0 && (xpos == 145||xpos==289 ) && (ypos == 169||ypos==193 )) {
                xpos1 = 0;
            }
            if(xpos1==0 && ypos1==1 &&(ypos==145)&&(xpos==97||xpos==121||xpos==241||xpos==265)){
                ypos1=0;
            }
            if(xpos1==0 && ypos1==-1 &&(ypos==217)&&(xpos==97||xpos==121||xpos==241||xpos==265)){
                ypos1=0;
            }
        }
        xpos = xpos + speed * xpos1;
        ypos = ypos + speed * ypos1;
    }


    public double getDistance(int px,int py,int gx,int gy)
    {
        double distance;
        distance=Math.sqrt(Math.pow(px-gx,2)+Math.pow(py-gy,2));
        return distance;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!cont) {
            DIRECTION = random.nextInt(4);
        } else {
            cont = false;
        }

        if(State == house)
        {
            switchHouseMode();
        }
        if(State == frightened)
        {
            frightenedTimer++;
            DIRECTION = getStrategy().getFrightenedposition();
            if(DIRECTION==DIRECTION_UP)
            {
                DIRECTION=DIRECTION_DOWN;
            }
            else if(DIRECTION==DIRECTION_DOWN)
            {
                DIRECTION=DIRECTION_UP;
            }
            else if(DIRECTION==DIRECTION_LEFT)
            {
                DIRECTION=DIRECTION_RIGHT;
            }
            else if(DIRECTION==DIRECTION_RIGHT)
            {
                DIRECTION= DIRECTION_LEFT;
            }
        }
        else if(getDistance(Game.getPacman().getpacman_x(),Game.getPacman().getpacman_y(),getStrategy().getChaseposition(this)[0],getStrategy().getChaseposition(this)[1])<Mindistance)
        {
            switchChaseMode();
            if(Game.getPacman().getpacman_x() < xpos && Game.getPacman().getpacman_y()<ypos)
            {
                DIRECTION = DIRECTION_LEFT;

            }
            else if (Game.getPacman().getpacman_x() > xpos && Game.getPacman().getpacman_y()>ypos)
            {
                DIRECTION = DIRECTION_RIGHT;
            }
            if(Game.getPacman().getpacman_x() > xpos && Game.getPacman().getpacman_y()<ypos)
            {
                DIRECTION = DIRECTION_DOWN;
            }
            else if (Game.getPacman().getpacman_x() < xpos && Game.getPacman().getpacman_y()>ypos)
            {
                DIRECTION=DIRECTION_UP;
            }
        }
    }
}