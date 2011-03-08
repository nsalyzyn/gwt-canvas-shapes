package com.nsalz.gwt.canvas.create.client.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.user.client.Command;
import com.nsalz.gwt.canvas.create.client.tools.CanvasImage;
import com.nsalz.gwt.canvas.create.client.tools.Fill;
import com.nsalz.gwt.canvas.create.client.tools.Path;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.Stroke;
import com.nsalz.gwt.canvas.create.client.tools.TextDraw;
import com.nsalz.gwt.canvas.create.client.tools.Transform;
import com.nsalz.gwt.canvas.create.client.tools.Graphic.GraphicTool;
import com.nsalz.gwt.canvas.create.client.tools.Path.PathTool;
import com.nsalz.gwt.canvas.create.client.tools.Shape.ShapeTool;
import com.nsalz.gwt.canvas.create.client.tools.Transform.FullTransformTool;

class ContextDrawingTool implements GraphicTool, ShapeTool, PathTool, FullTransformTool
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
    public void drawImage(CanvasImage image)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void drawImage(CanvasImage image, Transform transform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fill(Shape shape, Fill fill)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fill(Shape shape, Transform shapeTransform, Fill fill)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fill(Shape shape, Transform shapeTransform, Fill fill, Transform fillTransform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fill(TextDraw text, Fill fill)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fill(TextDraw text, Fill fill, Transform textFillTransform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stroke(Shape shape, Stroke stroke)
    {
        context.save();
        context.beginPath();
        shape.applyShape(this);
        applyStroke(stroke);
        context.stroke();
        context.restore();
    }

    @Override
    public void stroke(Shape shape, Transform shapeTransform, Stroke stroke)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stroke(Shape shape, Transform shapeTransform, Stroke stroke, Transform strokeTransform)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stroke(String text, Stroke stroke)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stroke(String text, Stroke stroke, Transform textStrokeTransform)
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
        transform.doTransform(this);
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
        transform.doTransform(this);
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
     * FullTransformTool code
     * 
     ==========*/
    private int transformDepth = 0;
    private List<Command> transformActions = new ArrayList<Command>();

    @Override
    public void startTransform()
    {
        transformDepth++;
    }

    @Override
    public void endTransform()
    {
        transformDepth--;
        if (transformDepth == 0) {
            for (ListIterator<Command> iterator = transformActions.listIterator(transformActions.size()); iterator.hasPrevious();) {
                iterator.previous().execute();
            }
            transformActions.clear();
        }
    }

    @Override
    public void rotate(double rotations)
    {
        rotateRadians(rotations * Math.PI * 2);
    }

    @Override
    public void rotateDegrees(double degrees)
    {
        rotateRadians(degrees * Math.PI / 180);
    }

    @Override
    public void rotateRadians(final double angle)
    {
        transformActions.add(new Command(){
            @Override
           public void execute()
           {
               context.rotate(angle);
           }
       });
    }

    @Override
    public void scale(final double x, final double y)
    {
        transformActions.add(new Command(){
            @Override
            public void execute()
            {
                context.scale(x, y);
            }
        });
    }

    @Override
    public void scale(double size)
    {
        scale(size, size);
    }

    @Override
    public void transform(final double m11, final double m12, final double m21, final double m22, final double dx, final double dy)
    {
        transformActions.add(new Command(){
            @Override
            public void execute()
            {
                context.transform(m11, m12, m21, m22, dx, dy);
            }
        });
    }

    @Override
    public void translate(final double x, final double y)
    {
        transformActions.add(new Command(){
            @Override
            public void execute()
            {
                context.translate(x, y);
            }
        });
    }

    private void applyStroke(Stroke stroke)
    {
        context.setGlobalAlpha(stroke.getAlpha());
        context.setGlobalCompositeOperation(stroke.getCompositeOperation().getValue());
        context.setLineCap(stroke.getLineStyle().getCap().getValue());
        context.setLineJoin(stroke.getLineStyle().getJoin().getValue());
        context.setLineWidth(stroke.getLineStyle().getWidth());
        context.setShadowOffsetX(stroke.getShadowAttributes().getOffsetX());
        context.setShadowOffsetY(stroke.getShadowAttributes().getOffsetY());
        context.setShadowBlur(stroke.getShadowAttributes().getBlur());
        context.setShadowColor(stroke.getShadowAttributes().getColor());
    }
}
