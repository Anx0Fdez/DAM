import java.io.Serializable;

public class Mclase implements Serializable {
    // Atributos da clase
    private String nome;
    private transient int numero1;  // 'transient' para evitar a serialización
    private double numero2;

    // Constructor
    public Mclase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    // Para amosar os atributos do obxecto
    @Override
    public String toString() {
        return "s=" + nome + "; i=" + numero1 + "; d=" + numero2;
    }
}