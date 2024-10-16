package boletin15_01;

public class SeleccionFutbol {

    private int id;
    private String nome;
    private String apelido;
    private int edade;

    public SeleccionFutbol() {
    }

    public SeleccionFutbol(int id, String nome, String apelido, int edade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.edade = edade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getEdade() {
        return edade;
    }

    public void setEdade(int edade) {
        this.edade = edade;
    }

    @Override
    public String toString() {
        return "SeleccionFutbol{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", edade=" + edade + '}';
    }

    public void concentrarse() {
        System.out.println("Concéntrase a Selección");
    }
    
    public void viaxar() {
        System.out.println("Viaxa a Selección");
    }
    
}
