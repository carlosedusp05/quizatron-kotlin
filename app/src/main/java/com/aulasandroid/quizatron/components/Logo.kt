package com.aulasandroid.quizatron.components

import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.aulasandroid.quizatron.R

@Composable
fun LogoQuiz(modifier: Modifier = Modifier, size: Dp) {
    Image(
        painter = painterResource(R.drawable.quiz),
        contentDescription = "Logo quiz",
        modifier = modifier .size(size)
    )
}