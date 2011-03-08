package com.nsalz.gwt.canvas.create.client.tools;

public enum CompositeOperation {
    SOURCE_OVER("source-over"), SOURCE_IN("source-in"), SOURCE_OUT("source-out"), SOURCE_ATOP("source-atop"),
    DESTINATION_OVER("destination-over"), DESTINATION_IN("destination-in"), DESTINATION_OUT("destination-out"),
    DESTINATION_ATOP("destination-atop"), LIGHTER("lighter"), COPY("copy"), XOR("xor");
    
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
