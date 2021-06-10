package dev.geanbrandao.br.pokelist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import dev.geanbrandao.br.pokelist.ui.PokeApp
import dev.geanbrandao.br.pokelist.ui.theme.PokeListTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxSize()
                        .onGloballyPositioned { layoutCoordinates: LayoutCoordinates ->
                            Log.d("DEBUG1", layoutCoordinates.size.width.toString())
                        }) {
                    PokeApp()
                }
            }
        }
    }
}

@Preview(name = "Text")
@Composable
fun Greeting(name: String = "teste") {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokeListTheme {
        Greeting("Android")
    }
}