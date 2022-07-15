package com.project;

import javax.swing.*;
import java.awt.*;



public class Pacman{
    private boolean dead=false,dead1=false,dead2=false,dead3=false;
    private boolean eat=false,eat1=false,eat2=false,eat3=false;
    private boolean finish=false;
    private int pos;
    private  proxy Proxy;
    public int contapallini=0;
   final private Game game;
   final private Keyboard_Input KI;
   private final Rectangle hitbox;

    public Pacman(Game game, Keyboard_Input KI) {
        this.game = game;
        this.KI = KI;
        this.hitbox = new Rectangle(20,20);
    }
    public void updatehitbox(){
        hitbox.x=pacman_x;
        hitbox.y=pacman_y;
    }
    private final int PACMAN_SPEED = 1;
    private int pacman_x=25, pacman_y=25, pacmand_x, pacmand_y;
    public int getpacman_y(){return pacman_y;}
    public int getpacman_x() {
        return pacman_x;
    }

    private Loadimg img;

    public void movePacman(Maze maze,Pinky pinky,Utente utente,Blinky blinky,Clyde clyde,Inky inky,Bee bee){
        short ch;
        if (pacman_x % maze.getblocksize() == 1 && pacman_y % maze.getblocksize() == 1) {
            pos = (pacman_x / maze.getblocksize()) + maze.getnblocks() * (pacman_y / maze.getblocksize());
            ch = maze.screenData[pos];
            if (ch == 1) {
                playmusic(3);
                maze.screenData[pos] = 0;
                maze.setscore(maze.getscore()+10);
                contapallini++;
            }
            if (ch == 2) {
                playmusic(3);
                maze.screenData[pos] = 0;
                maze.setscore(maze.getscore()+25);
                contapallini++;
                pinky.switchFrightenedMode();
                inky.switchFrightenedMode();
                blinky.switchFrightenedMode();
                clyde.switchFrightenedMode();
            }
            if(!finish)
            {
                checkMaze(maze);
            }
            else
            {
                utente.setUsername(JOptionPane.showInputDialog("Hai vinto! Digita il nome"));
                utente.setPunteggio(maze.getscore());
                utente.setID();
                System.out.println("Persona->" + utente.getUsername());
                System.out.println("\nID->" + utente.getID());
                System.out.println("\nPunteggio->" + utente.getPunteggio());
                Add(utente);
                game.gameState = Game.STATE.Menu;
                reset(maze,pinky,blinky,clyde,inky,bee);
                finish = false;
            }
            if (pinky.gettimer()==0){
                dead = true;
                eat=false;
            }
            else
            {
                dead=false;
                eat=true;
            }
            if(blinky.gettimer()==0){
                dead1 = true;
                eat1=false;
            }
            else{
                dead1=false;
                eat1=true;
            }
            if(clyde.gettimer()==0){
                dead2 = true;
                eat2=false;
            }
            else{
                dead2=false;
                eat2=true;
            }
            if(inky.gettimer()==0){
                dead3 = true;
                eat3=false;
            }
            else{
                dead3=false;
                eat3=true;
            }

            if(dead && hitbox.intersects(pinky.getghitbox()) )
            {
                playmusic(1);
                utente.setUsername(JOptionPane.showInputDialog("Game over! Digita il nome"));
                utente.setPunteggio(maze.getscore());
                utente.setID();
                System.out.println("Persona->" + utente.getUsername());
                System.out.println("\nID->" + utente.getID());
                System.out.println("\nPunteggio->" + utente.getPunteggio());
                Add(utente);
                game.gameState = Game.STATE.Menu;
                reset(maze,pinky,blinky,clyde,inky,bee);
                dead=false;
            }
            if(dead1 && hitbox.intersects(blinky.getghitbox()))
            {
                playmusic(1);
                utente.setUsername(JOptionPane.showInputDialog("Game over! Digita il nome"));
                utente.setPunteggio(maze.getscore());
                utente.setID();
                System.out.println("Persona->" + utente.getUsername());
                System.out.println("\nID->" + utente.getID());
                System.out.println("\nPunteggio->" + utente.getPunteggio());
                Add(utente);
                game.gameState = Game.STATE.Menu;
                reset(maze,pinky,blinky,clyde,inky,bee);
                dead1=false;
            }
            if(dead2 && hitbox.intersects(clyde.getghitbox()) )
            {
                playmusic(1);
                utente.setUsername(JOptionPane.showInputDialog("Game over! Digita il nome"));
                utente.setPunteggio(maze.getscore());
                utente.setID();
                System.out.println("Persona->" + utente.getUsername());
                System.out.println("\nID->" + utente.getID());
                System.out.println("\nPunteggio->" + utente.getPunteggio());
                Add(utente);
                game.gameState = Game.STATE.Menu;
                reset(maze,pinky,blinky,clyde,inky,bee);
                dead2=false;
            }
            if(dead3 && hitbox.intersects(inky.getghitbox()))
            {
                playmusic(1);
                utente.setUsername(JOptionPane.showInputDialog("Game over! Digita il nome"));
                utente.setPunteggio(maze.getscore());
                utente.setID();
                System.out.println("Persona->" + utente.getUsername());
                System.out.println("\nID->" + utente.getID());
                System.out.println("\nPunteggio->" + utente.getPunteggio());
                Add(utente);
                game.gameState = Game.STATE.Menu;
                reset(maze,pinky,blinky,clyde,inky,bee);
                dead3=false;
            }
             if(eat && hitbox.intersects(pinky.getghitbox()) && pinky.gettimer()!=0)
            {
                playmusic(2);
                maze.setscore(maze.getscore()+50);
                pinky.switchHouseMode();
                pinky.settimer();
                pinky.setXpos(pinky.gethome()[0]);
                pinky.setYpos(pinky.gethome()[1]);
                eat=false;
            }
             if(eat1 && hitbox.intersects(blinky.getghitbox()) && blinky.gettimer()!=0){
                 playmusic(2);
                 maze.setscore(maze.getscore()+50);
                 blinky.switchHouseMode();
                blinky.settimer();
                blinky.setXpos(blinky.gethome()[2]);
                blinky.setYpos(blinky.gethome()[3]);
                eat1=false;
            }
             if(eat2 && hitbox.intersects(clyde.getghitbox()) && clyde.gettimer()!=0){
                 playmusic(2);
                 maze.setscore(maze.getscore()+50);
                 clyde.switchHouseMode();
                clyde.settimer();
                clyde.setXpos(clyde.gethome()[4]);
                clyde.setYpos(clyde.gethome()[5]);
                eat2=false;
            }
             if(eat3 && hitbox.intersects(inky.getghitbox()) && inky.gettimer()!=0){
                 playmusic(2);
                 maze.setscore(maze.getscore()+50);
                 inky.switchHouseMode();
                inky.settimer();
                inky.setXpos(inky.gethome()[6]);
                inky.setYpos(inky.gethome()[7]);
                eat3=false;
            }

            if (KI.req_dx != 0 || KI.req_dy != 0) {
                pacmand_x = KI.req_dx;
                pacmand_y = KI.req_dy;
            }
            // Collisioni con il muro
            if (pacmand_x == -1 && pacmand_y == 0 && pacman_x==25) {
                pacmand_x = 0;

            }
                   if (pacmand_x == 1 && pacmand_y == 0 && pacman_x==337){
                       pacmand_x=0;
                   }
                    if (pacmand_x == 0 && pacmand_y == -1 && pacman_y==25){
                        pacmand_y=0;
                    }
                     if(pacmand_x == 0 && pacmand_y == 1 && pacman_y==337)
                    {
                        pacmand_y=0;
                    }
            if (pacmand_x == 1 && pacmand_y == 0 && (pacman_x == 49 || pacman_x == 241) && (pacman_y == 73 || pacman_y == 97 || pacman_y == 265 || pacman_y == 289)) {
                pacmand_x = 0;
            }
            if (pacmand_x == -1 && pacmand_y == 0 && (pacman_x == 121 || pacman_x == 313) && (pacman_y == 73 || pacman_y == 97 || pacman_y == 265 || pacman_y == 289)) {
                pacmand_x = 0;
            }
            if(pacmand_x==0 && pacmand_y==1 &&(pacman_y==49|| pacman_y==241)&&(pacman_x==73||pacman_x==97||pacman_x==265||pacman_x==289)){
                pacmand_y=0;
            }
            if(pacmand_x==0 && pacmand_y==-1 &&(pacman_y==121||pacman_y==313)&&(pacman_x==73||pacman_x==97||pacman_x==265||pacman_x==289)){
                pacmand_y=0;
            }
            if (pacmand_x == 1 && pacmand_y == 0 && (pacman_x == 73||pacman_x==217 ) && (pacman_y == 169||pacman_y==193 )) {
                pacmand_x = 0;
            }
            if (pacmand_x == -1 && pacmand_y == 0 && (pacman_x == 145||pacman_x==289 ) && (pacman_y == 169||pacman_y==193 )) {
                pacmand_x = 0;
            }
            if(pacmand_x==0 && pacmand_y==1 &&(pacman_y==145)&&(pacman_x==97||pacman_x==121||pacman_x==241||pacman_x==265)){
                pacmand_y=0;
            }
            if(pacmand_x==0 && pacmand_y==-1 &&(pacman_y==217)&&(pacman_x==97||pacman_x==121||pacman_x==241||pacman_x==265)){
                pacmand_y=0;
            }

        }
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }
    public void reset(Maze maze,Pinky pinky,Blinky blinky,Clyde clyde,Inky inky,Bee bee)
    {
        maze.initLevel();
        maze.setscore(0);
        contapallini=0;
        pacman_x=25;
        pacman_y=25;
        pacmand_x=0;
        pacmand_y=0;
        KI.req_dx=0;
        KI.req_dy=0;
        pinky.settimer();
        pinky.switchHouseMode();
        pinky.setXpos(pinky.gethome()[0]);
        pinky.setYpos(pinky.gethome()[1]);
        blinky.settimer();
        blinky.switchHouseMode();
        blinky.setXpos(blinky.gethome()[2]);
        blinky.setYpos(blinky.gethome()[3]);
        clyde.settimer();
        clyde.switchHouseMode();
        clyde.setXpos(clyde.gethome()[4]);
        clyde.setYpos(clyde.gethome()[5]);
        inky.settimer();
        inky.switchHouseMode();
        inky.setXpos(inky.gethome()[6]);
        inky.setYpos(inky.gethome()[7]);
        bee.setXpos(337);
        bee.setYpos(25);
    }

    public void checkMaze(Maze maze)
    {
        for(int i=0;i<maze.getnblocks() * maze.getnblocks();i++)
        {
            if(contapallini>=172)
            {
                finish=true;
                contapallini=0;
            }
        }
    }
    public void drawpacman(Graphics2D g2d) {
        img = new Loadimg();
        img.loadimg();
        if(pacmand_x==0 && pacmand_y==0){
            g2d.drawImage(img.pacman, pacman_x + 1, pacman_y + 1, null);
        }
         if (KI.req_dx == -1) {
            g2d.drawImage(img.left, pacman_x + 1, pacman_y + 1, null);
        } else  if(KI.req_dx == 1) {
            g2d.drawImage(img.right, pacman_x + 1, pacman_y + 1, null);
        } else if (KI.req_dy == -1 ) {
            g2d.drawImage(img.up, pacman_x + 1, pacman_y + 1, null);
        }else if(KI.req_dy==1) {
            g2d.drawImage(img.down, pacman_x + 1, pacman_y + 1, null);
        }
    }
    public void playmusic(int i){
        game.Sound.setFile(i);
        game.Sound.play();
    }
    public void Add(Utente utente){
        Proxy=new proxy();
            Proxy.insert(utente);
    }
}