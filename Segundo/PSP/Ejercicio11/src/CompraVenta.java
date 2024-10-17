public class CompraVenta extends Thread{
    //Creamos dos hilos, uno para la compra y otro para venta
    private Thread compra;
    private Thread venta;

    //Constructor
    public CompraVenta(){
        compra = new Thread(this, "Compra");
        venta = new Thread(this, "Venta");
    }

    //Metodo run


}
