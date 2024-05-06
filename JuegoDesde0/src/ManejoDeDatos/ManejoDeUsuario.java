/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
            if (usuarioEncontrado == null) {
                throw new UsuarioException("No se encontro un usuario con esas caracteristicas");
            }
            return usuarioEncontrado;
        } catch (Exception e) {
            throw new UsuarioException("No se encontro un usuario con esas caracteristicas" + e.getMessage());
        }

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

    public void cambiarPuntuacionUsuario(String nombreUsuario, int nuevaPuntuacion) throws UsuarioException {
        try {
            File archivoTemporal = new File("TempDatosUsuarios.txt");
            BufferedReader reader = new BufferedReader(new FileReader(BaseDeDatos));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea;
            boolean usuarioEncontrado = false;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(" ");
                String usuarioTemp = partes[1];
                String contrasenaTemp = partes[3];
                int puntuacionActual = Integer.parseInt(partes[5]);

                if (usuarioTemp.equals(nombreUsuario)) {
                    usuarioEncontrado = true;
                    if (nuevaPuntuacion > puntuacionActual) {
                        linea = "Usuario: " + usuarioTemp + " Contraseña: " + contrasenaTemp + " Puntuacion: " + nuevaPuntuacion;
                    }
                }
                writer.write(linea);
                writer.newLine();
            }
            reader.close();
            writer.close();
            

            if (!usuarioEncontrado) {
                throw new UsuarioException("No se encontró ningún usuario con ese nombre");
            }
            
            File archivo = new File(BaseDeDatos);
            BufferedReader reader1 = new BufferedReader(new FileReader(archivoTemporal));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(archivo));
            while ((linea = reader1.readLine()) != null) {
                String[] partes = linea.split(" ");
                String usuarioTemp = partes[1];
                String contrasenaTemp = partes[3];
                int puntuacionActual = Integer.parseInt(partes[5]);

                if (usuarioTemp.equals(nombreUsuario)) {
                    usuarioEncontrado = true;
                    if (nuevaPuntuacion > puntuacionActual) {
                        linea = "Usuario: " + usuarioTemp + " Contraseña: " + contrasenaTemp + " Puntuacion: " + nuevaPuntuacion;
                    }
                }
                writer1.write(linea);
                writer1.newLine();
            }
            reader1.close();
            writer1.close();

            System.out.println("Se cambió la puntuación del usuario correctamente");
        } catch (Exception e) {
            throw new UsuarioException("Error al cambiar la puntuación del usuario: " + e.getMessage());
        }
    }

}
