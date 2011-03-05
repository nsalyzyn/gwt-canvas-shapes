package com.nsalz.gwt.canvas.create.client.ui;

import com.nsalz.gwt.canvas.create.client.tools.DrawingLayer;
import com.nsalz.gwt.canvas.create.client.tools.Graphic;

class CanvasDrawingLayer<T extends Graphic> extends AbstractDrawingLayer<T>
{
    private final CanvasElement canvasElement;

    public CanvasDrawingLayer(CanvasElement canvasElement)
    {
        super(canvasElement.getContext2d());
        this.canvasElement = canvasElement;
    }
    
    @Override
    public DrawingLayer<T> getParentDrawingLayer()
    {
        return null;
    }

    @Override
    public boolean isPointIncluded(int x, int y)
    {
        return x >= 0 && y >= 0 && x <= canvasElement.getWidth() && y <= canvasElement.getHeight(); 
    }


    @Override
    protected void doRepaint()
    {
        getContext().clearRect(0, 0, canvasElement.getWidth(), canvasElement.getHeight());
        super.doRepaint();
    }
}
