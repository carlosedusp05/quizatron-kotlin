package com.aulasandroid.quizatron.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aulasandroid.quizatron.components.alternativa
import com.aulasandroid.quizatron.components.alternativaCerta
import com.aulasandroid.quizatron.components.logoQuiz
import com.aulasandroid.quizatron.components.pergunta
import com.aulasandroid.quizatron.components.tituloPergunta

@Composable
fun perguntaDoisScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .background(Color(250, 107, 225, 255))
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            logoQuiz(modifier = Modifier, size = 75.dp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tituloPergunta(modifier = Modifier, text = "Pergunta 2 de 3")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(375.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(modifier = Modifier
                .fillMaxHeight()
                .width(335.dp)
                .background(Color.White, RoundedCornerShape(15.dp)),
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    pergunta(modifier = Modifier, text = "Qual é a capital da França?")

                    alternativa(modifier = Modifier, text = "Londres", navController,2)
                    alternativa(modifier = Modifier, text = "Madrid", navController,2)
                    alternativa(modifier = Modifier, text = "Roma", navController,2)
                    alternativaCerta(modifier = Modifier, text = "Paris", navController,2)
                }
            }
        }
    }
}