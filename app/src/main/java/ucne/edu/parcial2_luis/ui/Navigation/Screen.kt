package ucne.edu.apiarticulosap2.ui.Navigation

sealed class Screen(
    val route: String
) {

    object ArticuloScreen : Screen("Articulo")
    object ArticuloListScreen : Screen("ArticuloList")
}