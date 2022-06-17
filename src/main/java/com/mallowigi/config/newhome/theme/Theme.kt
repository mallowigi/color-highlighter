/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2022 Elior "Mallowigi" Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.mallowigi.config.newhome.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val green200 = Color(0xffa5d6a7)
val green500 = Color(0xff4caf50)
val green700 = Color(0xff388e3c)

val teal200 = Color(0xff80deea)

private val DarkGreenColorPalette = darkColors(
  primary = green200,
  primaryVariant = green700,
  secondary = teal200,
  onPrimary = Color.Black,
  onSecondary = Color.White,
  error = Color.Red,
)

private val LightGreenColorPalette = lightColors(
  primary = green500,
  primaryVariant = green700,
  secondary = teal200,
  onPrimary = Color.White,
  onSurface = Color.Black
)

private val myShapes: Shapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(4.dp),
  large = RoundedCornerShape(0.dp)
)

private val myTypography = Typography(
  body1 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  body2 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
  ),
  button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
  ),
  caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
  ),
  subtitle1 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    color = Color.Gray
  ),
  subtitle2 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = Color.Gray
  ),
)


/**
 * Create a theme as an instance of MaterialTheme
 *
 * @param darkTheme whether its dark
 * @param content the content to wrap
 * @receiver
 */
@Composable
fun WidgetTheme(darkTheme: Boolean = false,
                content: @Composable() () -> Unit) {
  val myColors = if (darkTheme) DarkGreenColorPalette else LightGreenColorPalette
  val swingColor = SwingColor()

  // Sets the theme as a material theme
  MaterialTheme(
    colors = myColors.copy(
      // set colors from Panel.background and Panel.foreground
      background = swingColor.background,
      onBackground = swingColor.foreground,
      surface = swingColor.background,
      onSecondary = swingColor.foreground,
    ),
    typography = myTypography,
    shapes = myShapes,
    content = content
  )
}
