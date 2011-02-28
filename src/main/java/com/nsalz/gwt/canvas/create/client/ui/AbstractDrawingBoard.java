package com.nsalz.gwt.canvas.create.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.nsalz.gwt.canvas.create.client.tools.CanvasImage;
import com.nsalz.gwt.canvas.create.client.tools.DrawingBoard;
import com.nsalz.gwt.canvas.create.client.tools.FillStyle;
import com.nsalz.gwt.canvas.create.client.tools.Graphic;
import com.nsalz.gwt.canvas.create.client.tools.LineStyle;
import com.nsalz.gwt.canvas.create.client.tools.Path;
import com.nsalz.gwt.canvas.create.client.tools.ShadowAttributes;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.TextAttributes;
import com.nsalz.gwt.canvas.create.client.tools.Transform;
import com.nsalz.gwt.canvas.create.client.tools.Graphic.CompositeOperation;
import com.nsalz.gwt.canvas.create.client.tools.Graphic.GraphicTool;
import com.nsalz.gwt.canvas.create.client.tools.Path.PathTool;
import com.nsalz.gwt.canvas.create.client.tools.Shape.ShapeTool;

abstract class AbstractDrawingBoard implements DrawingBoard, GraphicTool, ShapeTool, PathTool
{
    private final Context2d context;
    private final List<Graphic> graphics = new ArrayList<Graphic>();
    private final List<DrawingBoard> childDrawingBoards = new ArrayList<DrawingBoard>();
    
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
        for (Graphic graphic : graphics) {
            context.save();
            graphic.draw(this);
            context.restore();
        }
        for (DrawingBoard drawingBoard : childDrawingBoards) {
            drawingBoard.repaint();
        }
    }

    @Override
    public void onResize()
    {
        repaint();
    }

    private DrawingBoard addDrawingBoard(DrawingBoard drawingBoard)
    {
        childDrawingBoards.add(drawingBoard);
        return drawingBoard;
    }



    /*============
     * 
     * GraphicTool code
     * 
     ==========*/
    
    @Override
    public void applyTransform(Transform transform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void drawImage(CanvasImage image)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fillShape(Shape shape)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fillText(String text)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void revertAttributes()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAlpha(double alpha)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setCompositeOperation(CompositeOperation operation)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setFillStyle(FillStyle fillStyle)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setLineStyle(LineStyle lineStyle)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setShadowAttributes(ShadowAttributes attributes)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTextAttributes(TextAttributes attributes)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void strokeShape(Shape shape)
    {
        context.beginPath();
        shape.applyShape(this);
        context.stroke();
    }

    @Override
    public void strokeText(String text)
    {
        // TODO Auto-generated method stub
        
    }
    
    /*============
     * 
     * ShapeTool code
     * 
     ==========*/

    @Override
    public void applyPath(Path path)
    {
        path.applyPath(this);
    }

    @Override
    public void applyPath(Path path, Transform transform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void applyShape(Shape shape)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void applyShape(Shape shape, Transform transform)
    {
        // TODO Auto-generated method stub
        
    }

    /*============
     * 
     * PathTool code
     * 
     ==========*/

    @Override
    public void arc(double x, double y, double radius, double startAngle, double endAngle, boolean anticlockwise)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void arcTo(double x1, double y1, double x2, double y2, double radius)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lineTo(double x, double y)
    {
        context.lineTo(x, y);
    }

    @Override
    public void moveTo(double x, double y)
    {
        context.moveTo(x, y);
    }

    @Override
    public void quadraticCurveTo(double cpx, double cpy, double x, double y)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void rect(double x, double y, double width, double height)
    {
        // TODO Auto-generated method stub
        
    }

}
