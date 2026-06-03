package br.com.rodrigues.entregador.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Green = Color(0xFF18B86B)
val Dark = Color(0xFF111827)
val Muted = Color(0xFF6B7280)
val Soft = Color(0xFFF5F7FA)
val Danger = Color(0xFFE53935)
val Warn = Color(0xFFF59E0B)

private val Scheme = lightColorScheme(
    primary = Green,
    secondary = Dark,
    background = Soft,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Dark,
    onSurface = Dark,
    error = Danger
)

@Composable
fun RodriguesTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = Scheme,
        typography = Typography(),
        content = content
    )
}
