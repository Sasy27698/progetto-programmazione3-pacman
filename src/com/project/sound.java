package com.project;

import javax.sound.sampled.*;
import java.net.URL;
public class sound {
    Clip clip;
    URL soundURL[] = new URL[4];

    public sound() {
        soundURL[1] = getClass().getResource("/sound/pacmandie.wav");
        soundURL[2] = getClass().getResource("/sound/pacman_eatghost.wav");
        soundURL[3] = getClass().getResource("/sound/pacman_chomp.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println("impossibile settare l'audio");
        }
    }
    public void play(){
        clip.start();
    }
}
