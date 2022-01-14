package com.splashscreenapiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.splashscreenapiapp.ui.theme.SplashScreenAPIAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create a SplashScreen instance
        installSplashScreen().apply {
            setKeepVisibleCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            SplashScreenAPIAppTheme {
                displayText()
            }
        }
    }
}

@Composable
private fun displayText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello world")
    }
}