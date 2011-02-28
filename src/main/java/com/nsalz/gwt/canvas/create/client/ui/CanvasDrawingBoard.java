package com.nsalz.gwt.canvas.create.client.ui;

import com.nsalz.gwt.canvas.create.client.tools.DrawingBoard;

class CanvasDrawingBoard extends AbstractDrawingBoard
{
    private final CanvasElement canvasElement;

    public CanvasDrawingBoard(CanvasElement canvasElement)
    {
        super(canvasElement.getContext2d());
        this.canvasElement = canvasElement;
    }
    
    @Override
    public DrawingBoard getParentDrawingBoard()
    {
        return null;
    }

    @Override
    public boolean isPointIncluded(int x, int y)
    {
        return x >= 0 && y >= 0 && x <= canvasElement.getWidth() && y <= canvasElement.getHeight(); 
    }


    @Override
    public void repaint()
    {
        getContext().clearRect(0, 0, canvasElement.getWidth(), canvasElement.getHeight());
        super.repaint();
    }
}
