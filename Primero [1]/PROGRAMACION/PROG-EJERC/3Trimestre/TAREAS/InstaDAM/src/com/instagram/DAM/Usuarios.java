package com.instagram.DAM;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Usuarios {
    private String nombre;

    public Usuarios() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuarios getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuarios usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public ArrayList<Usuarios> getList() {
        return list;
    }

    public void setList(ArrayList<Usuarios> list) {
        this.list = list;
    }

    private String contrasena;
    private Usuarios usuarioActual;
    ArrayList<Usuarios> list = new ArrayList<>();

    public Usuarios(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public void resgistrarUsuario(String nombre, String contrasena) {
        Usuarios us = new Usuarios(nombre, contrasena);
        list.add(us);
        usuarioActual = us;
    }

    public void iniciarSesion(String nome, String contrasena) {
        for (Usuarios us : list) {
            if (us.getNombre().equals(nome) && us.getContrasena().equals(contrasena)) {
                usuarioActual = us;
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El usuario no está registrado.");
    }

    public boolean loginInterrogacion (){
        return usuarioActual != null;
    }
}
