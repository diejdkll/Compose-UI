package com.compose.slotapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.slotapi.ui.theme.SlotAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotAPITheme {
                SlotAPIExample()
            }
        }
    }
}

@Composable
fun SlotAPIExample() {
    var check1 by remember { mutableStateOf(false) }
    var check2 by remember { mutableStateOf(false) }

    Column {
        CheckboxWithSlotAPI(
            checked = check1,
            onCheckedChange = { check1 = !check1 }
        ) {
            Text(
                text = "Text 1",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        CheckboxWithSlotAPI(
            checked = check2,
            onCheckedChange = { check2 = !check2 }
        ) {
            Text(
                text = "Text 2",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun CheckboxWithSlotAPI(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChange()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() }
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlotAPITheme {
        SlotAPIExample()
    }
}