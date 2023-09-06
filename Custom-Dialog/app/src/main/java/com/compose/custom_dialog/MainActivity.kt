package com.compose.custom_dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.compose.custom_dialog.ui.theme.CustomDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomDialogExample()
                }
            }
        }
    }
}

@Composable
fun CustomDialogExample() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "Dialog")
        }
        Text(text = "count: $counter")
    }
    
    if (openDialog) {
        Dialog(onDismissRequest = {
            openDialog = false
        }) {
            Surface {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("카운터를 조작해봅시다.")
                    Row(modifier = Modifier.align(Alignment.End)) {
                        Button(onClick = {
                            counter--
                            openDialog = false
                        }) {
                            Text("-1")
                        }
                        Button(onClick = {
                            counter++
                            openDialog = false
                        }) {
                            Text("+1")
                        }
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text("취소")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomDialogTheme {
        CustomDialogExample()
    }
}