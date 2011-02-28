package com.nsalz.gwt.canvas.create.client.tools;

public interface Path
{
    public void applyPath(PathTool pathTool);

    public interface PathTool
    {
        public void moveTo(double x, double y);

        public void lineTo(double x, double y);

        public void quadraticCurveTo(double cpx, double cpy, double x, double y);

        public void bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y);

        public void arcTo(double x1, double y1, double x2, double y2, double radius);

        public void arc(double x, double y, double radius, double startAngle, double endAngle, boolean anticlockwise);

        public void rect(double x, double y, double width, double height);
    }
}
