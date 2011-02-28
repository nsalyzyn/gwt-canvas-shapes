package com.nsalz.gwt.canvas.create.client.tools;

import com.nsalz.gwt.canvas.create.client.shapes.PathShape;

public class ShapeGraphic implements Graphic
{
    private final Shape shape;
    
    public ShapeGraphic(Shape shape)
    {
        this.shape = shape;
    }

    public ShapeGraphic(Path path)
    {
        this.shape = new PathShape<Path>(path);
    }

    @Override
    public void draw(GraphicTool tool)
    {
        tool.strokeShape(shape);
    }

}
