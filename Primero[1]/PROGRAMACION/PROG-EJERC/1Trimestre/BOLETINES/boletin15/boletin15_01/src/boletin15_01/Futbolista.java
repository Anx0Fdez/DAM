package boletin15_01;

public class Futbolista extends SeleccionFutbol {

    private int dorsal;
    private String demarcacion;

    public Futbolista() {
    }

    public Futbolista(int dorsal, String demarcacion) {
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public Futbolista(int dorsal, String demarcacion, int id, String nome, String apelido, int edade) {
        super(id, nome, apelido, edade);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Futbolista{" + "dorsal=" + dorsal + ", demarcacion=" + demarcacion + '}';
    }
    
    public void xogarPartido() {
        System.out.println("Xoga partido o Futbolista");
    }
    
    public void entrenar() {
        System.out.println("Entrena o Futbolista");
    }

}
