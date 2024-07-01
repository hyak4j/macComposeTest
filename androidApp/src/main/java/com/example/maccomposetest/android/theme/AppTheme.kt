package com.example.maccomposetest.android.theme

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // 螢幕是否直立
    val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

    val fontScale = LocalDensity.current.fontScale

    val displayMetrics = LocalContext.current.resources.displayMetrics
    val widthPixels = displayMetrics.widthPixels
    val heightPixels = displayMetrics.heightPixels

    // 設計圖寬度
    val designWidth = 390f
    // 設計圖高度
    val designHeight = 844f

    // 計算Density
    val density = if (isPortrait) {
        widthPixels / designWidth
    } else {
        heightPixels / designWidth
    }

    MaterialTheme(
//        colors = colors,
//        typography = Typography,
//        shapes = Shapes,
        content = {
            CompositionLocalProvider(
                // 螢幕適配調整
                /*
                    dp * density => px
                 */
                values = arrayOf(
                    LocalDensity provides Density(
                        density = density,
                        fontScale = fontScale
                    )
                ),
                content = content
            )
        }
    )
}
