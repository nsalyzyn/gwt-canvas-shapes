package com.nsalz.gwt.canvas.create.client.tools;

public interface Shape
{
    public void applyShape(ShapeTool shapeTool);

    public interface ShapeTool
    {
        public void applyPath(Path path);

        public void applyPath(Path path, Transform transform);

        /**
         * It is certainly possible to create an infinite loop using this method.  Be careful.
         */
        public void applyShape(Shape shape);

        public void applyShape(Shape shape, Transform transform);
    }
}
