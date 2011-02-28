package com.nsalz.gwt.canvas.create.client.ui;

import com.nsalz.gwt.canvas.create.client.tools.CanvasImage;
import com.nsalz.gwt.canvas.create.client.tools.DrawingBoard;
import com.nsalz.gwt.canvas.create.client.tools.FillStyle;
import com.nsalz.gwt.canvas.create.client.tools.LineStyle;
import com.nsalz.gwt.canvas.create.client.tools.Path;
import com.nsalz.gwt.canvas.create.client.tools.ShadowAttributes;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.TextAttributes;
import com.nsalz.gwt.canvas.create.client.tools.Transform;
import com.nsalz.gwt.canvas.create.client.tools.Graphic.CompositeOperation;

class ChildDrawingBoard extends AbstractDrawingBoard
{
    private final DrawingBoard parentDrawingBoard;

    public ChildDrawingBoard(AbstractDrawingBoard parentDrawingBoard)
    {
        super(parentDrawingBoard.getContext());
        this.parentDrawingBoard = parentDrawingBoard;
    }

    @Override
    public DrawingBoard getParentDrawingBoard()
    {
        return parentDrawingBoard;
    }

    @Override
    public boolean isPointIncluded(int x, int y)
    {
        return parentDrawingBoard.isPointIncluded(x, y);
    }

    public static class ShapedDrawingBoard extends ChildDrawingBoard
    {
        private final Shape shape;

        public ShapedDrawingBoard(AbstractDrawingBoard parentDrawingBoard, Shape shape)
        {
            super(parentDrawingBoard);
            this.shape = shape;
        }

        // TODO do clip action
    }

    public static class TransformedDrawingBoard extends ChildDrawingBoard
    {
        private final Transform transform;

        public TransformedDrawingBoard(AbstractDrawingBoard parentDrawingBoard, Transform transform)
        {
            super(parentDrawingBoard);
            this.transform = transform;
        }

        // TODO do transform action
    }
}
