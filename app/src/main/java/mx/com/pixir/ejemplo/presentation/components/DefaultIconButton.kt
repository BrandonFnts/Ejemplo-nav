package mx.com.pixir.ejemplo.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onPrimary,
    icon: ImageVector,
    description: String,
    isEnabled: Boolean = true,
    click: () -> Unit
) {
    IconButton(onClick = click, modifier = modifier, enabled = isEnabled) {
        DefaultIcon(tint = tint, icon = icon, description = description)
    }
}

@Composable
fun DefaultIconButtonWithText(
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onPrimary,
    icon: ImageVector,
    description: String,
    isEnabled: Boolean = true,
    text: String,
    click: () -> Unit = {}
) {
    IconButton(
        onClick = click,
        modifier = modifier.size(48.dp),
        enabled = isEnabled
    ) {
        DefaultIcon(tint = tint, icon = icon, description = description)
    }
    DefaultText(
        text = text,
        fontSize = 10.sp,
        modifier = modifier
    )
}