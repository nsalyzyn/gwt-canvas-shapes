package com.nsalz.gwt.canvas.create.client.tools;

public class Stroke
{
    private double alpha = 1.0;
    private CompositeOperation compositeOperation = CompositeOperation.SOURCE_OVER;
    private LineStyle lineStyle = new LineStyle();
    private ShadowAttributes shadowAttributes = new ShadowAttributes();
    
    public double getAlpha()
    {
        return alpha;
    }

    public CompositeOperation getCompositeOperation()
    {
        return compositeOperation;
    }

    public LineStyle getLineStyle()
    {
        return lineStyle;
    }

    public ShadowAttributes getShadowAttributes()
    {
        return shadowAttributes;
    }

    public void setAlpha(double alpha)
    {
        this.alpha = alpha;
    }

    public void setCompositeOperation(CompositeOperation compositeOperation)
    {
        this.compositeOperation = compositeOperation;
    }

    public void setLineStyle(LineStyle lineStyle)
    {
        this.lineStyle = lineStyle;
    }

    public void setShadowAttributes(ShadowAttributes shadowAttributes)
    {
        this.shadowAttributes = shadowAttributes;
    }
}
