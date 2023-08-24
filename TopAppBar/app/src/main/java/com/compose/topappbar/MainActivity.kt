package com.compose.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                TopAppBarExample("Android")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample(name: String) {
    Column {
        TopAppBar(
            title = { Text(text = "TopAppBar", modifier = Modifier.weight(1f)) },
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )
        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopAppBarTheme {
        TopAppBarExample("Android")
    }
}