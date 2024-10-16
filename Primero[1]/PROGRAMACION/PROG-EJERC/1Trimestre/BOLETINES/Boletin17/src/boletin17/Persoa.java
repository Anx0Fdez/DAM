package boletin17;

public class Persoa {
    private String nome;
    private String apelidos;
    private String nif;

    public Persoa(String nome, String apelidos, String nif) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.nif = nif;
    }

    public Persoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Persoa{" +
                "nome='" + nome + '\'' +
                ", apelidos='" + apelidos + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}