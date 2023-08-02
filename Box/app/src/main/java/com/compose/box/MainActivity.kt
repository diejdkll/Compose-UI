package com.compose.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.box.ui.theme.BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                BoxExample()
            }
        }
    }
}

@Composable
fun BoxExample() {
    Box {

        Box(modifier = Modifier.fillMaxSize().background(Color.Cyan).align(Alignment.Center))

        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "Jetpack", modifier = Modifier.align(Alignment.CenterEnd))
        Text(text = "Compose", modifier = Modifier.align(Alignment.TopStart))

        Box(modifier = Modifier.size(100.dp).background(Color.Red).align(Alignment.Center))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxTheme {
        BoxExample()
    }
}