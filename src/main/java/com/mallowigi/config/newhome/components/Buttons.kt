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

package com.mallowigi.config.newhome.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Buttons() {
  Row {
    // First button: Favorite Icon Button
    val btnEnabled = remember { mutableStateOf(true) }
    Button(
      onClick = { btnEnabled.value = !btnEnabled.value },
      modifier = Modifier.padding(8.dp),
      enabled = btnEnabled.value
    ) {
      Icon(
        imageVector = Icons.Default.FavoriteBorder,
        contentDescription = "FavoriteBorder",
        modifier = Modifier.padding(end = 4.dp)
      )
      Text(text = "Button")
    }

    // Second button: Text Button
    val textBtnEnabled = remember { mutableStateOf(true) }
    TextButton(
      onClick = { textBtnEnabled.value = !textBtnEnabled.value },
      modifier = Modifier.padding(8.dp),
      enabled = textBtnEnabled.value
    ) {
      Text(text = "Text Button")
    }

    // Third button: outline button to toggle both
    OutlinedButton(
      onClick = {
        btnEnabled.value = true
        textBtnEnabled.value = true
      },
      modifier = Modifier.padding(8.dp)
    ) {
      Icon(
        imageVector = Icons.Default.Refresh,
        contentDescription = "Refresh",
        modifier = Modifier.padding(0.dp)
      )
    }
  }
}

