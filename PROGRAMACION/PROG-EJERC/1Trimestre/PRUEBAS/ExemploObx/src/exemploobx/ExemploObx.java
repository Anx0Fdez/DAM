
package exemploobx;

public class ExemploObx {

    public static void main (String[] args) {
         Rectangulo obxRec = new Rectangulo ( );
         obxRec.darValorBase(5f);
         float va = obxRec.devolverValorBase();
            System.out.println("base= " + va);
            obxRec.darValorAltura(10f);
            System.out.println("altura = " + obxRec.devolverValorAltura());
            obxRec.calcularArea(6f, 7f);
         float r = obxRec.calcularPerimetro(6, 7);
            System.out.println("perimetro = " + r);
            
            //instanciamos un rectangulo co constructor parametrizado
            Rectangulo obxR = new Rectangulo (12, 6) ;
            System.out.println("base = " + obxR.devolverValorAltura());
            
    }
    
}
