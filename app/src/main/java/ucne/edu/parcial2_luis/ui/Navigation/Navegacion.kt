package ucne.edu.apiarticulosap2.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ucne.edu.apiarticulosap2.ui.Articulo.List.ArticuloListScreen
import ucne.edu.apiarticulosap2.ui.Articulo.Screen.ArticuloScreen

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.ArticuloListScreen.route
    ) {
        composable(Screen.ArticuloListScreen.route) {
            ArticuloListScreen(
                onClickArticulos = {
                    navController.navigate(
                        Screen.ArticuloScreen.route + "/0"
                    )
                }
            ) {
                navController.navigate(
                    Screen.ArticuloScreen.route + "/$it"
                )
            }
        }
        composable(
            Screen.ArticuloScreen.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            ArticuloScreen(
                id = id,
                onSaveBack = { navController.navigateUp() }
            )
        }
    }
}
