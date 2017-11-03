/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;

import edu.Interface.Figure;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Arc implements Figure {

    private double xStart, yStart;
    private double xEnd, yEnd;

    public Arc(double xStart, double yStart, double xEnd, double yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public double getxStart() {
        return xStart;
    }

    public void setxStart(double xStart) {
        this.xStart = xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public void setyStart(double yStart) {
        this.yStart = yStart;
    }

    public double getxEnd() {
        return xEnd;
    }

    public void setxEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public double getyEnd() {
        return yEnd;
    }

    public void setyEnd(double yEnd) {
        this.yEnd = yEnd;
    }

    @Override
    public void paint(Graphics2D g2) {
        Line2D.Double l = new Line2D.Double(xStart, yStart, xEnd, yEnd);
        g2.draw(l);
        drawArc(g2);

    }

    @Override
    public boolean contains(double x, double y) {
        Line2D.Double l = new Line2D.Double(xStart, yStart, xEnd, yEnd);
        double tmpx = x - 4 / 2;
        double tmpy = y - 4 / 2;
        return l.intersects(tmpx, tmpy, 4, 4);
    }

    @Override
    public void setXY(double x, double y) {
        this.xStart = x;
        this.yStart = y;
    }

    private void drawArc(Graphics2D g2) {
        double arc = Math.atan2(this.getyEnd() - this.getyStart(), this.getxEnd() - this.getxStart());
        double x = this.getxEnd() - 15 * Math.cos(arc + Math.PI / 6);
        double y = this.getyEnd() - 15 * Math.sin(arc + Math.PI / 6);
        g2.draw(new Line2D.Double(this.getxEnd(), this.getyEnd(), x, y));
        x = this.getxEnd() - 15 * Math.cos(arc - Math.PI / 6);
        y = this.getyEnd() - 15 * Math.sin(arc - Math.PI / 6);
        g2.draw(new Line2D.Double(this.getxEnd(), this.getyEnd(), x, y));
    }
}
