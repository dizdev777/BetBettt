package com.superslots.wingams

import android.view.MotionEvent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun egupt_b(onClick:()->Unit, modifier: Modifier = Modifier, content:@Composable () ->Unit){
    val scale = remember{ Animatable(1f) }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier
        .then(modifier)
        .scale(scale.value)
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    scope.launch {
                        scale.animateTo(0.8f,
                            animationSpec = tween(70))
                    }
                }
                MotionEvent.ACTION_UP -> {
                    scope.launch {
                        scale.animateTo(1f,
                            animationSpec = tween(70),
                            block = {
                                if (scale.value == 1f) {
                                    onClick.invoke()
                                }

                            }
                        )
                    }
                }
                MotionEvent.ACTION_CANCEL ->{
                    scope.launch {
                        scale.animateTo(1f,
                            animationSpec = tween(70)
                        )
                    }
                }
            }
            true
        }, contentAlignment = Alignment.Center
    ){
        content.invoke()
    }

}