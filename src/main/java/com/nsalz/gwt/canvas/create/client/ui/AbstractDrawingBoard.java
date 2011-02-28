package com.nsalz.gwt.canvas.create.client.ui;

import com.nsalz.gwt.canvas.create.client.tools.DrawingBoard;
import com.nsalz.gwt.canvas.create.client.tools.Graphic;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.Transform;

abstract class AbstractDrawingBoard implements DrawingBoard
{
    private final Context2d context;
    
    public AbstractDrawingBoard(Context2d context)
    {
        this.context = context;
    }
    
    protected Context2d getContext()
    {
        return context;
    }

    @Override
    public DrawingBoard createChildDrawingBoard()
    {
        return new ChildDrawingBoard(this);
    }

    @Override
    public DrawingBoard createChildDrawingBoard(Shape shape)
    {
        return new ChildDrawingBoard.ShapedDrawingBoard(this, shape);
    }

    @Override
    public DrawingBoard createChildDrawingBoard(Transform transform)
    {
        return new ChildDrawingBoard.TransformedDrawingBoard(this, transform);
    }
    
    @Override
    public void addGraphic(Graphic graphic)
    {
     // TODO Auto-generated method stub
    }

    @Override
    public void repaint()
    {
    // TODO Auto-generated method stub

    }

    @Override
    public void onResize()
    {
    // TODO Auto-generated method stub

    }

}
