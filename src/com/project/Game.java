package com.project;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public sound Sound;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    final private Blinky blinky;
    final private Inky inky;
    final private Clyde clyde;
    final private Pinky pinky;
    private boolean running = false;
    final private Maze maze;
    private static Pacman pacman;
    final private Utente utente;
    public String username;
    public int punteggio;
    public int ID;
    private final Bee bee;

    final private Keyboard_Input KI;
    final private Menu menu;

    public enum STATE {
        Menu,
        Game,
        Score
    }



    public STATE gameState = STATE.Menu;
    public Game() {
        Sound= new sound();
        KI = new Keyboard_Input();
        this.addKeyListener(KI);
        maze = new Maze();
        utente = new Utente(username,punteggio,ID);
        pinky = new Pinky();
        blinky = new Blinky();
        inky = new Inky();
        clyde= new Clyde();
        bee = new Bee();
        menu = new Menu(this);
        this.addMouseListener(menu);
        pacman = new Pacman(this,KI);
        new Window(WIDTH, HEIGHT, "PAC-MAN", this);
        maze.initLevel();
    }

    public synchronized void start()
    {
        if(thread==null) {
            thread = new Thread(this);
            thread.start();
            running = true;
        }
    }

    public synchronized void stop()
    {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        final double amountofTicks = 60.0;
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {

         if (gameState == STATE.Game)
        {
            pacman.movePacman(this.maze,this.pinky,this.utente,this.blinky,this.clyde,this.inky,this.bee);
            pacman.updatehitbox();
            bee.movebee(this.maze);
            pinky.moveghost(this.maze);
            pinky.updatehitbox();
            inky.moveghost(this.maze);
            inky.updatehitbox();
            blinky.moveghost(this.maze);
            blinky.updatehitbox();
            clyde.moveghost(this.maze);
            clyde.updatehitbox();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if ( (gameState == STATE.Menu) || gameState == STATE.Score)
        {
            menu.render(g2d);
        }else if (gameState == STATE.Game)
        {
            pacman.drawpacman(g2d);
            maze.drawmaze(g2d);
            maze.drawScore(g2d);
            blinky.DrawGhost(g2d);
            pinky.DrawGhost(g2d);
            clyde.DrawGhost(g2d);
            inky.DrawGhost(g2d);
            bee.DrawBee(g2d);
        }
        g.dispose();
        g2d.dispose();
        bs.show();
    }

    public static Pacman getPacman() {
        return pacman;
    }


}