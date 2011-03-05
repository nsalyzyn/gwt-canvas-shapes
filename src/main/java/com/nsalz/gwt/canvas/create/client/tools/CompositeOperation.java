package com.nsalz.gwt.canvas.create.client.tools;

public enum CompositeOperation {
    SOURCE_OVER("source-over");
    
    private String value;
    private CompositeOperation(String value)
    {
        this.value = value;
    }
    
    public String getValue()
    {
        return value;
    }
}
