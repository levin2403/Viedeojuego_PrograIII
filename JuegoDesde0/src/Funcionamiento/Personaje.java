/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import Funcionamiento.Juego;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

/**
 *
 * @author Laboratorios
 */
public class Personaje {
    Juego cocina;
    
    
    
    int anchoPersonaje =100;
    int altoPersonaje =100;
    
    static int x_inicial=20;
    static int y_inicial=700;
    
    int x_auxiliar=0;
    int y_auxiliar=0;
    
    Image[] walkingImages;
    private long lastImageChangeTime;
    private static final long IMAGE_CHANGE_INTERVAL = 100; 
    
    int currentWalkingImageIndex = 0;
    public Personaje(Juego cocina){
        this.cocina=cocina;
        walkingImages = new Image[3]; 
        lastImageChangeTime = System.currentTimeMillis();
        for (int i = 0; i < walkingImages.length; i++) {
            walkingImages[i] = new ImageIcon(getClass().getResource("/Multimedia/caminando_" + i + ".png")).getImage();
        }
    }
    
    public void mover() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastImageChangeTime >= IMAGE_CHANGE_INTERVAL) {
            lastImageChangeTime = currentTime;

            if (x_auxiliar != 0) {
                currentWalkingImageIndex++;
                if (currentWalkingImageIndex >= walkingImages.length) {
                    currentWalkingImageIndex = 0;
                }
            } else {
                currentWalkingImageIndex = 0;
            }
        }
        int limiteIzquierdo = 0;
        int limiteDerecho = 900; 
        x_inicial += x_auxiliar;
        if (x_inicial < limiteIzquierdo) {
            x_inicial = limiteIzquierdo;
        } else if (x_inicial > limiteDerecho) {
            x_inicial = limiteDerecho;
        }
    }
    
    public void paint(Graphics2D g) {
        if (x_auxiliar != 0) {
            Image currentImage = walkingImages[currentWalkingImageIndex];
            if (x_auxiliar < 0) {
                g.drawImage(currentImage, x_inicial + anchoPersonaje, y_inicial, -anchoPersonaje, altoPersonaje, null);
            } else {
                g.drawImage(currentImage, x_inicial, y_inicial, anchoPersonaje, altoPersonaje, null);
            }
        } else {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Multimedia/quieto.png"));
            g.drawImage(personaje.getImage(), x_inicial, y_inicial, anchoPersonaje, altoPersonaje, null);
        }
    }
    
    public void keyPressed(KeyEvent ke) {
         if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            x_auxiliar = -5;
        } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            x_auxiliar = 5; 
        }
    }

    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            x_auxiliar = 0;
        }
    }

    public int getX_inicial() {
        return x_inicial;
    }

    public int getY_inicial() {
        return y_inicial;
    }

    
    
    
    
}
