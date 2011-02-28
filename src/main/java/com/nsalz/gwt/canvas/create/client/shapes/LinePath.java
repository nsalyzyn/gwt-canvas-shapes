package com.nsalz.gwt.canvas.create.client.shapes;

import com.nsalz.gwt.canvas.create.client.tools.Path;

public class LinePath implements Path
{
    private double x1, y1, x2, y2;
    
    public LinePath(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void applyPath(PathTool pathTool)
    {
        pathTool.moveTo(x1, y1);
        pathTool.lineTo(x2, y2);
    }

    public double getX1()
    {
        return x1;
    }

    public void setX1(double x1)
    {
        this.x1 = x1;
    }

    public double getY1()
    {
        return y1;
    }

    public void setY1(double y1)
    {
        this.y1 = y1;
    }

    public double getX2()
    {
        return x2;
    }

    public void setX2(double x2)
    {
        this.x2 = x2;
    }

    public double getY2()
    {
        return y2;
    }

    public void setY2(double y2)
    {
        this.y2 = y2;
    }

}