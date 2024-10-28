package com.example.mvvm_basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_basic.ui.theme.MVVM_BasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            MVVM_BasicTheme  {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
