package mx.com.pixir.ejemplo.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.com.pixir.ejemplo.presentation.screens.example.ExampleScreen
import mx.com.pixir.ejemplo.presentation.screens.example2.Example2Screen
import mx.com.pixir.ejemplo.presentation.screens.home.HomeScreen

@Composable
fun ExampleNavGraph(navController: NavHostController, parentPaddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = ExampleRoutes.Home.route,
        route = Graph.EXAMPLE
    ) {
        composable(route = ExampleRoutes.Home.route) {
            ExampleScreen(navController = navController)
        }

        composable(route = ExampleRoutes.Search.route) {
            Example2Screen(navController = navController)
        }

        composable(route = Graph.HOST) {
            HomeScreen()
        }
    }
}

sealed class ExampleRoutes(val icon: ImageVector, val title: String, val route: String) {
    data object Home : ExampleRoutes(
        icon = Icons.Rounded.Home,
        title = "Inicio",
        route = "home"
    )

    data object Search : ExampleRoutes(
        icon = Icons.Rounded.Search,
        title = "Buscar",
        route = "search"
    )

}