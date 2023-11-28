package com.example.hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2.ui.BeerApp
import com.example.hw2.ui.theme.Hw2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hw2Theme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    var showBeerApp by rememberSaveable { mutableStateOf(false) }

    if (showBeerApp) {
        BeerApp()
    } else {
        Button(onClick = { showBeerApp = true }) {
            Text("Show Beer App")
        }
    }
}


