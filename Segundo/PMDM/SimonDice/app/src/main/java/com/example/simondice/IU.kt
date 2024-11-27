package com.example.simondice

import MainViewModel
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simondice.ui.theme.*
import androidx.compose.runtime.collectAsState

/**
 * Composable que representa a interface de cores do xogo.
 * @param viewModel Instancia de MainViewModel.
 * @param modifier Modificador para o Composable.
 */
@Composable
fun interfaceCores(viewModel: MainViewModel = viewModel(), modifier: Modifier = Modifier) {
    val rexistro by viewModel.rexistro.collectAsState()
    val corActual by viewModel.corActual.collectAsState()
    val mensaxeErro by viewModel.mensaxeErro.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Rexistro: ${rexistro.rexistro}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
            Botons(viewModel, corActual)
        }
        mensaxeErro?.let { mensaxe ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                action = {
                    Button(onClick = { viewModel.limparMensaxeErro() }) {
                        Text("Descartar")
                    }
                }
            ) {
                Text(mensaxe)
            }
        }
    }
}

/**
 * Composable que representa os botóns de cores.
 * @param viewModel Instancia de MainViewModel.
 * @param corActual Cor actual mostrada.
 */
@Composable
fun Botons(viewModel: MainViewModel, corActual: Color?) {
    Column {
        Row {
            BotonVerde(viewModel, corActual)
            BotonRosa(viewModel, corActual)
        }
        Row {
            BotonAzul(viewModel, corActual)
            BotonLaranxa(viewModel, corActual)
        }
    }
}

/**
 * Composable que representa o botón verde.
 * @param viewModel Instancia de MainViewModel.
 * @param corActual Cor actual mostrada.
 */
@Composable
fun BotonVerde(viewModel: MainViewModel, corActual: Color?) {
    val corFondo by animateColorAsState(
        targetValue = if (corActual == Green) Color.LightGray else Green
    )
    Button(
        onClick = { viewModel.entradaUsuario(Green) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = corFondo)
    ) {}
}

/**
 * Composable que representa o botón rosa.
 * @param viewModel Instancia de MainViewModel.
 * @param corActual Cor actual mostrada.
 */
@Composable
fun BotonRosa(viewModel: MainViewModel, corActual: Color?) {
    val corFondo by animateColorAsState(
        targetValue = if (corActual == Red) Color.LightGray else Red
    )
    Button(
        onClick = { viewModel.entradaUsuario(Red) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = corFondo)
    ) {}
}

/**
 * Composable que representa o botón azul.
 * @param viewModel Instancia de MainViewModel.
 * @param corActual Cor actual mostrada.
 */
@Composable
fun BotonAzul(viewModel: MainViewModel, corActual: Color?) {
    val corFondo by animateColorAsState(
        targetValue = if (corActual == Blue) Color.LightGray else Blue
    )
    Button(
        onClick = { viewModel.entradaUsuario(Blue) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = corFondo)
    ) {}
}

/**
 * Composable que representa o botón laranxa.
 * @param viewModel Instancia de MainViewModel.
 * @param corActual Cor actual mostrada.
 */
@Composable
fun BotonLaranxa(viewModel: MainViewModel, corActual: Color?) {
    val corFondo by animateColorAsState(
        targetValue = if (corActual == Yellow) Color.LightGray else Yellow
    )
    Button(
        onClick = { viewModel.entradaUsuario(Yellow) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = corFondo)
    ) {}
}