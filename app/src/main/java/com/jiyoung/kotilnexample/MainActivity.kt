package com.jiyoung.kotilnexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jiyoung.kotilnexample.explorer.ExplorerRoute
import com.jiyoung.kotilnexample.ui.NewsBackground
import com.jiyoung.kotilnexample.ui.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                NewsBackground {
                    Scaffold { paddingValues ->
                        NavHost(
                            navController = rememberNavController(),
                            startDestination = "main",
                            modifier = Modifier.padding(paddingValues),
                        ) {
                            composable("main") {
                                ExplorerRoute()
                            }
                        }
                    }
                }
            }
        }
    }
}
