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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, margin = 8.dp)
            end.linkTo(parent.end, margin = 8.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(greenBox) {
            centerTo(parent)
        }

        constrain(yellowBox) {
            start.linkTo(magentaBox.end)
            top.linkTo(magentaBox.bottom)
        }
    }

    ConstraintLayout(
        constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
//                .constrainAs(redBox) {
//                    bottom.linkTo(parent.bottom, margin = 8.dp)
//                    end.linkTo(parent.end, margin = 8.dp)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
//                .constrainAs(magentaBox) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
//                .constrainAs(greenBox) {
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
////                    top.linkTo(parent.top)
////                    bottom.linkTo(parent.bottom)
//                    centerTo(parent)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
//                .constrainAs(yellowBox) {
//                    start.linkTo(magentaBox.end)
//                    top.linkTo(magentaBox.bottom)
//                }
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