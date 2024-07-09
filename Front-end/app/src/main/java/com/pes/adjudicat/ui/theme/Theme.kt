package com.pes.adjudicat.ui.theme

import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.pes.adjudicat.ui.theme.BackGray
import com.pes.adjudicat.ui.theme.Teal

private val DarkColorPalette = darkColors(
    primary = BackGray,
    primaryVariant = BackGray,
    secondary = Teal200,
    background = Color.Black
)

private val LightColorPalette = lightColors(
    primary = BackGray,
    primaryVariant = BlueGray,
    secondary = Teal200,
    background = Color.Black,
    onPrimary = Teal,


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AdjudiCatTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

