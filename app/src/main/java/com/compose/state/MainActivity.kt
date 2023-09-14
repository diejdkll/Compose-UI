package com.compose.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StateExample()
                }
            }
        }
    }
}

@Composable
fun StateExample() {
    var pyeong by remember {
        mutableStateOf("23")
    }
    var squaremeter by remember {
        mutableStateOf((23 * 3.306).toString())
    }

    PyeongToSquareMeterStateless(
        pyeong = pyeong,
        squaremeter = squaremeter,
        onPyeongChange = {
            if (it.isBlank()) {
                pyeong = ""
                squaremeter = ""
                return@PyeongToSquareMeterStateless
            }
            val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
            pyeong = it
            val sqm = numericValue * 3.306
            squaremeter = sqm.toString()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squaremeter: String,
    onPyeongChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squaremeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateTheme {
        StateExample()
    }
}