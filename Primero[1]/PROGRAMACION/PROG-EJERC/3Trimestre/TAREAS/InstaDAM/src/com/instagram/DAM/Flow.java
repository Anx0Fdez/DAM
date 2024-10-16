package com.instagram.DAM;

import javax.swing.*;

public class Flow {
    private int a;
    private int b;

    Usuarios us = new Usuarios();
    Publicaciones pu = new Publicaciones();

    public void selector() {
        do {
            a = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Iniciar Sesión \n2. Resgistrarse\n3. Ver Publicaciones\n4. SALIR"));

            switch (a) {
                case 1:
                    String usu = JOptionPane.showInputDialog(null, "Usuario: ");
                    String cont = JOptionPane.showInputDialog(null, "Contraseña: ");
                    us.iniciarSesion(usu, cont);
                    break;
                case 2:
                    String newUsu = JOptionPane.showInputDialog(null, "Usuario: ");
                    String newCont = JOptionPane.showInputDialog(null, "Contraseña: ");
                    us.resgistrarUsuario(newUsu, newCont);
                break;
                case 3:
                    pu.verPublicaciones();
                    break;
            }
            if (us.loginInterrogacion()) {
                do {
                    sesionIniciada();
                } while (us.loginInterrogacion());
            }
        } while (a != 4);
    }

    public void sesionIniciada() {
        do {
            b = Integer.parseInt(JOptionPane.showInputDialog(null, "\n1. Crear Publicación\n2. Ver Publicaciones\n3. ATRÁS"));

            switch (b) {
                case 1:
                    String publi = JOptionPane.showInputDialog(null, "Escribe: ");
                    pu.crearPublicacion(publi);
                case 2:
                    pu.verPublicaciones();
                    break;
            }
        } while (b != 3);
    }
}
