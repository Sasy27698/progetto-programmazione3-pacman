package com.project;

import java.awt.*;
public class SuperPacGum implements Drawpoint {
    @Override
    public void drawpoint(Graphics g2d, Maze maze){
        g2d.setColor(new Color(255, 183, 174));
        g2d.fillOval(maze.getx() + 8, maze.gety() + 8, 10, 10);
    }
}
