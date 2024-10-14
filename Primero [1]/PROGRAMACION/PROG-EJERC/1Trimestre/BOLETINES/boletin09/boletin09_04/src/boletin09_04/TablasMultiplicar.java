package boletin09_04;

import java.util.Scanner;
public class TablasMultiplicar {
    public void tablas() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime que tabla de multiplicar que necesitas:");
        System.out.println("Si no necesitas ninguna tabla de multiplicar, pulsa [ 0 ] para finalizar.");

        int numT = (int) sc.nextDouble();

        if (numT == 0) {
            System.out.println(" /EXIT/ ");
        } else {
            System.out.println(numT + " * 1 = " + numT * 1);
            System.out.println(numT + " * 2 = " + numT * 2);
            System.out.println(numT + " * 3 = " + numT * 3);
            System.out.println(numT + " * 4 = " + numT * 4);
            System.out.println(numT + " * 5 = " + numT * 5);
            System.out.println(numT + " * 6 = " + numT * 6);
            System.out.println(numT + " * 7 = " + numT * 7);
            System.out.println(numT + " * 8 = " + numT * 8);
            System.out.println(numT + " * 9 = " + numT * 9);
            System.out.println(numT + " * 10 = " + numT * 10);

        }
    }
}
