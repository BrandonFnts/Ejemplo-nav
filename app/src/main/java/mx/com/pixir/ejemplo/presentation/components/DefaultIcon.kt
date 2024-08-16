package mx.com.pixir.ejemplo.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DefaultIcon(
    modifier: Modifier = Modifier,
    tint: Color =  MaterialTheme.colorScheme.onPrimary,
    icon: ImageVector,
    description: String,
) {
    Icon(
        imageVector = icon,
        contentDescription = description,
        modifier = modifier,
        tint = tint
    )
}