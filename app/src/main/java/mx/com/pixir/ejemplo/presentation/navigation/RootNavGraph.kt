package mx.com.pixir.ejemplo.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.com.pixir.ejemplo.presentation.MainActivity
import mx.com.pixir.ejemplo.presentation.screens.home.HomeScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    activity: MainActivity,
    parentPaddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Graph.HOME,
        route = Graph.ROOT
    ) {
        drawerNavGraph(navController = navController)

        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}