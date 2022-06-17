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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Toggles() {
  Column {
    Row {
      Column(modifier = Modifier.padding(16.dp)) {
        // Checkbox
        val checked = remember { mutableStateOf(true) }
        Checkbox(
          checked = checked.value,
          modifier = Modifier.padding(8.dp),
          onCheckedChange = { checked.value = it }
        )

        // Switch
        val switched = remember { mutableStateOf(false) }
        Switch(
          checked = switched.value,
          modifier = Modifier.padding(8.dp),
          onCheckedChange = { switched.value = it },
          colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colors.primary,
          )
        )
      }

      Column(modifier = Modifier.padding(16.dp)) {
        // Radio buttons
        val selected = remember { mutableStateOf("Kotlin") }
        // Kotlin
        Row(verticalAlignment = Alignment.CenterVertically) {
          RadioButton(
            selected = selected.value == "Kotlin",
            onClick = { selected.value = "Kotlin" },
          )
          Text(
            text = "Kotlin",
            modifier = Modifier.clickable(onClick = { selected.value = "Kotlin" }).padding(start = 4.dp)
          )
        }

        // Java
        Row(verticalAlignment = Alignment.CenterVertically) {
          RadioButton(
            selected = selected.value == "Java",
            onClick = { selected.value = "Java" },
          )
          Text(
            text = "Java",
            modifier = Modifier.clickable(onClick = { selected.value = "Java" }).padding(start = 4.dp)
          )
        }

        // Swift
        Row(verticalAlignment = Alignment.CenterVertically) {
          RadioButton(
            selected = selected.value == "Swift",
            onClick = { selected.value = "Swift" },
          )
          Text(
            text = "Swift",
            modifier = Modifier.clickable(onClick = { selected.value = "Swift" }).padding(start = 4.dp)
          )
        }
      }

      // Slider 1
      val sliderState = remember { mutableStateOf(0f) }
      Slider(
        value = sliderState.value,
        onValueChange = { sliderState.value = it },
        modifier = Modifier.fillMaxWidth().padding(8.dp)
      )

      // Slider 2
      val sliderState2 = remember { mutableStateOf(0f) }
      Slider(
        value = sliderState.value,
        onValueChange = { sliderState2.value = it },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        steps = 5,
        valueRange = 0f..100f
      )
    }
  }
}
