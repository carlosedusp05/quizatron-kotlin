package com.aulasandroid.quizatron.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.quizatron.components.buttonAmarelo
import com.aulasandroid.quizatron.components.logoQuiz
import com.aulasandroid.quizatron.components.tituloPergunta

@Composable
fun telaFinalScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color(77, 206, 255, 234)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            tituloPergunta(modifier = Modifier, text = "Bom trabalho!")
            Text(
                text = "Você acertou 1 de 3 perguntas!",
                color = Color.Black,
                fontSize = 20.sp
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            buttonAmarelo(modifier = Modifier, text = "JOGAR NOVAMENTE", navController)
        }
    }
}