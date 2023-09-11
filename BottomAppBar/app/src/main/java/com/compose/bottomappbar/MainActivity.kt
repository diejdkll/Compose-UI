package com.compose.bottomappbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.bottomappbar.ui.theme.BottomAppBarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BottomAppBarExample()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var counter by remember {
        mutableStateOf(0)
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            BottomAppBar() {
                Text(text = "hello")
                Button(onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("안녕하세요")
                    }
                }) {
                    Text(text = "인사하기")
                }
                Button(onClick = {
                    counter++
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("$counter")
                    }
                }) {
                    Text(text = "더하기")
                }
                Button(onClick = {
                    counter--
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("$counter")
                    }
                }) {
                    Text(text = "빼기")
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "count : $counter",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomAppBarTheme {
        BottomAppBarExample()
    }
}