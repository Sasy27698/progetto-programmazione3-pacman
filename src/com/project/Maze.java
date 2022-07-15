package com.project;

import javax.swing.*;
import java.awt.*;

public class Maze extends JPanel {
    private int x, y;
    private int BLOCK_SIZE = 24;
    private int N_BLOCKS = 16;
    final private int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private int score = 0;
    public final short[] labirinto = {
            0,5,5,5,5,5,5,5,5,5,5,5,5,5,5,0,
            4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,
            4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,
            4,1,1,6,6,1,2,1,1,1,1,6,6,1,1,3,
            4,1,1,6,6,1,1,1,1,1,1,6,6,1,1,3,
            4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,
            4,1,1,1,1,1,1,1,1,1,1,1,2,1,1,3,
            4,1,1,1,6,6,1,1,1,1,6,6,1,1,1,3,
            4,1,1,1,6,6,1,1,1,1,6,6,1,1,1,3,
            4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,
            4,1,1,1,1,1,1,1,1,1,1,1,2,1,1,3,
            4,1,1,6,6,1,1,1,1,1,1,6,6,1,1,3,
            4,1,1,6,6,1,1,1,1,1,1,6,6,1,1,3,
            4,1,1,1,1,2,1,1,1,1,1,1,1,1,1,3,
            4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,
            0,7,7,7,7,7,7,7,7,7,7,7,7,7,7,0
    };
    public short[] screenData;
    public int getx(){return x;}
    public int gety(){return y;}
    public int getblocksize(){return BLOCK_SIZE=24;}
    public int getnblocks(){return N_BLOCKS=16;}
    public void setscore(int score){this.score=score;}
    public int getscore(){return score;}

    public void drawmaze(Graphics g2d) {
        short i = 0;
        Factory factory = new Factory();

        for (y = 0; y < SCREEN_SIZE; y +=BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x +=BLOCK_SIZE) {
                g2d.setColor(new Color(0, 72, 251));
                if(screenData[i]==1)
                {
                    //richiamo del factory
                    Drawpoint pacgum= factory.getShape("PacGum");
                    pacgum.drawpoint(g2d,this);
                }
                if(screenData[i]==2)
                {
                    Drawpoint superpacgum= factory.getShape("SuperPacGum");
                    superpacgum.drawpoint(g2d,this);
                }
                if (screenData[i] == 3) {
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }
                if (screenData[i] == 4){
                    g2d.drawLine(x + BLOCK_SIZE -1, y, x + BLOCK_SIZE -1, y + BLOCK_SIZE - 1);
                }
                if(screenData[i] == 5){
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
                }
                if(screenData[i] == 7){
                    g2d.drawLine(x, y, x + BLOCK_SIZE -1, y);
                }
                if(screenData[i] == 6){
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                    g2d.drawLine(x + BLOCK_SIZE -1, y, x + BLOCK_SIZE -1, y + BLOCK_SIZE - 1);
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
                    g2d.drawLine(x, y, x + BLOCK_SIZE -1, y);
                    g2d.fillRect(x,y,24,24);
                }
                i++;
            }
        }
    }
    public void drawScore(Graphics g2d) {
        g2d.setFont(smallFont);
        g2d.setColor(new Color(5, 151, 79));
        String a = "Score: " + score;
        g2d.drawString(a, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);
    }

    public void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = labirinto[i];
        }
    }

    public Maze() {
        screenData = new short[N_BLOCKS*N_BLOCKS];
    }
}