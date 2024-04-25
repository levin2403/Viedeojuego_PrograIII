/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorios
 */
public class Principal {
    public static void main (String[]args){
        
        JOptionPane.showMessageDialog(null, "¿Estás listo?");
        
        JFrame ventana=new JFrame("Cocina");
        Juego cocina=new Juego();
        ventana.add(cocina);
        ventana.setSize(1000,856);
        ventana.setLocation(70,200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            cocina.repaint();
            try{
                Thread.sleep(10);
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
