# Flipping View

Why settle for boring, static screens in your app when you can add a dynamic and engaging visual experience with FlippingView?

**It's time to give your app the wow-factor it deserves!**

**FlippingView** library is built with the latest Jetpack Compose and Material Design 3 API technology, making it both cutting-edge and experimental. It's super easy to use, and our code is well-documented, so you'll be flipping cards like a pro in no time.

*Made with love ❤️ by [Pratik Fagadiya](https://github.com/pratikfagadiya)*

https://user-images.githubusercontent.com/66842132/233161793-0b81cd7f-9377-4d19-90f5-4521476b90f1.mp4

![](https://camo.githubusercontent.com/d24f2f8414437a9491ea3145cafd373167315d50/68747470733a2f2f666f7274686562616467652e636f6d2f696d616765732f6261646765732f6275696c742d776974682d6c6f76652e737667) ![](https://camo.githubusercontent.com/e82fcde6b4952d69611ae4cf507b13fe6ae8e028/68747470733a2f2f666f7274686562616467652e636f6d2f696d616765732f6261646765732f6275696c742d666f722d616e64726f69642e737667)
<br>

<br />

## How to use
You can create a FlippingView with the `FlippingViewl` composable.

```kotlin
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
)
```
In it's simplest form **FlippingView** can be used as animated preview for front and back view.

```kotlin

var cardFace by remember { mutableStateOf(CardFace.Front) }

FlippingView(cardFace = cardFace, onViewClick = {
      cardFace = it.whatNext
  }, frontView = {
      // Front View
  }, backView = {
      // Back View
  }
)

```

### Customization
```kotlin
var cardFace by remember {
    mutableStateOf(CardFace.Front)  // Initial Value Either  CardFace.Front or CardFace.Back
}

FlippingView(cardFace = cardFace,

    // Card flipping orientation default value is `HORIZONTAL` you can use `HORIZONTAL` or `VERTICAL`
    cardOrientation = CardOrientation.HORIZONTAL,

    // Customize modifier as per your requirement
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.655F),

    // Flipping duration in millisecond default value is 2s (2000)
    flippingDuration = 700,

    // Flip view on card click, You can perform your requirement as well
    onViewClick = {
        cardFace = it.whatNext
    },

    // Default card shadow value is 0, You can customize as per your need
    cardShadow = 5,

    // Card rounded corner radius for your card layout, default value is 0.dp
    cornerSize = 15.dp,

    // Card front view
    frontView = {

    },

    // Card back view
    backView = {

    }
)
```

<br />

## Donate

If you found this library helpful or you learned something from the source code and want to thank me, consider buying me a cup of :coffee:

[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/yellow_img.png)](https://www.buymeacoffee.com/pratikf)

<br />

## Find this library useful ? ❤️

- Support it by clicking the ⭐️ button on the upper right of this page and share with others. ✌️

  Also, follow me on __[github](https://github.com/PratikFagadiya)__ and __[twitter](https://twitter.com/PFagadiya)__ to stay updated with my creations! 🤩

<br />

## Contribution 🤝

- If you would like to contribute you're most welcome! 💛

<br />

## Connect with me
<div align="left">
<a href="https://twitter.com/PFagadiy" target="https://twitter.com/PFagadiya">
<img src=https://img.shields.io/badge/twitter-%2300acee.svg?&style=for-the-badge&logo=twitter&logoColor=white alt=twitter style="margin-bottom: 5px;" />
</a>
<a href="https://www.linkedin.com/in/pratik-fagadiya-79b8081b0//" target="https://www.linkedin.com/in/pratik-fagadiya-79b8081b0/">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 5px;" />
</a>
<a href="https://www.instagram.com/patrik.codes/?next=%2Fpatcoder%2F&hl=en" target="https://www.instagram.com/patrik.codes/?next=%2Fpatcoder%2F&hl=en">
<img src=https://img.shields.io/badge/instagram-%23000000.svg?&style=for-the-badge&logo=instagram&logoColor=white alt=instagram style="margin-bottom: 5px;" />
</a> 
</div> 

</br>

## License 🔖
```
Apache 2.0 License


Copyright 2023 Pratik Fagadiya

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
