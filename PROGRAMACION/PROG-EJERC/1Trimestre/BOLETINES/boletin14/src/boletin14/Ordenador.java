package boletin14;

import partes.Monitor;
import partes.Procesador;
import partes.Teclado;

public class Ordenador {

    private Monitor mo;
    private Teclado te;
    private Procesador pro;
    private float precio;

    public Monitor getMo() {
        return mo;
    }

    public void setMo(Monitor mo) {
        this.mo = mo;
    }

    public Teclado getTe() {
        return te;
    }

    public void setTe(Teclado te) {
        this.te = te;
    }

    public Procesador getPro() {
        return pro;
    }

    public void setPro(Procesador pro) {
        this.pro = pro;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}