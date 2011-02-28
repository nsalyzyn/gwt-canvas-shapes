package com.nsalz.gwt.canvas.create.client.tools;

import com.google.gwt.user.client.ui.RequiresResize;

public interface DrawingBoard extends RequiresResize
{
    public void repaint();

    public boolean isPointIncluded(int x, int y);

    public DrawingBoard getParentDrawingBoard();

    /**
     * This function could be useful if you are using the DrawingBoards to group
     * shapes and you want to have some layers.
     */
    public DrawingBoard createChildDrawingBoard();

    public DrawingBoard createChildDrawingBoard(Shape shape);

    public DrawingBoard createChildDrawingBoard(Transform transform);
    
    public void addGraphic(Graphic graphic);
}
