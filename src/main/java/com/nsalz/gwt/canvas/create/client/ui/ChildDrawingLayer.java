package com.nsalz.gwt.canvas.create.client.ui;

import com.nsalz.gwt.canvas.create.client.tools.DrawingLayer;
import com.nsalz.gwt.canvas.create.client.tools.Graphic;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.Transform;

class ChildDrawingLayer<T extends Graphic> extends AbstractDrawingLayer<T>
{
    private final DrawingLayer<T> parentLayer;

    public ChildDrawingLayer(AbstractDrawingLayer<T> parentLayer)
    {
        super(parentLayer.getContext());
        this.parentLayer = parentLayer;
    }

    @Override
    public DrawingLayer<T> getParentDrawingLayer()
    {
        return parentLayer;
    }

    @Override
    public boolean isPointIncluded(int x, int y)
    {
        return parentLayer.isPointIncluded(x, y);
    }

    public static class ShapedLayer<T extends Graphic> extends ChildDrawingLayer<T>
    {
        private final Shape shape;

        public ShapedLayer(AbstractDrawingLayer<T> parentLayer, Shape shape)
        {
            super(parentLayer);
            this.shape = shape;
        }

        // TODO do clip action
    }

    public static class TransformedLayer<T extends Graphic> extends ChildDrawingLayer<T>
    {
        private final Transform transform;

        public TransformedLayer(AbstractDrawingLayer<T> parentLayer, Transform transform)
        {
            super(parentLayer);
            this.transform = transform;
        }

        // TODO do transform action
    }
}
