/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Laboratorios
 */
public class Comida {
    Juego cocina;
    boolean comidaMala;
    String nombreComida;
    boolean activo;
    int tiempoEspera=0;
    
    int anchoEnemigo=50;
    int altoEnemigo=50;
    
    int x_inicial;
    int y_inicial=-50;
    
    int arriba=y_inicial-25;
    int abajo=y_inicial+25;
    int izquierda=x_inicial-25;
    int derecha=x_inicial+25;
    static int  espera=200;
    
    static int y_auxiliar=4;
    public Comida(Juego cocina,String nombreComida,boolean comidaMala){
        this.comidaMala=comidaMala;
        Random random = new Random();
        activo= random.nextBoolean();
        if(activo==false){
            tiempoEspera=random.nextInt(10) + 1;
        }
        this.nombreComida= nombreComida;
        this.cocina=cocina;
        x_inicial=generadorDePosicion();
    }
    
    public void mover() {
        Random random = new Random();
        if (activo) {
            if (tiempoEspera > 0) {
                tiempoEspera--;
            } else {
                y_inicial += y_auxiliar;
                if (y_inicial > 846) {
                    y_inicial = -50;
                    x_inicial = generadorDePosicion();
                    tiempoEspera = random.nextInt(espera) + 1;
                }
                this.arriba = y_inicial - 55;
                this.abajo = y_inicial + 25;
                this.izquierda = x_inicial - 25;
                this.derecha = x_inicial + 25;
            }
        } else {
            if (tiempoEspera > 0) {
                tiempoEspera--;
            } else {
                activo = true;
                tiempoEspera = random.nextInt(espera) + 1;
            }
        }
    }
    
    public void paint (Graphics2D g){
        ImageIcon personaje=new ImageIcon(getClass().getResource("/multimediaCocina/"+nombreComida+".png"));
        g.drawImage(personaje.getImage(), x_inicial, y_inicial,anchoEnemigo,altoEnemigo,null);
    }

    public int getX_inicial() {
        return x_inicial;
    }

    public int getY_inicial() {
        return y_inicial;
    }
    
    public int generadorDePosicion() {
        Random random = new Random();
        return random.nextInt(900 - 100 + 1) + 100;
    }

    public void setX_inicial(int x_inicial) {
        this.x_inicial = x_inicial;
    }

    public void setY_inicial(int y_inicial) {
        this.y_inicial = y_inicial;
    }

    public int getArriba() {
        return arriba;
    }

    public int getAbajo() {
        return abajo;
    }

    public int getIzquierda() {
        return izquierda;
    }

    public int getDerecha() {
        return derecha;
    }

    public  int getY_auxiliar() {
        return y_auxiliar;
    }

    public  void setY_auxiliar(int y_auxiliar) {
        Comida.y_auxiliar = y_auxiliar;
    }

    public boolean isComidaMala() {
        return comidaMala;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }

    public int getEspera() {
        return espera;
    }
    
    
    
    
}
