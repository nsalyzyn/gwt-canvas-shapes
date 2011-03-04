package com.nsalz.gwt.canvas.create.client.tools;

public interface Graphic
{
    public enum CompositeOperation {}

    public void draw(GraphicTool tool);

    public interface GraphicTool
    {
        public void setAlpha(double alpha);

        public void setCompositeOperation(CompositeOperation operation);

        public void applyTransform(Transform transform);

        public void setTextAttributes(TextAttributes attributes);

        public void setFillStyle(FillStyle fillStyle);

        public void setLineStyle(LineStyle lineStyle);

        public void setShadowAttributes(ShadowAttributes attributes);

        /**
         * Remove all transforms and other settings performed during this draw
         * operation.
         */
        public void revertAttributes();

        /**
         * Fill using the same transform as the shape
         */
        public void fill(Shape shape);

        public void fill(String text);

        /**
         * Fill using the the new transform
         */
        public void fill(Shape shape, Transform transform);

        public void fillWithBaseTransform(Shape shape);

        /**
         * Stroke using the same transform as the shape
         */
        public void stroke(Shape shape);

        public void stroke(String text);

        /**
         * Stroke using the the new transform
         */
        public void stroke(Shape shape, Transform transform);

        public void strokeWithBaseTransform(Shape shape);

        public void drawImage(CanvasImage image);
    }
}
