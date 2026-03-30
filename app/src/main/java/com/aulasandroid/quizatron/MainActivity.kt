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

                    var mainActivityViewModel = MainActivityViewModel()
                    var telaInicialViewModel = TelaInicialViewModel()

                    val pontos by mainActivityViewModel.pontos.observeAsState(initial = 0)

                    val nome by telaInicialViewModel.nome.observeAsState(initial = "")

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
                    )
                    {
                        composable( route = "tela-inicial/{nome}",
                                arguments = listOf(
                                navArgument(nome) {
                                    type = NavType.StringType
                                }
                                )
                        ){
                            telaInicialScreen(
                                navController = navController,
                                resete = {mainActivityViewModel.resetarPontos()}
                            )
                        }
                        composable( route = "pergunta-um/{nome}"){
                            perguntaUmScreen(
                                navController = navController,
                                acerto = {mainActivityViewModel.incrementarPontos()}
                                )
                        }
                        composable( route = "pergunta-dois/{nome}"){
                            perguntaDoisScreen(
                                navController = navController,
                                acerto = {mainActivityViewModel.incrementarPontos()}
                            )
                        }
                        composable( route = "pergunta-tres/{nome}"){
                            perguntaTresScreen(
                                navController = navController,
                                acerto = {mainActivityViewModel.incrementarPontos()}
                            )
                        }
                        composable(route = "tela-final/{nome}") {
                            telaFinalScreen(
                                navController = navController,
                                pontos = pontos,
                                resete = { mainActivityViewModel.resetarPontos()}
                            )
                        }


                    }

                }
            }
        }
    }
}