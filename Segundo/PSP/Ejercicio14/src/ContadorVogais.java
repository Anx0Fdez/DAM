import java.util.Scanner;

/**
 * A clase ContadorVogais estende a clase Thread para contar as ocorrencias dunha vogal específica nunha frase dada.
 */
public class ContadorVogais extends Thread {
    private String nomeFío; // Nome do fío
    private char vogal; // Vogal a contar
    private String frase; // Frase na que contar a vogal

    /**
     * Constructor da clase ContadorVogais.
     *
     * @param nomeFío Nome do fío
     * @param vogal Vogal a contar
     * @param frase Frase na que contar a vogal
     */
    public ContadorVogais(String nomeFío, char vogal, String frase) {
        this.nomeFío = nomeFío;
        this.vogal = vogal;
        this.frase = frase;
    }

    /**
     * O método run execútase cando se inicia o fío.
     * Conta as ocorrencias da vogal especificada na frase e imprime o resultado.
     */
    @Override
    public void run() {
        int contador = 0; // Contador das ocorrencias da vogal
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);
            if (letra == vogal) {
                contador++;
            }
        }
        System.out.println("O fío " + nomeFío + " contou " + contador + " veces a vogal '" + vogal + "'");
    }
}