package com.example.simondice

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simondice.ui.theme.SimonDiceTheme

// Clase principal da actividade
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimonDiceTheme {
                SimonGameScreen()
            }
        }
    }
}

// Función composable que define a pantalla do xogo
@Composable
fun SimonGameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Botones()
    }
}

// Función composable que define o botón verde
@Composable
fun BotonVerde() {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
    ) {
    }
}

// Función composable que define o botón vermello
@Composable
fun BotonRojo() {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
    ) {
    }
}

// Función composable que define o botón azul
@Composable
fun BotonAzul() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
    }
}

// Función composable que define o botón amarelo
@Composable
fun BotonAmarillo() {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
    ) {
    }
}

// Función composable que organiza os botóns en filas
@Composable
fun Botones() {
    Column {
        Row {
            BotonVerde()
            BotonRojo()
        }
        Row {
            BotonAzul()
            BotonAmarillo()
        }
    }
}

// Función de previsualización dos botóns
@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBotones() {
    Botones()
}