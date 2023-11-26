package com.dicoding.mjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.mjetpack.data.HeroesData
import com.dicoding.mjetpack.ui.theme.MJetpackTheme
import com.dicoding.mjetpack.view.DetailApp
import com.dicoding.mjetpack.view.DetailScreen
import com.dicoding.mjetpack.view.MainApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "main") {
                        composable("main") {
                            MainApp()
                        }
                        composable("detail/{heroName}") { backStackEntry ->
                            val heroName = backStackEntry.arguments?.getString("heroName")
                            val food = HeroesData.heroes.firstOrNull { it.name == heroName }
                            if (food != null) {
                                DetailScreen(hero = food, modifier = Modifier.fillMaxWidth(), navController)
                            } else {
                                // Handle if the hero is not found
                            }
                        }
                    }
                }
            }
        }

    }
}
