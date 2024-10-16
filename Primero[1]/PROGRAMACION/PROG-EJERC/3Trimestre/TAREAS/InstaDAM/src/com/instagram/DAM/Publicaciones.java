package com.instagram.DAM;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Publicaciones {
    public Publicaciones() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public ArrayList<Publicaciones> getList() {
        return list;
    }

    public void setList(ArrayList<Publicaciones> list) {
        this.list = list;
    }

    private String mensaje;

    ArrayList<Publicaciones> list = new ArrayList<>();

    public Publicaciones(String mensaje) {
        this.mensaje = mensaje;
    }

    public void crearPublicacion(String mensaje) {
        Publicaciones pu = new Publicaciones(mensaje);
        list.add(pu);
    }

    public void verPublicaciones() {
        StringBuilder posts = new StringBuilder();
        for (Publicaciones pu : list) {
            posts.append(pu).append("\n");
        }
        JOptionPane.showMessageDialog(null, posts.toString());
    }
}
