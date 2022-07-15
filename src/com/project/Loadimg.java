package com.project;

import javax.swing.*;
import java.awt.*;
public class Loadimg {
    public Image up,down,right,left,pacman,blinky,clyde,inky,pinky,bee,bee1,bee2,bee3;
    public void  loadimg()
    {
        down = new ImageIcon("src//img//down.gif").getImage();
        up = new ImageIcon("src//img//up.gif").getImage();
        left = new ImageIcon("src//img//left.gif").getImage();
        right = new ImageIcon("src//img//right.gif").getImage();
        pacman = new ImageIcon("src//img//pacman.png").getImage();
        blinky = new ImageIcon("src//img//blinky.gif").getImage();
        clyde = new ImageIcon("src//img//clyde.gif").getImage();
        inky = new ImageIcon("src//img//inky.gif").getImage();
        pinky = new ImageIcon("src//img//pinky.gif").getImage();
        bee = new ImageIcon("src//img//bee.gif").getImage();
        bee1= new ImageIcon("src//img//bee2.gif").getImage();
        bee2= new ImageIcon("src//img//bee3.gif").getImage();
        bee3= new ImageIcon("src//img//bee4.gif").getImage();
    }
}
