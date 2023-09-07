package com.compose.dropdownmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.dropdownmenu.ui.theme.DropDownMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropDownMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropDownMenuExample()
                }
            }
        }
    }
}

@Composable
fun DropDownMenuExample() {
    var expandDropDownMenu by remember{ mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {expandDropDownMenu = true}) {
            Text(text = "DropDownMenu Open")
        }
        Text(text = "count : $counter")
    }

    DropdownMenu(
        expanded = expandDropDownMenu,
        onDismissRequest = {
            expandDropDownMenu = false
        }
    ) {
        DropdownMenuItem(text = { Text(text = "증가") }, onClick = { counter++ })
        DropdownMenuItem(text = { Text(text = "감소") }, onClick = { counter-- })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DropDownMenuTheme {
        DropDownMenuExample()
    }
}