package com.nsalz.gwt.canvas.create.client.tools;

import com.nsalz.gwt.canvas.create.client.shapes.PathShape;

public class ShapeGraphic implements Graphic
{
    private final Shape shape;
    private final Stroke stroke;
    
    public ShapeGraphic(Shape shape)
    {
        this(shape, new Stroke());
    }

    public ShapeGraphic(Path path)
    {
        this(path, new Stroke());
    }

    public ShapeGraphic(Shape shape, Stroke stroke)
    {
        this.shape = shape;
        this.stroke = stroke;
    }

    public ShapeGraphic(Path path, Stroke stroke)
    {
        this(new PathShape<Path>(path), stroke);
    }

    @Override
    public void draw(GraphicTool tool)
    {
        tool.stroke(shape, stroke);
    }

}
