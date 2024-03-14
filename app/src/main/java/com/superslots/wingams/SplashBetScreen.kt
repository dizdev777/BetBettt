package com.superslots.wingams


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashBetScreen(canWeGo: MutableState<Boolean>, goNext:() -> Unit){
    LaunchedEffect(key1 = canWeGo.value){
        if(canWeGo.value){
            goNext.invoke()
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        val egyptProgress = remember{
            Animatable(0f)
        }
        LaunchedEffect(key1 = Unit, block = {
            egyptProgress.animateTo(1f, tween(durationMillis = 1300, easing = LinearEasing))
            delay(50)
        })
        Image(painter = painterResource(id = R.drawable.splash), contentDescription = "backgorund",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 96.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${(egyptProgress.value*100).toInt()} %", color = Color.White,
                fontFamily = FontFamily(
                Font(R.font.tiltreg)
            ), fontSize = 24.sp)
            LinearProgressIndicator(progress = egyptProgress.value,
                modifier = Modifier
                    .size(170.dp, 16.dp)
                    .clip(
                        RoundedCornerShape(28)
                    ),
                color = Color(0xFFD88C1D), trackColor = Color(0xFF7A5826)
            )
        }


    }
}