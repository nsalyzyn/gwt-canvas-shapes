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

/**
 * Pattern object used with {@link Context2d}.
 * 
 * <p>
 * <span style="color:red">Copied from GWT 2.2.0 to freeze the API</span>
 * </p>
 * 
 * Note that this class has no methods. It simply serves as a reference to a
 * pattern created using {@link Context2d#createPattern}.
 * 
 * @see <a href="http://www.w3.org/TR/2dcontext/#canvaspattern">HTML Canvas 2D CanvasPattern</a>
 */
class CanvasPattern extends FillStrokeStyle {

  protected CanvasPattern() {
  }
}
