import java.util.concurrent.atomic.AtomicInteger;

/**
 * A clase Contador implementa a interface Runnable e utilízase para contar
 * as ocorrencias dunha vogal específica nun texto dado.
 */
class ContadorVogais implements Runnable {
    private final String text;
    private final char vowel;
    private final AtomicInteger totalVowelCount;

    public ContadorVogais(String text, char vowel, AtomicInteger totalVowelCount) {
        this.text = text;
        this.vowel = vowel;
        this.totalVowelCount = totalVowelCount;
    }

    /**
     * Metodo run que se executa cando o fío é iniciado.
     * Conta as ocorrencias da vogal específica no texto e actualiza
     * a variable compartida totalVowelCount.
     */
    @Override
    public void run() {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (c == vowel) {
                count++;
            }
        }
        totalVowelCount.addAndGet(count);
    }
}