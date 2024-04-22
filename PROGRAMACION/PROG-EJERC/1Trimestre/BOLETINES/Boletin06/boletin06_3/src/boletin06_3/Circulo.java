
package boletin06_3;

/**
 *
 * @author AnxoFdez
 */

public class Circulo {
    
    double radio;
    private final double pi = 3.14;
    public Circulo () {
    }
    
    public Circulo (double rad) {
        radio = rad;
    }
    
    public void setRadio(double rad){
        radio = rad;
    }
    public double getRadio(){
        return radio;
    }
    
    public double calcularArea(){
        return pi*Math.pow(radio, 2);
    }
    
    public double calcularLonxitude(){
        return 2*pi*radio;
    }
    
}
