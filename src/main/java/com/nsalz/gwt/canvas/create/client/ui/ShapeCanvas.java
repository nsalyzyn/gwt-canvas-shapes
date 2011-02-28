package com.nsalz.gwt.canvas.create.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.RequiresResize;
import com.nsalz.gwt.canvas.create.client.tools.DrawingBoard;

public class ShapeCanvas extends FocusWidget implements RequiresResize
{
    private static CanvasElementSupportDetector detector;

    /**
     * Return a new {@link Canvas} if supported, and null otherwise.
     * 
     * @return a new {@link Canvas} if supported, and null otherwise
     */
    public static ShapeCanvas createIfSupported()
    {
        if (detector == null) {
            detector = GWT.create(CanvasElementSupportDetector.class);
        }
        if (!detector.isSupportedCompileTime()) {
            return null;
        }
        CanvasElement element = Document.get().createElement(CanvasElement.TAG).cast();
        if (!CanvasElementSupportDetector.isSupportedRunTime(element)) {
            return null;
        }
        return new ShapeCanvas(element);
    }

    /**
     * Runtime check for whether the canvas element is supported in this
     * browser.
     * 
     * @return whether the canvas element is supported
     */
    public static boolean isSupported()
    {
        if (detector == null) {
            detector = GWT.create(CanvasElementSupportDetector.class);
        }
        if (!detector.isSupportedCompileTime()) {
            return false;
        }
        CanvasElement element = Document.get().createElement(CanvasElement.TAG).cast();
        if (!CanvasElementSupportDetector.isSupportedRunTime(element)) {
            return false;
        }
        return true;
    }
    
    private CanvasDrawingBoard drawingBoard;

    /**
     * Protected constructor. Use {@link #createIfSupported()} to create a
     * Canvas.
     */
    private ShapeCanvas(CanvasElement element)
    {
        setElement(element);
        drawingBoard = new CanvasDrawingBoard(getCanvasElement());        
    }
    
    public DrawingBoard getDrawingBoard()
    {
        return drawingBoard;
    }
    
    @Override
    public void onResize() {
        drawingBoard.onResize();
    }
    
    private CanvasElement getCanvasElement()
    {
        return getElement().cast();
    }

    /**
     * Detector for browser support of {@link CanvasElement}.
     */
    private static class CanvasElementSupportDetector
    {
        /**
         * Using a run-time check, return true if the {@link CanvasElement} is
         * supported.
         * 
         * @return true if supported, false otherwise.
         */
        static native boolean isSupportedRunTime(CanvasElement element) /*-{
            return !!element.getContext;
        }-*/;

        /**
         * Using a compile-time check, return true if {@link CanvasElement}
         * might be supported.
         * 
         * @return true if might be supported, false otherwise.
         */
        boolean isSupportedCompileTime()
        {
            // will be true in CanvasElementSupportDetectedMaybe
            // will be false in CanvasElementSupportDetectedNo
            return false;
        }
    }

    /**
     * Detector for permutations that might support {@link CanvasElement}.
     */
    @SuppressWarnings("unused")
    private static class CanvasElementSupportDetectedMaybe extends CanvasElementSupportDetector
    {
        /**
         * Using a compile-time check, return true if {@link CanvasElement}
         * might be supported.
         * 
         * @return true if might be supported, false otherwise.
         */
        @Override
        boolean isSupportedCompileTime()
        {
            return true;
        }
    }

    /**
     * Detector for permutations that do not support {@link CanvasElement}.
     */
    @SuppressWarnings("unused")
    private static class CanvasElementSupportDetectedNo extends CanvasElementSupportDetector
    {
        /**
         * Using a compile-time check, return true if {@link CanvasElement}
         * might be supported.
         * 
         * @return true if might be supported, false otherwise.
         */
        @Override
        boolean isSupportedCompileTime()
        {
            return false;
        }
    }

}