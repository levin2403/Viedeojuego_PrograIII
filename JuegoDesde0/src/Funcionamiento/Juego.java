/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Funcionamiento;

import Frms.DatosUsuario;
import ManejoDeDatos.ManejoDeUsuario;
import ManejoDeDatos.Usuario;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorios
 */
public class Juego extends javax.swing.JPanel {
    ManejoDeUsuario manejoDeUsuario=new ManejoDeUsuario();
    //URL direccionSonidoSalto,direccionSonidoChoque;
    //AudioClip sonidoChoque,sonidoSalto;
    
    Personaje personaje=new Personaje(this);
    Fondo fondo=new Fondo(this);
    List<Comida> comidas=new ArrayList<>();
    List<Comida> comidasMalas=new ArrayList<>();
    
    static boolean juegoFinalizado=false;
    static boolean pierdeVida=false;
    static int vidas=3;
    static int puntos=0;
    static int nivel=1;
    private Usuario usuario;
    /**
     * Creates new form Juego
     */
    public Juego(Usuario usuario) {
        this.usuario=usuario;
        this.setSize(1000,856);
        this.setLocation(70,200);
        this.setVisible(true);
        for (int i = 0; i < 5; i++) {
            String comidaNombre="comida"+i;
            comidas.add(new Comida(this, comidaNombre,false));
        }
        for (int i = 0; i < 4; i++) {
            String comidaNombreMala="comidaMala"+i;
            comidas.add(new Comida(this, comidaNombreMala,true));
        }
        
        //direccionSonidoChoque=getClass().getResource("");
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
                //sonidoSalto.play();
                personaje.keyPressed(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                personaje.keyReleased(ke);
            }
            
        });
        setFocusable(true);
    }
    
    public void mover(){
        for (int i = 0; i < comidas.size(); i++) {
            comidas.get(i).mover();
            colisionComida(comidas.get(i));
            if(!comidas.get(i).activo){
            }
        }
        for (int i = 0; i < comidasMalas.size(); i++) {
            comidasMalas.get(i).mover();
            colisionComida(comidasMalas.get(i));
            if(!comidasMalas.get(i).activo){
            }
        }
        personaje.mover();
    }
    
    public void colisionComida(Comida comida) {
        if (personaje.getX_inicial() >= comida.getIzquierda()
                && personaje.getX_inicial() <= comida.getDerecha()
                && personaje.getY_inicial() >= comida.getArriba()
                && personaje.getY_inicial() <= comida.getAbajo()) {
            if (comida.isComidaMala()) {
                vidas--;
                if (vidas == 0) {
                    try {
                        JOptionPane.showMessageDialog(this, "Has perdido");
                        manejoDeUsuario.cambiarPuntuacionUsuario(usuario.getUsuario(), puntos);
                        usuario.setPuntuacion(puntos);
                        this.setEnabled(false);
                        DatosUsuario datosUsuario=new DatosUsuario(manejoDeUsuario.buscarUsuario(usuario));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            } else {
                if (comida.getEspera() > 21) {
                    comida.setEspera(comida.getEspera() - 20);
                }
                puntos++;
                comida.setY_auxiliar(comida.getY_auxiliar() + 1);
            }
            comida.setX_inicial(comida.generadorDePosicion());
            comida.setY_inicial(0);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }
    
    public void dibujar(Graphics2D g){
        fondo.paint(g);
        for (int i = 0; i < comidas.size(); i++) {
            comidas.get(i).paint(g);
        }
        personaje.paint(g);
        
        mover();
    }
    
    public void dibujarPuntaje(Graphics2D g){
        Graphics2D g1=g,g2=g;
        Font score =new Font("Arial",Font.BOLD,30);
        g.setFont(score);
        g.setColor(Color.getHSBColor(180, 93, 17));
        g1.drawString("Puntaje: "+puntos,500 ,30 );
        g1.drawString("Vidas: "+vidas,50,30 );
        g1.drawString("Usuario: "+usuario.getUsuario(),250 ,30 );
        if(juegoFinalizado){
            g2.setColor(Color.yellow);
            g2.drawString("Haz perdido", ((float)getBounds().getCenterX()/2)+170, 70);
        }
    }
    
    public void finJuego(){
        juegoFinalizado=true;
        //sonidoChoque.play();
    }
    
    public void pierde(){
        //sonidoChoque.play();
        pierdeVida=true;
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
