package com.nsalz.gwt.canvas.create.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Command;
import com.nsalz.gwt.canvas.create.client.FrameRateScheduler;
import com.nsalz.gwt.canvas.create.client.tools.DrawingLayer;
import com.nsalz.gwt.canvas.create.client.tools.Graphic;
import com.nsalz.gwt.canvas.create.client.tools.Shape;
import com.nsalz.gwt.canvas.create.client.tools.Transform;

abstract class AbstractDrawingLayer<T extends Graphic> extends ContextDrawingTool implements DrawingLayer<T>
{
    private final List<T> graphics = new ArrayList<T>();
    private final List<AbstractDrawingLayer<T>> childLayers = new ArrayList<AbstractDrawingLayer<T>>();
    private final Command repaintCommand = new Command(){
        @Override
        public void execute()
        {
            doRepaint();
        }
    };
    
    public AbstractDrawingLayer(Context2d context)
    {
        super(context);
    }
    
    @Override
    public DrawingLayer<T> createChildDrawingLayer()
    {
        return addLayer(new ChildDrawingLayer<T>(this));
    }

    @Override
    public DrawingLayer<T> createChildDrawingLayer(Shape shape)
    {
        return addLayer(new ChildDrawingLayer.ShapedLayer<T>(this, shape));
    }

    @Override
    public DrawingLayer<T> createChildDrawingLayer(Transform transform)
    {
        return addLayer(new ChildDrawingLayer.TransformedLayer<T>(this, transform));
    }
    
    @Override
    public void addGraphic(T graphic)
    {
        graphics.add(graphic);
    }
    
    @Override
    public List<T> getGraphicList()
    {
        return graphics;
    }

    @Override
    public void repaint()
    {
        FrameRateScheduler.get().addToNextFrame(repaintCommand);
    }
    
    protected void doRepaint()
    {
        for (Graphic graphic : graphics) {
            getContext().save();
            graphic.draw(this);
            getContext().restore();
        }
        for (AbstractDrawingLayer<T> layer : childLayers) {
            layer.doRepaint();
        }
    }

    @Override
    public void onResize()
    {
        repaint();
    }

    private DrawingLayer<T> addLayer(AbstractDrawingLayer<T> layer)
    {
        childLayers.add(layer);
        return layer;
    }



}
