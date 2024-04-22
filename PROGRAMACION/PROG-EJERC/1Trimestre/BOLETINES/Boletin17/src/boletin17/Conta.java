package boletin17;

public class Conta {

    private long numeroConta;
    private double saldo;
    private Persoa cliente;

    public Conta(long numeroConta, Persoa c) {
        this.numeroConta = numeroConta;
        this.cliente = c;
    }

    public Conta() {

    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persoa getCliente() {
        return cliente;
    }

    public void setCliente(Persoa cliente) {
        this.cliente = cliente;
    }

    public void ingresar(double ing) {
        saldo += ing;
        System.out.println("Has ingresado " + ing + "€");
    }

    public void retirar (double ret) {
        if (saldo >= ret) {
            saldo -= ret;
            System.out.println("Has retirado " + ret + "€");
        } else {
            System.out.println("Saldo insuficiente para retirar " + ret + "€");
        }
    }

    public void actualizarSaldo() {
    }
}