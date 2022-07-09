package com.example.myapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Template

        setContent {
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val anim by animateDpAsState(
                targetValue = sizeState,
//                animationSpec = tween(
//                    durationMillis = 3000,
//                    delayMillis = 300,
//                    easing = LinearOutSlowInEasing
//                ),

//            animationSpec = spring(
//                Spring.DampingRatioHighBouncy
//            )

                keyframes {
                    durationMillis = 4000
                    sizeState at 0 with LinearEasing
                    sizeState * 1.5f at 1000 with FastOutLinearInEasing
                    sizeState * 2f at 4000
                }
            )
            Box(modifier = Modifier
                .size(anim)
                .background(Color.Magenta),
            contentAlignment = Alignment.Center) {
                Button(onClick = {
                    sizeState += 50.dp
                }) {
                    Text(text = "increase size")
                }
            }
        }
    }
}
