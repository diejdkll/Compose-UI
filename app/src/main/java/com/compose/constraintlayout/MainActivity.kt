package com.compose.constraintlayout

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.compose.constraintlayout.ui.theme.ConstraintlayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintlayoutTheme {
                ConstraintlayoutExample()
            }
        }
    }
}

@Composable
fun ConstraintlayoutExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    start.linkTo(parent.start, margin = 10.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(parent.start, margin = 40.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start, margin = 60.dp)
                }
        )

        createVerticalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)
        
        val barrier = createEndBarrier(redBox, yellowBox, magentaBox)

        Text(
            text = "Test",
            modifier = Modifier.constrainAs(text) {
                start.linkTo(barrier)
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintlayoutTheme {
        ConstraintlayoutExample()
    }
}