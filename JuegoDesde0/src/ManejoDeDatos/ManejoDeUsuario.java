/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class ManejoDeUsuario {
    private static String BaseDeDatos="DatosUsuarios.txt";

    public void validarContrasena(String contrasena) throws UsuarioException {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z]).{8,}$" );
        Matcher matcher = pattern.matcher(contrasena);
        if(matcher.matches()==false){
            throw new UsuarioException("La contraseña debe contener almenos 8 caracteres, un número y una mayúscula");
        }
    }
    
    public void guardarNuevoUsuario(Usuario usuario) throws UsuarioException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(BaseDeDatos, true));
            writer.write("Usuario: " + usuario.getUsuario() + " Contraseña: " + usuario.getContrasena() + " Puntuacion: " + 0);
            writer.newLine();
            writer.close();
            System.out.println("Se registró el usuario correctamente");
        } catch (Exception e) {
            throw new UsuarioException("No se pudo guardar el usuario");
        }
    }
    
    public Usuario buscarUsuario(Usuario usuario) throws UsuarioException {
        Usuario usuarioEncontrado = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(BaseDeDatos));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String usuarioTemp = parts[1];
                String contrasenaTemp = parts[3];
                String puntuacionTemp = parts[5];
                if (usuarioTemp.equals(usuario.getUsuario()) && contrasenaTemp.equals(usuario.getContrasena())) {
                    usuarioEncontrado = new Usuario(usuarioTemp, contrasenaTemp, Integer.parseInt(puntuacionTemp));
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
            throw new UsuarioException("No se encontro un usuario con esas caracteristicas"+e.getMessage());
        }
        return usuarioEncontrado;
    }
    public void comprobarUsuarioRegistrado(Usuario usuario) throws UsuarioException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(BaseDeDatos));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if(parts[0].equals("")){
                    break;
                }
                String usuarioTemp = parts[1];
                String usuarioNombre=usuario.getUsuario();
                System.out.println(parts[1]);                
                if (usuarioTemp.equals(usuarioNombre)) {
                    throw new UsuarioException("Ese nombre de usuario ya existe");
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UsuarioException(e.getMessage());
        }
    }

    
}
