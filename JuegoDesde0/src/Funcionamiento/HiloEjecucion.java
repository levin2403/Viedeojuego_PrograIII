/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import Funcionamiento.Juego;

/**
 *
 * @author USER
 */
public class HiloEjecucion extends Thread {
    Juego cocina;

    public HiloEjecucion(Juego cocina) {
        this.cocina = cocina;
    }
    
    
    @Override
    public void run() {
        while (true) {
            cocina.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
