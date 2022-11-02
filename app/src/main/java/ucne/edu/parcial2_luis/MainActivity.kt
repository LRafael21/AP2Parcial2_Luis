package ucne.edu.parcial2_luis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
//import ucne.edu.apiarticulosap2.ui.Navigation.Navegacion
import ucne.edu.parcial2_luis.ui.theme.Parcial2_LuisTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2_LuisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    AsyncImage(
                        model = "https://example.com/image.jpg",
                        contentDescription = null
                    )
                }
            }
        }
    }
}
/*implementation("io.coil-kt:coil-compose:2.2.2")

AsyncImage(
model = "https://example.com/image.jpg",
contentDescription = null
)*/

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial2_LuisTheme {
        Greeting("Android")
    }
}
