
package com.project;


import java.awt.event.*;



public class Keyboard_Input implements KeyListener {
    public int req_dx, req_dy;
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            req_dx = -1;
            req_dy = 0;
        } else if (key == KeyEvent.VK_RIGHT) {
            req_dx = 1;
            req_dy = 0;
        } else if (key == KeyEvent.VK_UP) {
            req_dx = 0;
            req_dy = -1;
        } else if (key == KeyEvent.VK_DOWN) {
            req_dx = 0;
            req_dy = 1;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}
}


