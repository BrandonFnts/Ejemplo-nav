package mx.com.pixir.ejemplo.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import mx.com.pixir.ejemplo.presentation.screens.home.HomeScreen
import mx.com.pixir.ejemplo.presentation.screens.menu.MenuScreen
import mx.com.pixir.ejemplo.presentation.screens.menu2.Menu2Screen

fun NavGraphBuilder.drawerNavGraph(navController: NavHostController) {
    navigation(startDestination = DrawerRoutes.Menu1.route, route = Graph.DRAWER) {
        composable(route = DrawerRoutes.Menu1.route) {
            MenuScreen(navController = navController)
        }

        composable(route = DrawerRoutes.Menu2.route) {
            Menu2Screen(navController = navController)
        }
    }
}

sealed class DrawerRoutes(
    val icon: ImageVector,
    val desc: String,
    val title: String,
    val route: String
) {
    data object Menu1 : DrawerRoutes(
        icon = Icons.Rounded.Person,
        desc = "profile icon",
        title = "Menu 1",
        route = "profile"
    )

    data object Menu2 : DrawerRoutes(
        icon = Icons.Rounded.Info,
        desc = "info icon",
        title = "Menu 2",
        route = "about"
    )
}