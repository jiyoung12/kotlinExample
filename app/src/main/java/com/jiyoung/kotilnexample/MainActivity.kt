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
import com.jiyoung.kotilnexample.explorer.EXPLORER_ROUTE
import com.jiyoung.kotilnexample.explorer.ExplorerRoute
import com.jiyoung.kotilnexample.search.SEARCH_ROUTE
import com.jiyoung.kotilnexample.search.SearchRoute
import com.jiyoung.kotilnexample.search.navigateToSearch
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
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = EXPLORER_ROUTE,
                            modifier = Modifier.padding(paddingValues),
                        ) {
                            composable(EXPLORER_ROUTE) {
                                ExplorerRoute(
                                    moveToSearchScreen = navController::navigateToSearch
                                )
                            }
                            composable(SEARCH_ROUTE) {
                                SearchRoute()
                            }
                        }
                    }
                }
            }
        }
    }
}
