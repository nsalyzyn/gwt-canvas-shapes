package com.nsalz.gwt.canvas.create.client.tools;

import java.util.List;

import com.google.gwt.user.client.ui.RequiresResize;

public interface DrawingLayer<T extends Graphic> extends RequiresResize
{
    public void repaint();

    public boolean isPointIncluded(int x, int y);

    public DrawingLayer<T> getParentDrawingLayer();

    /**
     * This function could be useful if you are using the DrawingLayer classes to group
     * shapes and you want to have some layers.
     */
    public DrawingLayer<T> createChildDrawingLayer();

    public DrawingLayer<T> createChildDrawingLayer(Shape shape);

    public DrawingLayer<T> createChildDrawingLayer(Transform transform);

    public void addGraphic(T graphic);

    /**
     * This returns a live list of graphic objects for this drawing object. This
     * will allow you to do whatever rearranging, removing and adjusting you
     * might need to do.
     */
    public List<T> getGraphicList();
}
