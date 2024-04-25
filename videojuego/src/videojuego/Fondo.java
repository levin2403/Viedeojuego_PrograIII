/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author delll
 */
public class Fondo {
 Juego juego;
 int anchoFondo=2600;
   int altoFondo=1560;
   static int x1=500;
   static int y1=0;
   
    int x2=0;
   int y2=0;
    public Fondo(Juego juego) {
        this.juego = juego;
    }
    
       public void mover(){
        x1-=2;
        x2-=2;
        if(x1==0 && x2==-anchoFondo){
            x1=anchoFondo;
            x2=0;
        }
    }
    public void paint (Graphics2D g){
        ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/multimedia/fondo.png"));
        g.drawImage(imagenFondo.getImage(), x1, y1,anchoFondo,altoFondo,null);
        g.drawImage(imagenFondo.getImage(), x2, y2,anchoFondo,altoFondo,null);
    }
    
}
