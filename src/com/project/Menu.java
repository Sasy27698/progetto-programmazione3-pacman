package com.project;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Menu extends MouseAdapter{
    final private Game game;
    private proxy Proxy;
    private boolean vedi = false;
    private int pos;

    public Menu(Game game) {
        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == Game.STATE.Menu) {
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;
            }
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Score;
            }
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }
            if (game.gameState == Game.STATE.Score) {
                if (mouseOver(mx, my, 210, 350, 200, 64)) {
                    game.gameState = Game.STATE.Menu;
                }
            }
        }
    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

    public void render(Graphics g) {
       if (vedi && game.gameState == Game.STATE.Score) {
           vedi();
        }

        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("PAC-MAN", 195, 70);

            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Gioca", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Score", 270, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Esci", 270, 390);
            vedi = true;
        } else if (game.gameState == Game.STATE.Score) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("HIGH-SCORE", 160, 70);
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
            pos=0;
            for(int i=0;i<Proxy.string.length;i++){
                pos+=40;
                g.drawString(Proxy.string[i],220,110+pos);
            }
        }
    }
    public void vedi(){
        Proxy=new proxy();
            Proxy.Vedi();
            vedi =false;
    }
}
