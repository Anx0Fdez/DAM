package com.example.mvvm_basic

import android.util.Log
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

@Composable
fun IU() {
    Boton(Colores.CLASE_AZUL)

}

@Composable
fun Boton(enum_color: Colores) {

    // para que sea mas facil la etiqueta del log
    val TAG_LOG: String = "miDebug"

    Button(
        // utilizamos el color del enum
        colors = ButtonDefaults.buttonColors(enum_color.color),
        onClick = {
            var numero = (0..10).random()
            Log.d(TAG_LOG, "Dentro del onClick $numero")
        },
        modifier = Modifier
            .size((80).dp, (40).dp)
    ) {
        // utilizamos el texto del enum
        Text(text = enum_color.txt, fontSize = 10.sp)
    }
}