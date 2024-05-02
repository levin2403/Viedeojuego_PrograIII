/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import Funcionamiento.Juego;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Laboratorios
 */
public class Fondo {
    Juego cocina;
    
    int anchoFondo=1000;
    int altoFondo=856;
    
    static int x1=1000;
    static int y1=0;
    int x2=0;
    int y2=0;
    
    public Fondo(Juego cocina){
        this.cocina=cocina;
    }
    public void paint(Graphics2D g){
        ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/Multimedia/fondo2.png"));
        g.drawImage(imagenFondo.getImage(),x1,y1,anchoFondo,altoFondo,null);
        g.drawImage(imagenFondo.getImage(),x2,y2,anchoFondo,altoFondo,null);
    }
    
    
}
