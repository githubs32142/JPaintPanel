/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;

import edu.Interface.Figure;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Arc implements Figure {

    private double xStart, yStart;
    private double xEnd, yEnd;
    Color color;
    private int id;

    private Arc(Arc.Builder b) {
        xStart = b.xStart;
        xEnd = b.xEnd;
        yStart = b.yStart;
        yEnd = b.yEnd;
        color = b.color;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void paint(Graphics2D g2) {
        Color c = g2.getColor();
        g2.setColor(color);
        Line2D.Double l = new Line2D.Double(xStart, yStart, xEnd, yEnd);
        g2.draw(l);
        drawArc(g2);
        g2.setColor(c);
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
        Color c = g2.getColor();
        double arc = Math.atan2(this.getyEnd() - this.getyStart(), this.getxEnd() - this.getxStart());
        double x = this.getxEnd() - 15 * Math.cos(arc + Math.PI / 6);
        double y = this.getyEnd() - 15 * Math.sin(arc + Math.PI / 6);
        g2.draw(new Line2D.Double(this.getxEnd(), this.getyEnd(), x, y));
        x = this.getxEnd() - 15 * Math.cos(arc - Math.PI / 6);
        y = this.getyEnd() - 15 * Math.sin(arc - Math.PI / 6);
        g2.draw(new Line2D.Double(this.getxEnd(), this.getyEnd(), x, y));
    }

    public static class Builder {

        private double xStart, yStart;
        private double xEnd, yEnd;
        private boolean fill;
        private Color color;

        public Builder setXStart(double x) {
            Builder.this.xStart = x;
            return this;
        }

        public Builder setYStart(double y) {
            Builder.this.yStart = y;
            return this;
        }

        public Builder setXEnd(double xEnd) {
            Builder.this.xEnd = xEnd;
            return this;
        }

        public Builder setYEnd(double yEnd) {
            Builder.this.yEnd = yEnd;
            return this;
        }

        public Builder setColor(Color c) {
            Builder.this.color = c;
            return this;
        }

        public Builder setFill(boolean b) {
            Builder.this.fill = b;
            return this;
        }

        public Arc bulid() {
            return new Arc(this);
        }
    }
}
