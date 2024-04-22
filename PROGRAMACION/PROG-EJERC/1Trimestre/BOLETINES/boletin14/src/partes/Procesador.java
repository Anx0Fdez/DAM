
package partes;

public class Procesador {
    private float velocidad;

    public Procesador(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Procesador{" + "velocidad=" + velocidad + '}';
    }
    
    
}