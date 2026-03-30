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
fun perguntaTresScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    acerto: () -> Unit
) {
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
            tituloPergunta(modifier = Modifier, text = "Pergunta 3 de 3", Color(0xFF8ED19F))
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
                    pergunta(modifier = Modifier, text = "Qual o nome do segundo dia da semana, em inglês?")

                    alternativa(modifier = Modifier, text = "Friday", navController,0)
                    alternativaCerta(modifier = Modifier, text = "Monday", navController,0, acerto = acerto)
                    alternativa(modifier = Modifier, text = "Sunday", navController,0)
                    alternativa(modifier = Modifier, text = "Thursday", navController,0)
                }
            }
        }
    }
}