/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frms;

import Funcionamiento.HiloEjecucion;
import Funcionamiento.Juego;
import ManejoDeDatos.Usuario;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DatosUsuario extends javax.swing.JFrame {
    Usuario usuario;
    /**
     * Creates new form DatosUsuario
     */
    public DatosUsuario(Usuario usuario) {
        initComponents();
        this.usuario=usuario;
        this.usuarioLabel.setText(usuario.getUsuario());
        this.puntuacionLabel.setText(String.valueOf(usuario.getPuntuacion()));
        this.setVisible(true);
        this.setSize(1000,856);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioLabel = new javax.swing.JLabel();
        puntuacionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JugarButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioLabel.setToolTipText("");
        getContentPane().add(usuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 320, 80));

        puntuacionLabel.setToolTipText("");
        getContentPane().add(puntuacionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 320, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/ElChefComelonDatos.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        JugarButton.setText("jButton1");
        JugarButton.setBorderPainted(false);
        JugarButton.setContentAreaFilled(false);
        JugarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(JugarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 790, 160, 40));

        volverButton.setText("jButton1");
        volverButton.setBorderPainted(false);
        volverButton.setContentAreaFilled(false);
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });
        getContentPane().add(volverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 780, 190, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        // TODO add your handling code here:
        InicioSesion inicioSesion=new InicioSesion();
        this.dispose();
    }//GEN-LAST:event_volverButtonActionPerformed

    private void JugarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (usuario != null) {
                JFrame ventana = new JFrame("Cocina");
                Juego cocina = new Juego(usuario);
                ventana.setSize(1000, 856);
                ventana.setLocation(70, 200);
                ventana.add(cocina);
                ventana.setLocationRelativeTo(null);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Thread thread = new Thread(new HiloEjecucion(cocina));
                thread.start();
                this.setVisible(false);
                cocina.addPropertyChangeListener("enabled", event -> {
                    if (!cocina.isEnabled()) {
                        thread.interrupt();
                        ventana.dispose();
                        
                    }
                });

                ventana.setVisible(true);

                
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_JugarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JugarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel puntuacionLabel;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
