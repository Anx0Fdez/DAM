// Datos.kt
package com.example.mvvm_basic

object Datos {
    // Genera un número aleatorio dentro de un rango específico
    fun getRandomNumberInRange(start: Int, end: Int): Int {
        return (start..end).random()
    }
}
