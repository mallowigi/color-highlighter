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

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import javax.swing.UIManager

class SwingColorImpl : ISwingColor {
  /** Background property. */
  override val background: Color
    get() = _backgroundState.value

  override val foreground: Color
    get() = _foregroundState.value

  /** Mutable _background state. */
  private val _backgroundState: MutableState<Color> = mutableStateOf(getBackgroundColor)

  /** Mutable _foreground state. */
  private val _foregroundState: MutableState<Color> = mutableStateOf(getForegroundColor)

  /** Get background color from UIManager. */
  private val getBackgroundColor: Color
    get() = getColor(BACKGROUND_KEY)

  /** Get background color from UIManager. */
  private val getForegroundColor: Color
    get() = getColor(FOREGROUND_KEY)


  /** Get color from UIManager. */
  private fun getColor(key: String): Color = UIManager.getColor(key).asComposeColor

  /** Update current colors. */
  fun updateCurrentColors() {
    _backgroundState.value = getBackgroundColor
    _foregroundState.value = getForegroundColor
  }

  /** Ext function converting an AWT color to compose color. */
  private val java.awt.Color.asComposeColor: Color
    get() = Color(red, green, blue, alpha)

  companion object {
    private const val BACKGROUND_KEY = "Panel.background"
    private const val FOREGROUND_KEY = "Panel.foreground"
  }
}
