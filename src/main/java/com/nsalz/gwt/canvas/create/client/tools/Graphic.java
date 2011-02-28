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
         * operation. This is most useful if you want to remove some transforms
         * before stroking or filling a shape.
         */
        public void revertAttributes();

        public void fillShape(Shape shape);

        public void fillText(String text);

        public void strokeShape(Shape shape);

        public void strokeText(String text);
        
        public void drawImage(CanvasImage image);
    }
}
