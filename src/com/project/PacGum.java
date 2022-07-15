package com.project;

import java.awt.*;
public class PacGum implements Drawpoint{
    @Override
    public void drawpoint(Graphics g2d, Maze maze){
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillOval(maze.getx() + 10, maze.gety() + 10, 6, 6);
    }
}
