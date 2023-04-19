package com.pratik.flipcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Column(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 40.dp)
    ) {
        FlippingView(cardFace = cardFace,
            cardOrientation = CardOrientation.HORIZONTAL,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.655F),
            flippingDuration = 700,
            onViewClick = {
                cardFace = it.whatNext
            },
            cardShadow = 5,
            cornerSize = 15.dp,
            frontView = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CardColorYellow),
                    contentAlignment = Alignment.Center
                ) {

                    Column {
                        Image(
                            painterResource(id = R.drawable.logo), contentDescription = stringResource(
                                                            R.string.patrik_codes_logo)
                        )
                        Text(
                            stringResource(R.string.patrik_codes),
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }

            },
            backView = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CardColorYellow),
                    contentAlignment = Alignment.Center
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            stringResource(R.string.follow_me_on),
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            modifier = Modifier.padding(start = 15.dp),
                            fontSize = 18.sp,
                            textDecoration = TextDecoration.Underline
                        )

                        Column {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_logo_insta),
                                    contentDescription = stringResource(R.string.instagram_logo),
                                    modifier = Modifier
                                        .size(32.dp)
                                        .aspectRatio(1f)
                                )

                                Text(
                                    stringResource(R.string.patrik_codes),
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    modifier = Modifier.padding(start = 15.dp),
                                    fontSize = 14.sp
                                )

                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 15.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_logo_twitter),
                                    contentDescription = stringResource(R.string.twitter_logo),
                                    modifier = Modifier
                                        .size(32.dp)
                                        .aspectRatio(1f)
                                )

                                Text(
                                    stringResource(R.string.pfagadiya),
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    modifier = Modifier.padding(start = 15.dp),
                                    fontSize = 14.sp
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 15.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_logo_github),
                                    contentDescription = stringResource(R.string.github_logo),
                                    modifier = Modifier
                                        .size(32.dp)
                                        .aspectRatio(1f)
                                )

                                Text(
                                    stringResource(R.string.pratik_fagadiya),
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    modifier = Modifier.padding(start = 15.dp),
                                    fontSize = 14.sp
                                )
                            }
                        }


                    }

                }
            })
    }

}