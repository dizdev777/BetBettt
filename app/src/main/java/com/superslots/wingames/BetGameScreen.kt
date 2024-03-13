package com.superslots.wingames

import android.app.Activity
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.superslots.domain.model.Item
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val sizeSolo = 80
const val lines = 3
const val columns = 5
const val paddingval = 6

@Composable
fun EgyptGameScreen() {

    val fuiqwurwi2 = LocalContext.current as Activity
    fuiqwurwi2.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    val gameImages = remember {
        listOf(
            R.drawable.z1, R.drawable.z2, R.drawable.z3, R.drawable.z4,
            R.drawable.z1, R.drawable.z2, R.drawable.z3, R.drawable.z4,
            R.drawable.z1, R.drawable.z2, R.drawable.z3, R.drawable.z4,
            R.drawable.z5, R.drawable.z6, R.drawable.z7,
            R.drawable.z5, R.drawable.z6, R.drawable.z7,
        )
    }
    val qwjrqwjri2 = remember {
        mutableStateOf(false)
    }
    val qwirjuqwruwrji = remember {
        Animatable(1550f)
    }
    val qwjwjrwrji2 = remember {
        mutableStateOf(50)
    }
    val wiqrhqujirwi2 = remember {
        (0..7777).mapIndexed { index: Int, i: Int ->
            Item(
                index,
                gameImages.random(),
                1
            )
        }
    }
    val qwirjqwrijir2 = remember {
        (0..7777).mapIndexed { index: Int, i: Int ->
            Item(
                index,
                gameImages.random(),
                2
            )
        }
    }
    val fqworijqwrwo2 = remember {
        (0..7777).mapIndexed { index: Int, i: Int ->
            Item(
                index,
                gameImages.random(),
                3
            )
        }
    }
    val jiqwriqwriw2 = remember {
        (0..7777).mapIndexed { index: Int, i: Int ->
            Item(
                index,
                gameImages.random(),
                4
            )
        }
    }
    val qiwjriqwriiwr2 = remember {
        (0..7777).mapIndexed { index: Int, i: Int ->
            Item(
                index,
                gameImages.random(),
                5
            )
        }
    }
    val wjqiriqwriwqjir2 = remember { (sizeSolo * columns).dp }
    val jiqwriqwrjqj = remember { (sizeSolo * lines).dp }
    val qwjiriqwijrqwirjir2 = rememberLazyListState()
    val wjqriqwrjwqir2 = rememberLazyListState()
    val wqirqwrhuqhwrjiw2 = rememberLazyListState()
    val jiqwfiiwjirii2 = rememberLazyListState()
    val wqijrjiqwriqwriwij2 = rememberLazyListState()
    val jqwriwrqwjirjiqwrij2 = remember {
        mutableStateOf(listOf<Item>())
    }
    val qwijrqhwrqwrji2 = remember {
        MediaPlayer.create(fuiqwurwi2,R.raw.winsound)
    }
    val iqwhruqhwriqjwr2 = remember {
        MediaPlayer.create(fuiqwurwi2,R.raw.wheel)
    }
    suspend fun oqwrijqr82urhwirj(items: List<Item>) {
        val jiqwrijqwri2 = items.first().imgId
        val qwjriqwr2rhi2r = items.size
        var hufawijahjwi4 = qwjwjrwrji2.value

        when (jiqwrijqwri2) {
            R.drawable.z1 -> {
                hufawijahjwi4 *= 2
            }

            R.drawable.z2 -> {
                hufawijahjwi4 *= 3
            }

            R.drawable.z3 -> {
                hufawijahjwi4 *= 4
            }

            R.drawable.z4 -> {
                hufawijahjwi4 *= 5
            }

            R.drawable.z5 -> {
                hufawijahjwi4 *= 7
            }

            R.drawable.z6 -> {
                hufawijahjwi4 *= 9
            }

            R.drawable.z7 -> {
                hufawijahjwi4 *= 12
            }
        }
        when (qwjriqwr2rhi2r) {
            4 -> {
                hufawijahjwi4 *= 2
            }

            5 -> {
                hufawijahjwi4 *= 3
            }
        }
        jqwriwrqwjirjiqwrij2.value = items
         qwijrqhwrqwrji2.seekTo(0)
         qwijrqhwrqwrji2.start()
            coroutineScope{
                qwirjuqwruwrji.animateTo(qwirjuqwruwrji.value+hufawijahjwi4, tween(2000))
            }

        jqwriwrqwjirjiqwrij2.value = listOf()

    }

    val qwjiriqwjriwr2 = remember { derivedStateOf { qwjiriqwijrqwirjir2.layoutInfo.visibleItemsInfo } }
    val wqjirqwrjiwrj2 = remember { derivedStateOf { wjqriqwrjwqir2.layoutInfo.visibleItemsInfo } }
    val qwjiriqwjirhi2 = remember { derivedStateOf { wqirqwrhuqhwrjiw2.layoutInfo.visibleItemsInfo } }
    val wqhurquiwrhiuu2 = remember { derivedStateOf { jiqwfiiwjirii2.layoutInfo.visibleItemsInfo } }
    val qwirhqwrqwrj2 = remember { derivedStateOf { wqijrjiqwriqwriwij2.layoutInfo.visibleItemsInfo } }
    val pxInLine = remember { mutableStateOf(0) }
    if (qwjiriqwjriwr2.value.isNotEmpty() && pxInLine.value == 0) {
        pxInLine.value = qwjiriqwjriwr2.value.first().size * 3
    }
    val coroutineScope = rememberCoroutineScope()
    val scaleGameBack = remember{
        Animatable(1f)
    }
    val leftPanelVisible = remember {
        mutableStateOf(false)
    }
    val rightPanelVisible = remember {
        mutableStateOf(false)
    }
    val showGameFrame = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit){
       rightPanelVisible.value=true
    }
    LaunchedEffect(key1 = Unit){
        leftPanelVisible.value=true
    }
    LaunchedEffect(key1 = Unit){
        delay(1000)
        showGameFrame.value = true
    }
    LaunchedEffect(key1 = Unit){
        scaleGameBack.animateTo(1.1f, tween(3000, easing = LinearOutSlowInEasing))
        scaleGameBack.animateTo(1.05f, tween(2000, easing = LinearEasing))
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bg), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        AnimatedVisibility(visible = showGameFrame.value,modifier = Modifier
            .align(Alignment.Center)
            .size(wjqiriqwriwqjir2 + paddingval.dp * 2, jiqwriqwrjqj + paddingval.dp * 2),
            enter = fadeIn(tween(2000,easing = LinearEasing)) +
            slideInVertically(tween(2000, easing = LinearEasing)) { 60 }
        + scaleIn(tween(2000,easing = LinearEasing), initialScale = 0.88f)){
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color(0x66F8D25E), Color(0x99CC8C3D), Color(0x99973F10))
                            ),
                            RoundedCornerShape(6.dp)
                        )
                        .border(paddingval.dp, color = Color(0xFFA73B3B),RoundedCornerShape(6.dp))
                        .clip(RoundedCornerShape(6.dp))
                        .padding(paddingval.dp)
                ) {
                    BetLinene(jiqwfjqwji = wiqrhqujirwi2, jiqwrhuqwhrhui2 = qwjiriqwijrqwirjir2, animatedItems = jqwriwrqwjirjiqwrij2.value)
                    BetLinene(jiqwfjqwji = qwirjqwrijir2, jiqwrhuqwhrhui2 = wjqriqwrjwqir2, animatedItems = jqwriwrqwjirjiqwrij2.value)
                    BetLinene(jiqwfjqwji = fqworijqwrwo2, jiqwrhuqwhrhui2 = wqirqwrhuqhwrjiw2, animatedItems = jqwriwrqwjirjiqwrij2.value)
                    BetLinene(jiqwfjqwji = jiqwriqwriw2, jiqwrhuqwhrhui2 = jiqwfiiwjirii2, animatedItems = jqwriwrqwjirjiqwrij2.value)
                    BetLinene(jiqwfjqwji = qiwjriqwriiwr2, jiqwrhuqwhrhui2 = wqijrjiqwriqwriwij2, animatedItems = jqwriwrqwjirjiqwrij2.value)
                }


            }
        }



        val anelTweenDuration = remember{ 2500 }
        val panelTweenEasing = remember{ LinearOutSlowInEasing }

        AnimatedVisibility(visible = leftPanelVisible.value, enter =
        slideInVertically(tween(anelTweenDuration,0,panelTweenEasing)) { 50 } +
                slideInHorizontally(tween(anelTweenDuration,0,panelTweenEasing)) { 50 } + fadeIn(
            tween(anelTweenDuration,0,panelTweenEasing)),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp, end = 16.dp)) {
            Row(
               horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                egupt_b(
                    onClick = {
                        if(qwjwjrwrji2.value>0 && !wqijrjiqwriqwriwij2.isScrollInProgress)
                            qwjwjrwrji2.value-=5
                    }
                ) {

                    Image(
                        painter = painterResource(id =  R.drawable.less), contentDescription ="", modifier = Modifier.size(44.dp)
                    )
                }
                egupt_b(
                    onClick = {


                        if (!wqijrjiqwriqwriwij2.isScrollInProgress && qwirjuqwruwrji.value >= qwjwjrwrji2.value && jqwriwrqwjirjiqwrij2.value.isEmpty()) {
                          coroutineScope.launch {
                              qwirjuqwruwrji.animateTo(qwirjuqwruwrji.value - qwjwjrwrji2.value, tween(400))
                          }
                            iqwhruqhwriqjwr2.seekTo(0)
                            iqwhruqhwriqjwr2.start()
                            coroutineScope.launch {
                                val egyptEasing = CubicBezierEasing(0.4f, 0.74f, 0.8f, 0.96f)
                                launch {
                                    qwjiriqwijrqwirjir2.animateScrollBy(
                                        pxInLine.value * 9f,
                                        tween(2970, easing = egyptEasing)
                                    )
                                }
                                launch {
                                    wjqriqwrjwqir2.animateScrollBy(
                                        pxInLine.value * 9f,
                                        tween(3050, easing = egyptEasing)
                                    )
                                }
                                launch {
                                    wqirqwrhuqhwrjiw2.animateScrollBy(
                                        pxInLine.value * 9f,
                                        tween(3120, easing = egyptEasing)
                                    )
                                }
                                launch {
                                    jiqwfiiwjirii2.animateScrollBy(
                                        pxInLine.value * 9f,
                                        tween(3170, easing = egyptEasing)
                                    )
                                }
                                launch {
                                    wqijrjiqwriqwriwij2.animateScrollBy(
                                        pxInLine.value * 9f,
                                        tween(3200, easing = egyptEasing)
                                    )
                                }
                                    .join()
                                val mapaItems =
                                    listOf(qwjiriqwjriwr2.value, wqjirqwrjiwrj2.value, qwjiriqwjirhi2.value, wqhurquiwrhiuu2.value, qwirhqwrqwrj2.value)
                                val realItems = listOf(
                                    listOf(
                                        wiqrhqujirwi2[mapaItems[0][0].index],
                                        wiqrhqujirwi2[mapaItems[0][1].index],
                                        wiqrhqujirwi2[mapaItems[0][2].index]
                                    ),
                                    listOf(
                                        qwirjqwrijir2[mapaItems[1][0].index],
                                        qwirjqwrijir2[mapaItems[1][1].index],
                                        qwirjqwrijir2[mapaItems[1][2].index]
                                    ),
                                    listOf(
                                        fqworijqwrwo2[mapaItems[2][0].index],
                                        fqworijqwrwo2[mapaItems[2][1].index],
                                        fqworijqwrwo2[mapaItems[2][2].index]
                                    ),
                                    listOf(
                                        jiqwriqwriw2[mapaItems[3][0].index],
                                        jiqwriqwriw2[mapaItems[3][1].index],
                                        jiqwriqwriw2[mapaItems[3][2].index]
                                    ),
                                    listOf(
                                        qiwjriqwriiwr2[mapaItems[4][0].index],
                                        qiwjriqwriiwr2[mapaItems[4][1].index],
                                        qiwjriqwriiwr2[mapaItems[4][2].index]
                                    ),
                                )

                                suspend fun ifItemsTheSame(list: List<Pair<Int, Int>>): Boolean {
                                    var same = true
                                    for (i in 1 until list.size) {
                                        if (realItems[list[i].first][list[i].second].imgId != realItems[list[i - 1].first][list[i - 1].second].imgId) {
                                            same = false
                                        }
                                    }
                                    val items = list.map { pair -> realItems[pair.first][pair.second] }
                                    if (same) {
                                        oqwrijqr82urhwirj(items)
                                    }


                                    return same

                                }
                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 0),
                                            Pair(1, 0),
                                            Pair(2, 0),
                                            Pair(3, 0),
                                            Pair(4, 0)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 0),
                                                Pair(1, 0),
                                                Pair(2, 0),
                                                Pair(3, 0)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 0), Pair(1, 0), Pair(2, 0)))
                                }
                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 1),
                                            Pair(1, 1),
                                            Pair(2, 1),
                                            Pair(3, 1),
                                            Pair(4, 1)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 1),
                                                Pair(1, 1),
                                                Pair(2, 1),
                                                Pair(3, 1)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 1), Pair(1, 1), Pair(2, 1)))
                                }

                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 2),
                                            Pair(1, 2),
                                            Pair(2, 2),
                                            Pair(3, 2),
                                            Pair(4, 2)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 2),
                                                Pair(1, 2),
                                                Pair(2, 2),
                                                Pair(3, 2)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 2), Pair(1, 2), Pair(2, 2)))
                                }

                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 2),
                                            Pair(1, 2),
                                            Pair(2, 1),
                                            Pair(3, 2),
                                            Pair(4, 2)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 2),
                                                Pair(1, 2),
                                                Pair(2, 1),
                                                Pair(3, 2)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 2), Pair(1, 2), Pair(2, 1)))
                                }

                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 0),
                                            Pair(1, 0),
                                            Pair(2, 1),
                                            Pair(3, 0),
                                            Pair(4, 0)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 0),
                                                Pair(1, 0),
                                                Pair(2, 1),
                                                Pair(3, 0)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 0), Pair(1, 0), Pair(2, 1)))
                                }


                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 0),
                                            Pair(1, 1),
                                            Pair(2, 2),
                                            Pair(3, 1),
                                            Pair(4, 0)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 0),
                                                Pair(1, 1),
                                                Pair(2, 2),
                                                Pair(3, 1)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)))
                                }

                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 2),
                                            Pair(1, 1),
                                            Pair(2, 0),
                                            Pair(3, 1),
                                            Pair(4, 2)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 2),
                                                Pair(1, 1),
                                                Pair(2, 0),
                                                Pair(3, 1)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 2), Pair(1, 1), Pair(2, 0)))
                                }

                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 1),
                                            Pair(1, 1),
                                            Pair(2, 2),
                                            Pair(3, 1),
                                            Pair(4, 1)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 1),
                                                Pair(1, 1),
                                                Pair(2, 2),
                                                Pair(3, 1)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 1), Pair(1, 1), Pair(2, 2)))
                                }

                                if (!ifItemsTheSame(
                                        listOf(
                                            Pair(0, 1),
                                            Pair(1, 1),
                                            Pair(2, 0),
                                            Pair(3, 1),
                                            Pair(4, 1)
                                        )
                                    )
                                ) {
                                    if (!ifItemsTheSame(
                                            listOf(
                                                Pair(0, 1),
                                                Pair(1, 1),
                                                Pair(2, 0),
                                                Pair(3, 1)
                                            )
                                        )
                                    )
                                        ifItemsTheSame(listOf(Pair(0, 1), Pair(1, 1), Pair(2, 0)))
                                }


                            }
                        }
                    },
                ) {
                    Image(
                        painter = painterResource(id =  R.drawable.spin),
                        contentDescription ="",
                        modifier = Modifier
                            .size(120.dp,70.dp)
                    )
                }
                egupt_b(
                    onClick = {
                        if(qwjwjrwrji2.value<qwirjuqwruwrji.value&& !wqijrjiqwriqwriwij2.isScrollInProgress)
                            qwjwjrwrji2.value+=5}
                ) {
                    Image(
                        painter = painterResource(id =  R.drawable.more),
                        contentDescription ="",
                        modifier = Modifier
                            .size(44.dp)
                    )
                }

            }
        }


        AnimatedVisibility(visible = leftPanelVisible.value, enter =
        slideInVertically(tween(anelTweenDuration,0,panelTweenEasing)) { 50 } +
                slideInHorizontally(tween(anelTweenDuration,0,panelTweenEasing)) { -50 } + fadeIn(
            tween(anelTweenDuration,0,panelTweenEasing)),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 16.dp, start = 24.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.Start
            ) {

                egupt_b(
                    onClick = {

                    }
                ) {
                    Text(
                        text = "Bet: ${qwjwjrwrji2.value}", color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.tiltreg)
                        ), fontSize = 24.sp,
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(Color(0xFFE6DC83), Color(0xFFD5A762), Color(0xFFBD693C))
                                ),
                                shape = RoundedCornerShape(24)
                            )
                            .clip(RoundedCornerShape(24))
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(24)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
                egupt_b(
                    onClick = {
                        qwjrqwjri2.value = true
                    }
                ) {
                    Text(
                        text = "Help?", color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.tiltreg)
                        ), fontSize = 24.sp,
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(Color(0xFFE6DC83), Color(0xFFD5A762), Color(0xFFBD693C))
                                ),
                                shape = RoundedCornerShape(24)
                            )
                            .clip(RoundedCornerShape(24))
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(24)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
                egupt_b(
                    onClick = {

                    }
                ) {
                    Text(
                        text = "Balance: ${qwirjuqwruwrji.value.toInt()}", color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.tiltreg)
                        ), fontSize = 24.sp,
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(Color(0xFFE6DC83), Color(0xFFD5A762), Color(0xFFBD693C))
                                ),
                                shape = RoundedCornerShape(24)
                            )
                            .clip(RoundedCornerShape(24))
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(24)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }

        AnimatedVisibility(visible = qwjrqwjri2.value, enter = fadeIn(), exit = fadeOut(), modifier = Modifier.align(
            Alignment.Center)){
                Box(modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { qwjrqwjri2.value = false }, contentAlignment = Alignment.Center) {


                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxSize()
                            .background(Color(0x990C0C0C))
                           ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier

                            ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z1),
                                    contentDescription = "",
                                    modifier = Modifier.size(40.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x2\n4 = x4\n5 = x6", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z2),
                                    contentDescription = "",
                                    modifier = Modifier.size(40.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x3\n4 = x6\n5 = x9", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z3),
                                    contentDescription = "",
                                    modifier = Modifier.size(40.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x4\n4 = x8\n5 = x12", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }

                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z4),
                                    contentDescription = "",
                                    modifier = Modifier.size(40.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x5\n4 = x10\n5 = x15", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {


                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z5),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(
                                            RoundedCornerShape(8.dp)
                                        ),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x7\n4 = x14\n5 = x21", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z6),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(
                                            RoundedCornerShape(8.dp)
                                        ),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x9\n4 = x18\n5 = x27", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }

                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFA0D166),
                                                Color(0xFF247E28),
                                                Color(0xFF0B580E)
                                            )
                                        ),
                                        shape = RoundedCornerShape(24)
                                    )
                                    .clip(RoundedCornerShape(24))
                                    .border(
                                        width = 1.4.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(24)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.z7),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(
                                            RoundedCornerShape(8.dp)
                                        ),
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = "3 = x12\n4 = x24\n5 = x36", color = Color.Black,
                                    fontFamily = FontFamily(
                                        Font(R.font.tiltreg)
                                    ), fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                listOf(
                                                    Color(0xFFF3E77A),
                                                    Color(0xFFD5B862),
                                                    Color(0xFFBD893C)
                                                )
                                            ),
                                            shape = RoundedCornerShape(24)
                                        )
                                        .clip(RoundedCornerShape(24))
                                        .border(
                                            width = 1.4.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(24)
                                        )
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }

                        }
                    }
                }
            }

        }

    BackHandler {
        fuiqwurwi2.finishAffinity()
    }
    }










@Composable
fun BetLinene(jiqwfjqwji: List<Item>, jiqwrhuqwhrhui2: LazyListState, animatedItems: List<Item>) {
    LazyColumn(
        state = jiqwrhuqwhrhui2,
        reverseLayout = true,
        userScrollEnabled = false
    ) {
        items(jiqwfjqwji, key = { it.id }) {

            val infinityTransition = rememberInfiniteTransition()
            val animation = infinityTransition.animateFloat(
                initialValue = 1f,
                targetValue = 1.1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(500),
                    repeatMode = RepeatMode.Reverse
                ), label = ""
            )
            Image(
                painter = painterResource(id = it.imgId),
                contentDescription = null,
                modifier = Modifier
                    .scale(
                        if (animatedItems.contains(it))
                            animation.value
                        else
                            1f
                    )
                    .size(sizeSolo.dp)
                    .padding(8.dp)
                    .clip(
                        RoundedCornerShape(12.dp)
                    ),
                contentScale = ContentScale.Fit
            )

    }}


}