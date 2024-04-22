
package exemploobx;

public class Rectangulo {
    private float base;
    private float altura;
    // constructores
    //constructor por defecto
public Rectangulo () {
    
}
    //constructor parametrizado
    public Rectangulo (float ba, float al) {
        base = ba;
        altura = al;
        
    }   
    // metodos de acceso a base
    public void darValorBase (float ba) {
        base=ba;
    }
    public float devolverValorBase () {
        return base;
    }
        // metodos de acceso a altura
    public void darValorAltura (float alt) {
        altura=alt;
    }
    public float devolverValorAltura () {
        return altura;
    }
    public void calcularArea (float ba, float alt){
        float area = ba * alt;
        System.out.println("area = " + area);
    }
    public float calcularPerimetro (float ba, float alt) {
        float peri = 2 * ba + 2 * alt;
        return peri;
        // tamén return ( 2*ba+2*al ) ;
        
    }
}


