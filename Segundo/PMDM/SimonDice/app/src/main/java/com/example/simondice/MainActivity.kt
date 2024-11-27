package com.example.simondice

import MainViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

/**
 * Actividade principal da aplicación Simon Dice.
 */
class MainActivity : ComponentActivity() {
    // Instancia de MainViewModel creada usando a fábrica MainViewModelFactory
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(RepositorioRexistro())
    }

    /**
     * Metodo chamado cando se crea a actividade.
     * @param savedInstanceState Estado gardado da actividade.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configura a interface de usuario co ViewModel
            interfaceCores(mainViewModel)
        }
    }
}