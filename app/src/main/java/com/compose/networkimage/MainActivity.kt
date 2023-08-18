package com.compose.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.compose.networkimage.ui.theme.NetworkImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImageTheme {
                CoilExample()
            }
        }
    }
}

@Composable
fun CoilExample() {
    // rememberImagePainter deprecated
//    var painter = rememberImagePainter(data = "https://vegasjoa.com/data/editor/2212/98b5a1f2bee1a48566f56f3ec3d34e8d_1671436759_5528.jpg")
//
//    Image(
//        painter = painter,
//        contentDescription = "엔텔로프 캐년"
//    )

    Column {
        AsyncImage(
            model = "https://vegasjoa.com/data/editor/2212/98b5a1f2bee1a48566f56f3ec3d34e8d_1671436759_5528.jpg",
            contentDescription = "엔텔로프 캐년"
        )
        AsyncImage(
            model = "https://vegasjoa.com/data/editor/2212/98b5a1f2bee1a48566f56f3ec3d34e8d_1671436759_5528.jpg",
            contentDescription = "엔텔로프 캐년"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkImageTheme {
        CoilExample()
    }
}