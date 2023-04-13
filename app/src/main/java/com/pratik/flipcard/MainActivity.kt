package com.pratik.flipcard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratik.flipcard.ui.theme.CardColorYellow
import com.pratik.flipcard.ui.theme.FlipCardTheme
import com.pratik.flippingview.composable.FlippingView
import com.pratik.flippingview.enum.CardFace
import com.pratik.flippingview.enum.CardOrientation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    FlippingCard()
                }
            }
        }
    }

}


@Preview
@Composable
fun FlippingCard() {
    var cardFace by remember {
        mutableStateOf(CardFace.Front)
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 25.dp)
    ) {
        FlippingView(cardFace = cardFace,
            cardOrientation = CardOrientation.VERTICAL,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.655F),
            flippingDuration = 700,
            cardShadow = 0,
            cornerSize = 15.dp,
            onViewClick = {
                cardFace = it.whatNext
            },
            frontView = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CardColorYellow),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Front View")

                }
            },
            backView = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CardColorYellow),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Back View")
                }
            })
    }

}