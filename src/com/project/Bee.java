package com.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Bee implements ActionListener {
    private Random random;
    private final Timer timer;
    private int speed=1;
    private int xpos1,ypos1;
    private boolean cont = false;
    private int DIRECTION = 4;
    private final int DIRECTION_UP = 2;
    private final int DIRECTION_DOWN = 3;
    private final int DIRECTION_LEFT = 1;
    private final int DIRECTION_RIGHT = 0;
    private int xpos;
    private int ypos;
    final private Loadimg img;
    private int pos;

    public Bee() {
        img = new Loadimg();
        xpos = 337;
        ypos = 25;
        timer = new Timer(1000, this);
        timer.start();
    }
    public void setXpos(int xpos){this.xpos=xpos;}
    public void setYpos(int ypos){this.ypos=ypos;}

    public void DrawBee(Graphics2D g)
    {
        img.loadimg();
if(xpos1==1 || xpos1 == 0) {
    g.drawImage(img.bee, this.xpos + 1, this.ypos + 1, null);
} else if (xpos1==-1 || xpos1 == 0) {
    g.drawImage(img.bee2, this.xpos + 1, this.ypos + 1, null);
}else if(ypos1==1|| ypos1==0){
    g.drawImage(img.bee1, this.xpos + 1, this.ypos + 1, null);
}
else if(ypos1==-1||ypos1==0){
    g.drawImage(img.bee3, this.xpos + 1, this.ypos + 1, null);
}
    }

    public void movebee(Maze maze) {
        if (xpos % maze.getblocksize() == 1 && ypos % maze.getblocksize() == 1) {
            pos = (xpos / maze.getblocksize()) + maze.getnblocks() * (ypos / maze.getblocksize());
            short ch = maze.screenData[pos];
            if (ch == 1) {
                maze.screenData[pos] = 0;
                maze.setscore(maze.getscore()-5);
                Game.getPacman().contapallini++;
            }
            if(ch == 2)
            {
                maze.screenData[pos] = 0;
                maze.setscore(maze.getscore()-10);
                Game.getPacman().contapallini++;
                speed++;
            }
            if (DIRECTION == DIRECTION_UP) {
                ypos1 = 1;
                xpos1=0;
            }
            if (DIRECTION == DIRECTION_DOWN) {
                ypos1 = -1;
                xpos1=0;
            }
            if (DIRECTION == DIRECTION_LEFT) {
                xpos1 = -1;
                ypos1=0;
            }
            if (DIRECTION == DIRECTION_RIGHT) {
                xpos1 = 1;
                ypos1=0;
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



    @Override
    public void actionPerformed(ActionEvent e) {
        if (!cont) {
            random = new Random();
            DIRECTION = random.nextInt(4);

        } else {
            cont = false;
        }
    }
}
