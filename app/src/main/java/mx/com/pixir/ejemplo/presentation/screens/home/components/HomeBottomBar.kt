package mx.com.pixir.ejemplo.presentation.screens.home.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.wear.compose.material.ContentAlpha
import mx.com.pixir.ejemplo.presentation.components.DefaultIcon
import mx.com.pixir.ejemplo.presentation.components.DefaultText
import mx.com.pixir.ejemplo.presentation.navigation.ExampleRoutes

@Composable
fun HomeBottomBar(navController: NavHostController, screens: List<ExampleRoutes>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination ?: return
    val bottomBarDestination = screens.any { it.route == currentDestination.route }

    val backgroundColor: Color = MaterialTheme.colorScheme.background

    if (bottomBarDestination) {

        NavigationBar(
            containerColor = backgroundColor
        ) {

            screens.forEach { screen ->

                AddItemToBottomBar(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItemToBottomBar(
    screen: ExampleRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {

            navController.navigate(route = screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }

        },
        icon = {

            DefaultIcon(
                icon = screen.icon,
                description = "${screen.route} navigation icon",
            )

        },
        label = {

            DefaultText(text = screen.title)

        },
        colors = NavigationBarItemColors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
            selectedIndicatorColor = MaterialTheme.colorScheme.onBackground,
            unselectedIconColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
            unselectedTextColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
            disabledIconColor = Color.LightGray,
            disabledTextColor = Color.LightGray,
        )
    )
}