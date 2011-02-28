package com.nsalz.gwt.canvas.create.client.tools;

public class ShadowAttributes
{
    private double offsetX = 0.0;
    private double offsetY = 0.0;
    private double blur = 0.0;
    private String color = "transparent black";

    public double getOffsetX()
    {
        return offsetX;
    }
    public void setOffsetX(double offsetX)
    {
        this.offsetX = offsetX;
    }
    public double getOffsetY()
    {
        return offsetY;
    }
    public void setOffsetY(double offsetY)
    {
        this.offsetY = offsetY;
    }
    public double getBlur()
    {
        return blur;
    }
    public void setBlur(double blur)
    {
        this.blur = blur;
    }
    public String getColor()
    {
        return color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public void setColor(int r, int g, int b)
    {
        setColor("rgb(" + r + "," + g + "," + b + ")");
    }
}
