package com.nsalz.gwt.canvas.create.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Command;
import com.nsalz.gwt.canvas.create.client.FrameRateScheduler;
import com.nsalz.gwt.canvas.create.client.tools.DrawingBoard;
import com.nsalz.gwt.canvas.create.client.tools.Graphic;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.Transform;

abstract class AbstractDrawingBoard extends ContextDrawingTool implements DrawingBoard
{
    private final List<Graphic> graphics = new ArrayList<Graphic>();
    private final List<AbstractDrawingBoard> childDrawingBoards = new ArrayList<AbstractDrawingBoard>();
    private final Command repaintCommand = new Command(){
        @Override
        public void execute()
        {
            doRepaint();
        }
    };
    
    public AbstractDrawingBoard(Context2d context)
    {
        super(context);
    }
    
    @Override
    public DrawingBoard createChildDrawingBoard()
    {
        return addDrawingBoard(new ChildDrawingBoard(this));
    }

    @Override
    public DrawingBoard createChildDrawingBoard(Shape shape)
    {
        return addDrawingBoard(new ChildDrawingBoard.ShapedDrawingBoard(this, shape));
    }

    @Override
    public DrawingBoard createChildDrawingBoard(Transform transform)
    {
        return addDrawingBoard(new ChildDrawingBoard.TransformedDrawingBoard(this, transform));
    }
    
    @Override
    public void addGraphic(Graphic graphic)
    {
        graphics.add(graphic);
    }

    @Override
    public void repaint()
    {
        FrameRateScheduler.get().addToNextFrame(repaintCommand);
    }
    
    protected void doRepaint()
    {
        for (Graphic graphic : graphics) {
            getContext().save();
            graphic.draw(this);
            getContext().restore();
        }
        for (AbstractDrawingBoard drawingBoard : childDrawingBoards) {
            drawingBoard.doRepaint();
        }
    }

    @Override
    public void onResize()
    {
        repaint();
    }

    private DrawingBoard addDrawingBoard(AbstractDrawingBoard drawingBoard)
    {
        childDrawingBoards.add(drawingBoard);
        return drawingBoard;
    }



}
