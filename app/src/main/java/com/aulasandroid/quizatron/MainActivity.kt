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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aulasandroid.quizatron.screens.TelaInicialViewModel
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

                    val mainActivityViewModel = MainActivityViewModel()
                    val telaInicialViewModel = TelaInicialViewModel()

                    val pontos by mainActivityViewModel.pontos.observeAsState(initial = 0)

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "tela-inicial",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween (50)
                            )
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(50)
                            )
                        }
                    )
                    {
                        composable( route = "tela-inicial"){

                            telaInicialScreen(
                                navController = navController,
                                resete = {mainActivityViewModel.resetarPontos() },
                                viewModel = telaInicialViewModel
                            )
                        }
                        composable( route = "pergunta-um")
                        {
                            perguntaUmScreen(
                                navController = navController,
                                acerto = {mainActivityViewModel.incrementarPontos()}
                                )
                        }
                        composable( route = "pergunta-dois"){
                            perguntaDoisScreen(
                                navController = navController,
                                acerto = {mainActivityViewModel.incrementarPontos()}
                            )
                        }
                        composable( route = "pergunta-tres"){
                            perguntaTresScreen(
                                navController = navController,
                                acerto = {mainActivityViewModel.incrementarPontos()}
                            )
                        }
                        composable(route = "tela-final") {
                            telaFinalScreen(
                                navController = navController,
                                pontos = pontos,
                                resete = { mainActivityViewModel.resetarPontos()},
                                viewModel = telaInicialViewModel
                            )
                        }
                    }

                }
            }
        }
    }
}