package com.example.simondice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Datos do rexistro que contén o número de rexistros.
 * @param rexistro Número de rexistros.
 */
data class RexistroDatos(var rexistro: Int)

/**
 * Repositorio para xestionar o rexistro de datos.
 */
class RepositorioRexistro {
    // MutableStateFlow é un tipo de fluxo que emite un valor e permite modificalo
    private val _rexistro = MutableStateFlow(RexistroDatos(0))

    // Exponse o fluxo de datos
    val rexistro: Flow<RexistroDatos> get() = _rexistro

    /**
     * Incrementa o rexistro.
     */
    fun incrementarRexistro() {
        _rexistro.value = RexistroDatos(_rexistro.value.rexistro + 1)
    }
}