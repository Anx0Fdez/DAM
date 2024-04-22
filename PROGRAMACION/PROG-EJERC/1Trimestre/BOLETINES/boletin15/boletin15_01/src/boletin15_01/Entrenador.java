package boletin15_01;

public class Entrenador extends SeleccionFutbol {

    private String idFederacion;

    public Entrenador() {
    }

    public Entrenador(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    public Entrenador(String idFederacion, int id, String nome, String apelido, int edade) {
        super(id, nome, apelido, edade);
        this.idFederacion = idFederacion;
    }

    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Entrenador{" + "idFederacion=" + idFederacion + '}';
    }

    public void dirixirPartido() {
        System.out.println("Dirixe partido o Entrenador");
    }

    public void dirixirEntrenamento() {
        System.out.println("Dirixe entrenamento o Entrenador");
    }
}
