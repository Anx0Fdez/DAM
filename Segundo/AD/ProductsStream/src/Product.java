public class Product {
    private String codigo;
    private String descripcion;
    private double precio;

    public Product () {
        this.codigo = "";
        this.descripcion = "";
        this.precio = 0.0;
    }

    public Product (String codigo, String descripcion, double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
