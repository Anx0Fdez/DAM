package boletin17;

public class CuentaCorriente extends Conta {
    private final double INTERESE = 1.5;

    public CuentaCorriente(long numeroConta, Persoa c) {
        super(numeroConta, c);
    }

    public CuentaCorriente() {
    }

    @Override
    public void actualizarSaldo() {
        setSaldo(getSaldo() * (1 + INTERESE / 100));
        System.out.println("El nuevo saldo de tu cuenta corriente es: " + getSaldo() + "€");
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "INTERESE=" + INTERESE +
                '}';
    }
}