package br.com.edutech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.edutech.screens.LoginScreen
import br.com.edutech.screens.MainScreen
import br.com.edutech.screens.QuestionScreen
import br.com.edutech.screens.RegisterScreen
import br.com.edutech.ui.theme.EdutechTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF333333)),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "register")
                    {
                        composable(route = "register"){ RegisterScreen(navController) }
                        composable(route = "login"){ LoginScreen(navController) }
                        composable(route = "main"){ MainScreen(navController) }
                        composable(route = "question/{subject}") { navBackStackEntry ->
                            val subject = navBackStackEntry.arguments?.getString("subject", "")
                            QuestionScreen(navController, subject ?: "")
                        }
                    }
                }
            }
        }
    }
}