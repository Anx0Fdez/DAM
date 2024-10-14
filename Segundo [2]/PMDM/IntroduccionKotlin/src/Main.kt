fun main() {
    val numeros = (1..10).toList()

    println("Números pares:")
    for (numero in numeros) {
        if (numero % 2 == 0) {
            println(numero)
        }
    }
}
+