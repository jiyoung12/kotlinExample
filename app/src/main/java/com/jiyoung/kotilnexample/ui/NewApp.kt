package com.jiyoung.kotilnexample.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * KotilnExample
 * Class: NewApp
 * Created by jiyoung on 2023/12/11.
 *
 * Description:
 */
@Composable
fun NewsApp() {
    // TODO add navigation setting
}

@Composable
fun NewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

@Composable
fun NewsBackground(modifier: Modifier = Modifier, content: @Composable () -> Unit) =
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize(),
        content = content
    )

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF3F51B5),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC5CAE9),
    onPrimaryContainer = Color(0xFF303F9F),
    inversePrimary = Color(0xFF283593),
    secondary = Color(0xFFFFC107),
    onSecondary = Color(0xFF212121),
    secondaryContainer = Color(0xFFFFE082),
    onSecondaryContainer = Color(0xFFFF6F00),
    tertiary = Color(0xFF4CAF50),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFC8E6C9),
    onTertiaryContainer = Color(0xFF388E3C),
    background = Color.White,
    onBackground = Color(0xFF212121),
    surface = Color.White,
    onSurface = Color(0xFF212121),
    surfaceVariant = Color(0xFFE8EAF6),
    onSurfaceVariant = Color(0xFF1A237E),
    surfaceTint = Color(0xFF3F51B5),
    inverseSurface = Color(0xFF303030),
    inverseOnSurface = Color.White,
    error = Color(0xFFD32F2F),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFFB00020),
    outline = Color(0xFFBDBDBD),
    outlineVariant = Color(0xFFE0E0E0),
    scrim = Color(0xFF000000),
    surfaceBright = Color.White,
    surfaceDim = Color(0xFFF5F5F5),
    surfaceContainer = Color(0xFFE0E0E0),
    surfaceContainerHigh = Color(0xFFBDBDBD),
    surfaceContainerHighest = Color(0xFF9E9E9E),
    surfaceContainerLow = Color(0xFFE0E0E0),
    surfaceContainerLowest = Color(0xFFF5F5F5)
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFC5CAE9),
    onPrimary = Color(0xFF1A237E),
    primaryContainer = Color(0xFF303F9F),
    onPrimaryContainer = Color(0xFFE8EAF6),
    inversePrimary = Color(0xFF3F51B5),
    secondary = Color(0xFFFFE082),
    onSecondary = Color(0xFFFF6F00),
    secondaryContainer = Color(0xFFFFC107),
    onSecondaryContainer = Color(0xFFFF6F00),
    tertiary = Color(0xFFC8E6C9),
    onTertiary = Color(0xFF388E3C),
    tertiaryContainer = Color(0xFF4CAF50),
    onTertiaryContainer = Color(0xFFC8E6C9),
    background = Color(0xFF303030),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF303030),
    onSurface = Color(0xFFE0E0E0),
    surfaceVariant = Color(0xFF424242),
    onSurfaceVariant = Color(0xFFE0E0E0),
    surfaceTint = Color(0xFFC5CAE9),
    inverseSurface = Color(0xFFE8EAF6),
    inverseOnSurface = Color(0xFF1A237E),
    error = Color(0xFFCF6679),
    onError = Color(0xFFB00020),
    errorContainer = Color(0xFFD32F2F),
    onErrorContainer = Color(0xFFFFDAD4),
    outline = Color(0xFFBDBDBD),
    outlineVariant = Color(0xFF424242),
    scrim = Color(0xFF000000),
    surfaceBright = Color.White,
    surfaceDim = Color(0xFF424242),
    surfaceContainer = Color(0xFF333333),
    surfaceContainerHigh = Color(0xFF252525),
    surfaceContainerHighest = Color(0xFF1F1F1F),
    surfaceContainerLow = Color(0xFF424242),
    surfaceContainerLowest = Color(0xFF333333)
)