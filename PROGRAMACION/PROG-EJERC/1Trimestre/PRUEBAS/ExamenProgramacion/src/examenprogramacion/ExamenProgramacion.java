package examenprogramacion;

/**
 *
 * @author Anxo
 */
public class ExamenProgramacion{

    public static void main(String[] args) {
        Coche coche1 = new Coche("Citroen C4", 7000);
        FeriaCoches feira = new FeriaCoches();
        feira.c = coche1;
        feira.amosar();
        feira.baixarPrezo(15);
        feira.amosar();
    }
}