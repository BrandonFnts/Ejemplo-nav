package mx.com.pixir.ejemplo.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import mx.com.pixir.ejemplo.presentation.components.DefaultDrawerContent
import mx.com.pixir.ejemplo.presentation.navigation.ExampleNavGraph
import mx.com.pixir.ejemplo.presentation.navigation.ExampleRoutes
import mx.com.pixir.ejemplo.presentation.screens.home.components.HomeBottomBar
import mx.com.pixir.ejemplo.presentation.screens.home.components.HomeTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val screens = listOf(ExampleRoutes.Home, ExampleRoutes.Search)
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DefaultDrawerContent(
                navController = navController,
                onCloseDrawer = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            )
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                HomeTopBar(
                    navController = navController,
                    screens = screens,
                    coroutineScope = coroutineScope,
                    drawerState = drawerState,
                )
            },
            content = { paddingValues ->
                ExampleNavGraph(navController = navController, parentPaddingValues = paddingValues)
            },
            bottomBar = {
                HomeBottomBar(navController = navController, screens = screens)
            }
        )
    }
}
