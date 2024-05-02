/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frms;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
            try{
                Clip clip=AudioSystem.getClip();
                AudioInputStream inputStream=AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/Sonidos/musicaJuego.wav"));
            clip.open(inputStream);
            
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            }catch(Exception e){
                System.err.println("error al reproducir la musica"+e.getMessage());
            }
        PantallaPrincipal p=new PantallaPrincipal();
    }
}
