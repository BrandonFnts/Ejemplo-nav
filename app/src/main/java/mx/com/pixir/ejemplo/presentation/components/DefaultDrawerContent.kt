package mx.com.pixir.ejemplo.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mx.com.pixir.ejemplo.presentation.navigation.DrawerRoutes
import mx.com.pixir.ejemplo.presentation.navigation.Graph

@Composable
fun DefaultDrawerContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onCloseDrawer: () -> Unit
) {
    val screens: List<DrawerRoutes> = listOf(
        DrawerRoutes.Menu1,
        DrawerRoutes.Menu2,
    )

    Box(
        modifier = modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background)
    ) {

        Column(modifier = modifier.fillMaxSize()) {
            HeaderDrawer(modifier = Modifier.fillMaxWidth())

            DefaultText(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        end = 24.dp,
                        bottom = 0.dp,
                        start = 24.dp
                    ),
                fontWeight = FontWeight.Bold,
                text = "Menu lateral",
                style = MaterialTheme.typography.titleMedium
            )

            MenuDrawer(
                modifier = Modifier.fillMaxWidth(),
                navController = navController,
                screens = screens,
                onCloseDrawer = { onCloseDrawer() }
            )
        }
    }
}

@Composable
fun HeaderDrawer(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(180.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Column(Modifier.padding(16.dp)) {
            DefaultText(
                modifier = Modifier,
                text = "Aqui puede ir un diseño de imagen o de perfil de usuario",
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun MenuDrawer(
    modifier: Modifier,
    navController: NavHostController,
    screens: List<DrawerRoutes>,
    onCloseDrawer: () -> Unit
) {
    val scrollState: ScrollState = rememberScrollState()

    Box(modifier = modifier.padding(vertical = 16.dp, horizontal = 24.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
        ) {
            screens.forEach { screen ->
                DrawerItem(
                    screen = screen,
                    click = { route ->
                        onCloseDrawer()

                        navController.popBackStack(route = Graph.DRAWER, inclusive = true)

                        navController.navigate(route)
                    }
                )
            }
        }
    }
}

@Composable
fun DrawerItem(screen: DrawerRoutes, click: (String) -> Unit) {
    NavigationDrawerItem(
        label = { Text(text = screen.title) },
        icon = { Icon(imageVector = screen.icon, contentDescription = screen.desc) },
        selected = false,
        onClick = { click(screen.route) },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
}
