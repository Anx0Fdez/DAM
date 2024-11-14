import java.io.Serializable;

/*
 * Clase proporcionada polo profe [NON MODIFICAR]
 */
public class Platos implements Serializable{
    private String codigop;
    private String nomep;

    public Platos() {
        this("", "");
    }

    public Platos(String codigo, String nome) {
        this.codigop = codigo;
        this.nomep = nome;
    }

    public void setCodigop(String code) {
        this.codigop = code;
    }

    public String getCodigop() {
        return codigop;
    }

    public void setNomep(String nome) {
        this.nomep = nome;
    }

    public String getNomep() {
        return nomep;
    }

    public String toString() {
        return "código prato : " + codigop + "\n" +
                "nome prato  : " + nomep + "\n";
    }
}