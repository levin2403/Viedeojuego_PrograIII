/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeDatos;

/**
 *
 * @author USER
 */
public class Usuario {
    private String usuario;
    private String contrasena;
    private int puntuacion;

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puntuacion=0;
    }

    
    public Usuario(String usuario, String contrasena, int puntuacion) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puntuacion = puntuacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", puntuacion=" + puntuacion + '}';
    }
    
    

    
    
}
