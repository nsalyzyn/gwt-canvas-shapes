package com.nsalz.gwt.canvas.create.client.shapes;

import com.nsalz.gwt.canvas.create.client.tools.Path;
import com.nsalz.gwt.canvas.create.client.tools.Shape;

public class PathShape<T extends Path> implements Shape
{
    private final T path;
    
    public PathShape(T path)
    {
        this.path = path;
    }

    @Override
    public void applyShape(ShapeTool shapeTool)
    {
        shapeTool.applyPath(path);
    }

}
