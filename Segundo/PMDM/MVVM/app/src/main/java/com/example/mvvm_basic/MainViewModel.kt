package com.example.mvvm_basic

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _randomNumber = MutableStateFlow("Aún no generado")
    val randomNumber: StateFlow<String> = _randomNumber

    private var generatedNumber: Int = 0

    fun generateRandomNumber() {
        generatedNumber = Datos.getRandomNumberInRange(1,4)
        _randomNumber.value = "Número generado, adivina cuál es"
    }

    fun checkGuess(buttonId: Int) {
        _randomNumber.value = if (buttonId == generatedNumber) {
            "¡Correcto! El número era $generatedNumber"
        } else {
            "Incorrecto, intenta de nuevo"
        }
    }
}