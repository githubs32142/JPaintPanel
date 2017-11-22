/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.Figure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Line implements Serializable, edu.Interface.Figure {

    private double xStart, yStart;
    private double xEnd, yEnd;
    private Color color;
    private int id;

    private Line(Line.Builder b) {
        this.color = b.color;
        this.xStart = b.xStart;
        this.yStart = b.yStart;
        this.yEnd = b.yEnd;
        this.xEnd = b.xEnd;
        
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
        Color c= g2.getColor();
        g2.setColor(color);
        g2.draw(l);
        g2.setColor(c);
    }
    public void drawBorder(Graphics2D g2D){
        double width= xEnd-xStart;
        double height= yEnd-yStart;
        Rectangle2D rc= new Rectangle2D.Double(xStart-10,yStart,width+20,height+20);
        g2D.draw(rc);
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        public Line bulid() {
            return new Line(this);
        }
    }
}
