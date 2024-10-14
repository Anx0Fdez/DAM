import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {
    val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")  // Array de colores disponibles
    val secuenciaJuego = mutableListOf<String>()                // Array que guarda la secuencia del juego

    var nivel = 1  // Empezamos en el nivel 1

    println("¡Bienvenido a Simon Dice!")
    while (true) {
        // Generar un nuevo color para la secuencia
        val nuevoColor = colores[Random.nextInt(colores.size)]
        secuenciaJuego.add(nuevoColor)

        // Mostrar la secuencia al jugador
        println("Nivel $nivel: Simon dice la siguiente secuencia:")
        mostrarSecuencia(secuenciaJuego)

        // Leer la secuencia del usuario
        val secuenciaUsuario = leerSecuenciaUsuario(secuenciaJuego.size)

        // Verificar si la secuencia del usuario es correcta
        if (verificarSecuencia(secuenciaJuego, secuenciaUsuario)) {
            println("¡Correcto! Vamos al siguiente nivel.\n")
            nivel++
        } else {
            println("¡Incorrecto! La secuencia correcta era: ${secuenciaJuego.joinToString(", ")}")
            println("¡Juego terminado! Llegaste al nivel $nivel.")
            exitProcess(0)
        }
    }
}

// Función para mostrar la secuencia de colores
fun mostrarSecuencia(secuencia: List<String>) {
    for (color in secuencia) {
        println(color)
        Thread.sleep(1000)  // Simular una pausa para cada color
    }
    Thread.sleep(500)  // Pausa adicional al final
    println("Ahora repite la secuencia:")
}

// Función para leer la secuencia del usuario
fun leerSecuenciaUsuario(tamano: Int): List<String> {
    val secuenciaUsuario = mutableListOf<String>()

    for (i in 1..tamano) {
        print("Color $i: ")
        val entrada = readLine()?.capitalize() ?: ""
        secuenciaUsuario.add(entrada)
    }

    return secuenciaUsuario
}

// Función para verificar si la secuencia del usuario es correcta
fun verificarSecuencia(secuenciaJuego: List<String>, secuenciaUsuario: List<String>): Boolean {
    return secuenciaJuego == secuenciaUsuario
}
