package boletin17;

public class CuentaAhorro extends Conta {
    private double interese;
    private long saldoMinimo;

    public CuentaAhorro(long numeroConta, Persoa c, double interese, long saldoMinimo) {
        super(numeroConta, c);
        this.interese = interese;
        this.saldoMinimo = saldoMinimo;
    }

    public CuentaAhorro(double interese, long saldoMinimo) {
        this.interese = interese;
        this.saldoMinimo = saldoMinimo;
    }

    public double getInterese() {
        return interese;
    }

    public void setInterese(double interese) {
        this.interese = interese;
    }

    public long getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(long saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public void actualizarSaldo() {
        if (getSaldo() >= saldoMinimo) {
            setSaldo(getSaldo() * (1 + interese / 100.0));
            System.out.println("El nuevo saldo de tu cuenta ahorro es: " + getSaldo() + "€");
        }
    }

    @Override
    public String toString() {
        return "CuentaAhorro [numeroConta=" + getNumeroConta() + ", saldo=" + saldoMinimo + ", cliente=" +
                getCliente().getNome() + " " + getCliente().getApelidos() + ", interesVariable=" + interese + ", " +
                "saldoMinimo=" + saldoMinimo + "]";
    }
}