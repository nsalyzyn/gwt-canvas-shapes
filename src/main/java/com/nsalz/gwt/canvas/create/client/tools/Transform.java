package com.nsalz.gwt.canvas.create.client.tools;

public abstract class Transform
{
    public abstract void applyTransform(TransformTool transformTool);

    /**
     * Applies the transforms in logical order, not necessarily in the order
     * that the javascript context2d would cause it to take effect.
     * setTransform() is intentionally missing since it would reset the stack of
     * transforms on the {@link DrawingLayer}.
     * 
     * @author nsalyzyn
     * 
     */
    public interface TransformTool
    {
        public void scale(double x, double y);

        public void scale(double size);

        public void rotateRadians(double angle);

        public void rotateDegrees(double degrees);

        public void rotate(double rotations);

        public void translate(double x, double y);

        public void transform(double m11, double m12, double m21, double m22, double dx, double dy);
    }

    public final void doTransform(FullTransformTool transformTool)
    {
        transformTool.startTransform();
        applyTransform(transformTool);
        transformTool.endTransform();
    }
    
    public interface FullTransformTool extends TransformTool
    {
        public void startTransform();
        
        public void endTransform();
    }
}
