/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import Funcionamiento.Juego;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author USER
 */
public class HiloEjecucion extends Thread {

    private Juego cocina;
    private AtomicBoolean ejecutar = new AtomicBoolean(true);

    public HiloEjecucion(Juego cocina) {
        this.cocina = cocina;
    }
    public void detener() {
        ejecutar.set(false);
    }

    @Override
    public void run() {
        while (ejecutar.get()) { 
            cocina.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
