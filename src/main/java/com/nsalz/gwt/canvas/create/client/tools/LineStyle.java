package com.nsalz.gwt.canvas.create.client.tools;

public class LineStyle
{
    public enum Cap {
        BUTT("butt"), ROUND("round"), SQUARE("square");
        private String value;
        private Cap(String value) { this.value = value; }
        public String getValue() { return value; }
    };
    public enum Join {
        ROUND("round"), BEVEL("bevel"), MITER("miter");
        private String value;
        private Join(String value) { this.value = value; }
        public String getValue() { return value; }
    };
    
    private double width = 1.0;
    private Cap cap = Cap.BUTT;
    private Join join = Join.MITER;
    private double miterLimit = 10.0;
    
    public double getWidth()
    {
        return width;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public Cap getCap()
    {
        return cap;
    }
    public void setCap(Cap cap)
    {
        this.cap = cap;
    }
    public Join getJoin()
    {
        return join;
    }
    public void setJoin(Join join)
    {
        this.join = join;
    }
    public double getMiterLimit()
    {
        return miterLimit;
    }
    public void setMiterLimit(double miterLimit)
    {
        this.miterLimit = miterLimit;
    }
}
