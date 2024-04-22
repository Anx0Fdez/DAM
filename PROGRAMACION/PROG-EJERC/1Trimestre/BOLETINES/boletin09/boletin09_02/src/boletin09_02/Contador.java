
package boletin09_02;

public class Contador {
    public void SumaProduco(){
    
    int i = 10;
    int suma = 0;
    double produto = 1;
    
   while ( i <= 90) {
    
       suma += i; 
       
       produto *= i;
    
       i++;
}
   
       System.out.println("Suma dos numeros comprendidos entre 10 e o 90 --> " + suma);
       System.out.println("Produto dos numeros comprendidos entre 10 e o 90 --> " + produto);

}
        
}
