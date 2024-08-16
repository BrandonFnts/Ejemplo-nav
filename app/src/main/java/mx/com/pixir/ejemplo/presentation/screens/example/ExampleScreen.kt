package mx.com.pixir.ejemplo.presentation.screens.example

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import mx.com.pixir.ejemplo.presentation.screens.example.components.ExampleContent

@Composable
fun ExampleScreen(
    navController: NavHostController,
){
    ExampleContent()
}