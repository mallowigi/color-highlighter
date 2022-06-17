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

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Scrollable lazy panel
@Composable
fun LazyScrollable() {
  MaterialTheme {
    CompositionLocalProvider(
      LocalScrollbarStyle provides ScrollbarStyle(
        minimalHeight = 16.dp,
        thickness = 8.dp,
        shape = MaterialTheme.shapes.small,
        hoverDurationMillis = 300,
        unhoverColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
        hoverColor = MaterialTheme.colors.onSurface.copy(alpha = 0.50f)
      )
    ) {
      Box(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        val state = rememberLazyListState()
        val itemCount = 100

        LazyColumn(Modifier.fillMaxSize().padding(end = 12.dp), state) {
          items(itemCount) { x ->
            TextBox("Item in ScrollableColumn #$x")
            Spacer(modifier = Modifier.height(5.dp))
          }
        }
        VerticalScrollbar(
          modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
          adapter = rememberScrollbarAdapter(
            scrollState = state
          )
        )
      }
    }
  }
}

@Composable
private fun TextBox(text: String = "Item") {
  Surface(
    color = Color(135, 135, 135, 40),
    shape = RoundedCornerShape(4.dp)
  ) {
    Box(
      modifier = Modifier.height(32.dp)
        .fillMaxWidth()
        .padding(start = 10.dp),
      contentAlignment = Alignment.CenterStart
    ) {
      Text(text = text)
    }
  }
}
