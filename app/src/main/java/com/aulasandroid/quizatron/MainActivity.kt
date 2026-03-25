package com.aulasandroid.quizatron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aulasandroid.quizatron.screens.perguntaDoisScreen
import com.aulasandroid.quizatron.screens.perguntaTresScreen
import com.aulasandroid.quizatron.screens.perguntaUmScreen
import com.aulasandroid.quizatron.screens.telaFinalScreen
import com.aulasandroid.quizatron.screens.telaInicialScreen
import com.aulasandroid.quizatron.ui.theme.QuizatronTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizatronTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "tela-inicial",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween (750)
                            )
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(750)
                            )
                        }
                    ){
                        composable( route = "tela-inicial"){telaInicialScreen(navController = navController)}
                        composable( route = "pergunta-um"){perguntaUmScreen(navController = navController)}
                        composable( route = "pergunta-dois"){perguntaDoisScreen(navController = navController)}
                        composable( route = "pergunta-tres"){perguntaTresScreen(navController = navController)}
                        composable( route = "tela-final"){telaFinalScreen(navController = navController)}


                    }

                }
            }
        }
    }
}