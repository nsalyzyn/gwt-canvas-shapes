/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.nsalz.gwt.canvas.create.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a {@link CssColor}, {@link CanvasGradient}, or
 * {@link CanvasPattern} that is used for stroke and fill.
 *
 * <p>
 * <span style="color:red">Copied from GWT 2.2.0 to freeze the API</span>
 * </p>
 */
class FillStrokeStyle extends JavaScriptObject {

  /**
   * Constant for CssColor style.
   */
  public static final int TYPE_CSSCOLOR = 0;

  /**
   * Constant for Gradient style.
   */
  public static final int TYPE_GRADIENT = 1;

  /**
   * Constant for Pattern style.
   */
  public static final int TYPE_PATTERN = 2;

  protected FillStrokeStyle() { }

  /**
   * Returns the type of this FillStrokeStyle as an integer.
   * 
   * @return The type of the object.
   */
  public final native int getType() /*-{
    // Unwrap the color to check its type when in dev mode (when isScript == false)
    var unwrappedColor = @com.google.gwt.core.client.GWT::isScript()() ? this : this[0];
    if (unwrappedColor && typeof(unwrappedColor) == 'string') {
      return @com.nsalz.gwt.canvas.create.client.ui.FillStrokeStyle::TYPE_CSSCOLOR;
    } else if (typeof(this.addColorStop) == 'function') {
      return @com.nsalz.gwt.canvas.create.client.ui.FillStrokeStyle::TYPE_GRADIENT;
    } else {
      return @com.nsalz.gwt.canvas.create.client.ui.FillStrokeStyle::TYPE_PATTERN;
    }
  }-*/;
}
