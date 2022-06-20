package com.happy.muze.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.happy.muze.app.screen.ScreenMain
import com.happy.muze.app.theme.EasyHrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()

            SideEffect {
                systemUiController.setSystemBarsColor(
                    Color.Transparent,
                    darkIcons = false
                )
                systemUiController.setNavigationBarColor(
                    color = Color.Black
                )
            }
            EasyHrTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ScreenMain()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    EasyHrTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ScreenMain()
        }
    }
}
