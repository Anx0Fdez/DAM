
package estructurasrepetitivas;

public class EstDoWhile {
    
    public void amosarDoWhile(){
        
        int i = 0;
        
        do {
            System.out.println("DAM1 ");
            
            i++;
            
            }while (i<7);
            
            System.out.println("");
            System.out.println("Saimos do bucle");
   
    }
    
    public void amosarPositivo(){
        float dato = LerDatos.leerFloatPositivo("Teclea dato positivo: ");
        System.out.println("dato --> " + dato);
        
        
    }
}
