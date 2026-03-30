package com.aulasandroid.quizatron.components

import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun alternativaCerta(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavController,
    numeroQuestao: Int = 0,
    acerto: () -> Unit
    ) {

    var corDoBotao by remember {
        mutableStateOf(Color.Transparent)
    }

    val route = when {
        numeroQuestao == 1 -> "pergunta-dois"
        numeroQuestao == 2 -> "pergunta-tres"
        else -> "tela-final"
    }

    OutlinedButton(
        onClick = {
            navController.navigate(route)
            corDoBotao = Color.Green
            acerto()
        },
        border = BorderStroke(1.dp, Color(0xFFA2A2A2)),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = corDoBotao
        ),
        modifier = Modifier
            .width(300.dp)
            .height(55.dp)
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier .fillMaxWidth()
        )
    }
}