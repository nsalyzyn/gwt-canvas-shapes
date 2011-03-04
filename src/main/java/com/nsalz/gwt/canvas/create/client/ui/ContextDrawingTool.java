package com.nsalz.gwt.canvas.create.client.ui;

import com.nsalz.gwt.canvas.create.client.tools.CanvasImage;
import com.nsalz.gwt.canvas.create.client.tools.FillStyle;
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
import com.nsalz.gwt.canvas.create.client.tools.Transform.TransformTool;

class ContextDrawingTool implements GraphicTool, ShapeTool, PathTool, TransformTool
{
    private final Context2d context;

    public ContextDrawingTool(Context2d context)
    {
        this.context = context;
    }

    protected Context2d getContext()
    {
        return context;
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
    public void fill(Shape shape)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fill(String text)
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
    public void stroke(Shape shape)
    {
        context.beginPath();
        shape.applyShape(this);
        context.stroke();
    }

    @Override
    public void stroke(String text)
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void fill(Shape shape, Transform transform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fillWithBaseTransform(Shape shape)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stroke(Shape shape, Transform transform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void strokeWithBaseTransform(Shape shape)
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
        context.save();
        transform.applyTransform(this);
        path.applyPath(this);
        context.restore();
    }

    @Override
    public void applyShape(Shape shape)
    {
        shape.applyShape(this);
    }

    @Override
    public void applyShape(Shape shape, Transform transform)
    {
        context.save();
        transform.applyTransform(this);
        shape.applyShape(this);
        context.restore();
    }

    /*============
     * 
     * PathTool code
     * 
     ==========*/

    @Override
    public void arc(double x, double y, double radius, double startAngle, double endAngle, boolean anticlockwise)
    {
        context.arc(x, y, radius, startAngle, endAngle, anticlockwise);
    }

    @Override
    public void arcTo(double x1, double y1, double x2, double y2, double radius)
    {
        context.arcTo(x1, y1, x2, y2, radius);
    }

    @Override
    public void bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y)
    {
        context.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
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
        context.quadraticCurveTo(cpx, cpy, x, y);
    }

    @Override
    public void rect(double x, double y, double width, double height)
    {
        context.rect(x, y, width, height);
    }

    /*============
     * 
     * TransformTool code
     * 
     ==========*/

    @Override
    public void rotate(double rotations)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void rotateDegrees(double degrees)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void rotateRadians(double angle)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void scale(double x, double y)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void scale(double size)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void transform(double m11, double m12, double m21, double m22, double dx, double dy)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void translate(double x, double y)
    {
        // TODO Auto-generated method stub
        
    }
}
