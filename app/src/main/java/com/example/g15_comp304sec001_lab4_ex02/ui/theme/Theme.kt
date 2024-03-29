package com.example.g15_comp304sec001_lab4_ex02.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0x1800BCD4),
    secondary = Color(0xFF073954),
    tertiary = Color(0x27018786),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0x1800BCD4),
    secondary = Color(0xFF073954),
    tertiary = Color(0x26018786),

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val MyThemeTypography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )
)

val ProgramTitleTextStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    color = Color.Black
)
val CourseNameTextStyle = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    color = Color.Black
)
val DescriptionTextStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    color = Color.Black
)

val CardBackgroundColor = Color.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun G15_COMP304Sec001_Lab4_Ex02Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography
    ) {
        val view = LocalView.current
        // run as part of the composition, but don't produce UI themselves
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.secondary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme // adjust the status
        }

        // content of the app
        content()
    }
}
