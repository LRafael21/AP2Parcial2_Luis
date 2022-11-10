package ucne.edu.parcial2_luis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import ucne.edu.parcial2_luis.data.remote.dto.VerbosDTO
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

                    VerbosScreen()
                }
            }
        }
    }
}

@Composable
fun VerbosScreen(viewModel: VerbosViewModel = hiltViewModel()) {

    val uiState = viewModel.uiState.collectAsState()

    LazyColumn{
        items(uiState.value.verbos){
            verbos -> VerbosRow(verbos = verbos)
        }
    }
}


@Composable
fun VerbosRow(verbos: VerbosDTO)
{

    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = "Verbos: " + verbos.Verbo)
        Text(text = "Categoria: " + verbos.Categoria)
        Text(text = "Nivel: " + verbos.Nivel)
        AsyncImage(model = verbos.Imagen, contentDescription = null)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial2_LuisTheme {

    }
}
