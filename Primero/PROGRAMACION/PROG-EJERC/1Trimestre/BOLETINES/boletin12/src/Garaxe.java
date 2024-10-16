import java.util.Scanner;
import java.util.Random;

public class Garaxe {
    Scanner sc = new Scanner(System.in);
    Coche obx = new Coche();

    Random random = new Random();

    public int numC = random.nextInt(0, 6);
    public int horas;
    public float precioHora;
    public float precio;
    public float dineroPagado;
    public float dineroDevuelto;


    public void sitio() {

        if (numC < 5 && numC > 0) {
            System.out.println(">> HAY SITIO EN EL APARCAMIENTO");
        } else {
            System.out.println(">> APARCAMIENTO COMPLETO");
        }
    }

    public void estancia() {
        System.out.println(">> EL PRECIO DEL PARKING ES DE 1,50€ DURANTE LAS PRIMERAS 3 HORAS Y 0.20€ PARA CADA HORA EXTRA");

        System.out.println("");
        System.out.println("INTRODUCE TU MATRÍCULA");
        obx.setMatricula(sc.nextLine());
        System.out.println("INTRODUCE CUANTAS HORAS QUIERES ESTAR EN EL PARKING");
        horas = sc.nextInt();
        System.out.println("INTRODUCE LA MARCA DEL VEHICULO");
        obx.setMarca(sc.nextLine());
        System.out.println("INTRODUCE LA CANTIDAD DE DINERO INTRODUCIDA");
        dineroPagado = sc.nextFloat();


    }

    public void precio() {
        if (horas < 3) {
            precio = horas * 1.5f;
        } else {
            precioHora = horas * 0.20f + 3;
            precio = 1.5f + precioHora;


        }

    }

    public void salida() {
        System.out.println("FACTURA: ");
        System.out.println("MATRICULA COCHE: " + obx.getMatricula());
        System.out.println("TEMPO APARCADO: " + horas);
        System.out.println("PRECIO POR LA ESTANCIA: " + precio);

        dineroDevuelto = dineroPagado - precio;
        System.out.println("CARTOS DEVOLTOS TRAS O PAGO: " + dineroDevuelto);
        System.out.println("");
        System.out.println("GRACIAS POR USAR O NOSO APARCADOIRO :)");

    }

}