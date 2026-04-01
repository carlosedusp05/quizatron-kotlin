package com.aulasandroid.quizatron.screens

import android.R.attr.button
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
import androidx.compose.runtime.livedata.observeAsState
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
fun telaFinalScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    pontos: Int,
    resete: () -> Unit,
    viewModel: TelaInicialViewModel
) {

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
            when (pontos) {
                0 -> tituloPergunta(modifier = Modifier, text = "Mandou mal!", Color.Red)
                1 -> tituloPergunta(modifier = Modifier, text = "Já é um começo!", Color(0xFFE1601D))
                2 -> tituloPergunta(modifier = Modifier, text = "Quase perfeito!", Color.Yellow)
                else -> tituloPergunta(modifier = Modifier, text = "Bom trabalho!", Color(0xFF8ED19F))
            }

            Text(
                text = "${viewModel.nome.observeAsState().value} você acertou $pontos de 3 perguntas!",
                color = Color.Black,
                fontSize = 20.sp
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            buttonAmarelo(modifier = Modifier, text = "JOGAR NOVAMENTE", navController, resete = resete)
        }
    }
}