package com.nsalz.gwt.canvas.create.client.tools;

public interface Graphic
{
    public void draw(GraphicTool tool);

    public interface GraphicTool
    {
        public void fill(Shape shape, Fill fill);

        public void fill(Shape shape, Transform shapeTransform, Fill fill);

        public void fill(Shape shape, Transform shapeTransform, Fill fill, Transform fillTransform);

        public void fill(TextDraw text, Fill fill);

        public void fill(TextDraw text, Fill fill, Transform textFillTransform);

        public void stroke(Shape shape, Stroke stroke);

        public void stroke(Shape shape, Transform shapeTransform, Stroke stroke);

        public void stroke(Shape shape, Transform shapeTransform, Stroke stroke, Transform strokeTransform);

        public void stroke(String text, Stroke stroke);

        public void stroke(String text, Stroke stroke, Transform textStrokeTransform);

        public void drawImage(CanvasImage image);

        public void drawImage(CanvasImage image, Transform transform);
    }
}
