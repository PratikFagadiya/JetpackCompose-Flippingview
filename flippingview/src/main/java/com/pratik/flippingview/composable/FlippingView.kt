package com.pratik.flippingview.composable

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pratik.flippingview.enum.CardFace
import com.pratik.flippingview.enum.CardOrientation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlippingView(
    cardFace: CardFace,
    cardOrientation: CardOrientation = CardOrientation.HORIZONTAL,
    modifier: Modifier = Modifier,
    flippingDuration: Int = 2000,
    cardShadow: Int = 0,
    cornerSize: Dp = 0.dp,
    onViewClick: (CardFace) -> Unit,
    frontView: @Composable () -> Unit = {},
    backView: @Composable () -> Unit = {}
) {

    val cardRotation = animateFloatAsState(
        targetValue = cardFace.angel, animationSpec = tween(
            durationMillis = flippingDuration, easing = FastOutSlowInEasing
        )
    )

    Card(onClick = {
        onViewClick(cardFace)
    }, modifier = modifier.graphicsLayer {
        if (cardOrientation == CardOrientation.VERTICAL) {
            rotationX = cardRotation.value
            cameraDistance = 50f * density
        } else {
            rotationY = cardRotation.value
            cameraDistance = 12f * density
        }

    },
        elevation = CardDefaults.cardElevation(
            defaultElevation = cardShadow.dp
        ), shape = RoundedCornerShape(cornerSize)
    ) {

        Box(modifier = modifier.fillMaxSize()) {
            if (cardRotation.value <= 90f) {   // If the angle is 90° or less we show the front
                Box(modifier = Modifier.fillMaxSize()) {
                    frontView()
                }
            } else {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        if (cardOrientation == CardOrientation.VERTICAL) {
                            rotationX = CardFace.Back.angel
                        } else {
                            rotationY = CardFace.Back.angel
                        }

                    }) {
                    backView()
                }
            }
        }
    }

}