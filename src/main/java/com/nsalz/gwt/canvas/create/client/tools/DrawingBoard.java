package com.nsalz.gwt.canvas.create.client.tools;

import java.util.List;

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

    /**
     * This returns a live list of graphic objects for this drawing object. This
     * will allow you to do whatever rearranging, removing and adjusting you
     * might need to do.
     */
    public List<Graphic> getGraphicList();
}
