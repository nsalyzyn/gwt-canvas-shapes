package com.nsalz.gwt.canvas.create.client.tools;

public class TextAttributes
{
    public enum Alignment { START, END, LEFT, RIGHT, CENTER };
    public enum Baseline { TOP, HANGING, MIDDLE, ALPHABETIC, IDEOGRAPHIC, BOTTOM };
    
    private String font = "10px sans-serif";
    private Alignment alignment = Alignment.START;
    private Baseline baseline = Baseline.ALPHABETIC;
    
    public String getFont()
    {
        return font;
    }
    public void setFont(String font)
    {
        this.font = font;
    }
    public Alignment getAlignment()
    {
        return alignment;
    }
    public void setAlignment(Alignment alignment)
    {
        this.alignment = alignment;
    }
    public Baseline getBaseline()
    {
        return baseline;
    }
    public void setBaseline(Baseline baseline)
    {
        this.baseline = baseline;
    }
}
