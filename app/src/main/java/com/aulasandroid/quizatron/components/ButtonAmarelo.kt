package com.aulasandroid.quizatron.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun buttonAmarelo(modifier: Modifier = Modifier, text: String, navController: NavController) {
    Button(
        onClick = {
            navController.navigate("pergunta-um")
                  },
        modifier = Modifier .width(250.dp) .height(55.dp),
        colors = ButtonDefaults.buttonColors(Color.Yellow),
        border = BorderStroke(1.dp, Color.Black),
        shape = CircleShape
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}