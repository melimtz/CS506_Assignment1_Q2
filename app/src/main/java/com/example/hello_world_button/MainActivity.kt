package com.example.hello_world_button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hello_world_button.ui.theme.Hello_World_ButtonTheme
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.material3.ElevatedButton
import androidx.compose.ui.graphics.Color



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hello_World_ButtonTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main(){
    var showText by remember {mutableStateOf(false)}

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xAACCCCFF)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MyFirstButton { showText = true }
            if (showText) {
                Greeting(
                    name = "World"
                )
            }
        }
    }
}

@Composable
fun MyFirstButton(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Click me!")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hello_World_ButtonTheme {
        Greeting("Android")
    }
}