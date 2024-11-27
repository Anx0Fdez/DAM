package com.example.simondice

import MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Fábrica para crear instancias de MainViewModel.
 * @param repositorio Instancia do repositorio para rexistrar datos.
 */
class MainViewModelFactory(
    private val repositorio: RepositorioRexistro
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Clase de ViewModel descoñecida")
    }
}