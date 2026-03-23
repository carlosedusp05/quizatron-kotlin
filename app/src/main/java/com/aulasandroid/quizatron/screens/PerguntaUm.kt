package com.aulasandroid.quizatron.screens

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aulasandroid.quizatron.components.LogoQuiz
import com.aulasandroid.quizatron.components.TituloPergunta

@Composable
fun PerguntaUmScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(250, 107, 225, 255))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(75.dp)
                .background(Color.Red)
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            LogoQuiz(modifier = modifier, size = 75.dp)
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Red),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TituloPergunta(modifier = Modifier, text = "Pergunta 1 de 3")
        }

    }
}