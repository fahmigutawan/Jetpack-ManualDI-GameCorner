package com.example.manualdigamecorner
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.manualdigamecorner.presentation.devices.DevicesScreen
import com.example.manualdigamecorner.presentation.guide.GuideScreen
import com.example.manualdigamecorner.presentation.mainmenu.MainMenuScreen
import com.example.manualdigamecorner.ui.theme.ManualDIGameCornerTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ManualDIGameCornerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable("main") {
                            MainMenuScreen(
                                onGuideClick = {
                                    navController.navigate("guide")
                                },
                                onDeviceClick = {
                                    navController.navigate("device")
                                }
                            )
                        }
                        composable("guide") {
                            GuideScreen(
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("device") {
                            DevicesScreen(
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}