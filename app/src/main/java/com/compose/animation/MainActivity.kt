package com.compose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.animation.ui.theme.AnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimationExample()
                }
            }
        }
    }
}

@Composable
fun AnimationExample() {
    var helloWorldVisible by remember {
        mutableStateOf(true)
    }
    var isDarkMode by remember {
        mutableStateOf(false)
    }

    val transition = updateTransition(targetState = isDarkMode, label = "다크 모드 트랜지션")

    val backgroundColor by transition.animateColor(label = "다크 모드 배경색상 애니메이션") { state ->
        when(state) {
            false -> Color.White
            true -> Color.Black
        }
    }

    val color by transition.animateColor(label = "다크 모드 글자색상 애니메이션") { state ->
        when(state) {
            false -> Color.Black
            true -> Color.White
        }
    }

    val alpha by transition.animateFloat(label = "다크 모드 알파 애니메이션") { state ->
        when(state) {
            false -> 0.7f
            true -> 1f
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = expandHorizontally() + fadeIn(),
            exit = slideOutHorizontally()
        ) {
            Text(
                text = "Hello World!",
                color = color
            )
        }

        RadioButtonWithText(
            text = "Hello World 보이기",
            color = color,
            selected = helloWorldVisible,
        ) {
            helloWorldVisible = true
        }

        RadioButtonWithText(
            text = "Hello World 숨기기",
            color = color,
            selected = !helloWorldVisible,
        ) {
            helloWorldVisible = false
        }

        Text(
            text = "배경 색을 바꾸어봅시다.",
            color = color
        )

        RadioButtonWithText(
            text = "일반 모드",
            color = color,
            selected = !isDarkMode,
        ) {
            isDarkMode = false
        }

        RadioButtonWithText(
            text = "다크 모드",
            color = color,
            selected = isDarkMode,
        ) {
            isDarkMode = true
        }

        Crossfade(targetState = isDarkMode, label = "") { state ->
            when(state) {
                false -> {
                    Row {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)) {
                            Text("1")
                        }
                        Box(modifier = Modifier
                            .background(Color.Magenta)
                            .size(20.dp)) {
                            Text("2")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)) {
                            Text("3")
                        }
                    }
                }
                true -> {
                    Column {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)) {
                            Text("A")
                        }
                        Box(modifier = Modifier
                            .background(Color.Magenta)
                            .size(20.dp)) {
                            Text("B")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)) {
                            Text("C")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimationTheme {
        AnimationExample()
    }
}