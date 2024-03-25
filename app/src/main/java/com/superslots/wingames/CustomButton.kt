package com.superslots.wingames

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
fun ijfoqihuwrjiuhq7yr8uihijr(onClick:()->Unit, urijqwhurhquwr: Modifier = Modifier, content:@Composable () ->Unit){
    val ijqwhruqwhrwi2 = remember{ Animatable(1f) }
    val ijqwrhqwirjqwrjiw = rememberCoroutineScope()
    Box(modifier = Modifier
        .then(urijqwhurhquwr)
        .scale(ijqwhruqwhrwi2.value)
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    ijqwrhqwirjqwrjiw.launch {
                        ijqwhruqwhrwi2.animateTo(0.8f,
                            animationSpec = tween(70))
                    }
                }
                MotionEvent.ACTION_UP -> {
                    ijqwrhqwirjqwrjiw.launch {
                        ijqwhruqwhrwi2.animateTo(1f,
                            animationSpec = tween(70),
                            block = {
                                if (ijqwhruqwhrwi2.value == 1f) {
                                    onClick.invoke()
                                }

                            }
                        )
                    }
                }
                MotionEvent.ACTION_CANCEL ->{
                    ijqwrhqwirjqwrjiw.launch {
                        ijqwhruqwhrwi2.animateTo(1f,
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