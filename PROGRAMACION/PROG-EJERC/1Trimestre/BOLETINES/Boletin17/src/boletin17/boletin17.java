package boletin17;

/**
 *
 * @author Anxo
 */
public class boletin17 {
    public static void main(String[] args) {
        Persoa cliente1 = new Persoa("Juan", "Perez", "12345678A");
        Persoa cliente2 = new Persoa("Maria", "Gomez", "87654321B");

        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(1111, cliente1);
        CuentaAhorro cuentaAhorro1 = new CuentaAhorro(2222, cliente2, 2, 1000);

        cuentaCorriente1.ingresar(500.0);
        cuentaAhorro1.ingresar(1000.0);

        cuentaCorriente1.actualizarSaldo();

        cuentaCorriente1.retirar(200.0);
        cuentaAhorro1.retirar(500.0);

        cuentaAhorro1.actualizarSaldo();
    }
}