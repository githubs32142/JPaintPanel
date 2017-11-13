/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;

import edu.Interface.Figure;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import edu.Interface.ICheckFill;

public class Rhomb implements Serializable, Figure {

    private double x, y, width, height;
    private boolean fill;
    List<Point> points = new ArrayList();
    private Color colorFill;
    private Color colorBorder;
    private int id;

    private Rhomb(Rhomb.BuilderRhomb b) {
        this.colorBorder = b.colorBorder;
        this.colorFill = b.colorFill;
        this.width = b.width;
        this.height=b.height;
        this.fill = b.fill;
        setXY(b.x, b.y);

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        setXY(x, this.y);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        setXY(this.x, y);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        setXY(this.x, this.y);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        setXY(this.x, this.y);
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Color getColorFill() {
        return colorFill;
    }

    public void setColorFill(Color colorFill) {
        this.colorFill = colorFill;
    }

    public Color getColorBorder() {
        return colorBorder;
    }

    public void setColorBorder(Color colorBorder) {
        this.colorBorder = colorBorder;
    }

    @Override
    public void paint(Graphics2D g2) {
        Polygon p = new Polygon();
        p.addPoint(points.get(0).x, points.get(0).y);
        p.addPoint(points.get(1).x, points.get(1).y);
        p.addPoint(points.get(2).x, points.get(2).y);
        p.addPoint(points.get(3).x, points.get(3).y);
        ICheckFill s;
        s = (boolean b) -> {
            if (!b) {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(p);
                g2.setColor(col);
                //   System.out.println("dddd");
            } else {
               // Color col = g2.getColor();
                ////g2.setColor(colorBorder);
                //g2.draw(p);
                //g2.setColor(colorFill);
                g2.fill(p);
               // g2.setColor(col);
                System.out.println("tutaj");
            }
        };
        s.ifFill(fill);
    }

    @Override
    public boolean contains(double x, double y) {
        Polygon p = new Polygon();
        p.addPoint(points.get(0).x, points.get(0).y);
        p.addPoint(points.get(1).x, points.get(1).y);
        p.addPoint(points.get(2).x, points.get(2).y);
        p.addPoint(points.get(3).x, points.get(3).y);
        return p.contains(x, y);
    }

    @Override
    public void setXY(double x, double y) {
        double b;
        this.x = x;
        this.y = y;
        points.clear();
        points.add(new Point((int) (x), (int) (y + height)));
        try {//tg(60) = sqrt(3)
            b = this.height / Math.sqrt(3);
            // System.out.println(b);
        } catch (Exception ex) {
            b = 1;
        }
        points.add(new Point((int) (x + b), (int) (y)));
        points.add(new Point((int) (x + b + width), (int) (y)));
        points.add(new Point((int) (x + width), (int) (y + height)));
    }

    public static class BuilderRhomb {

        private double x, y, width, height;
        private boolean fill;
        private Color colorFill;
        private Color colorBorder;

        public BuilderRhomb setX(double x) {
            BuilderRhomb.this.x = x;
            return this;
        }

        public BuilderRhomb setY(double y) {
            BuilderRhomb.this.y = y;
            return this;
        }

        public BuilderRhomb setWidth(double width) {
            BuilderRhomb.this.width = width;
            return this;
        }

        public BuilderRhomb setHeight(double height) {
            BuilderRhomb.this.height = height;
            return this;
        }

        public BuilderRhomb setColorFill(Color c) {
            BuilderRhomb.this.colorFill = c;
            return this;
        }

        public BuilderRhomb setColorBorder(Color c) {
            BuilderRhomb.this.colorBorder = c;
            return this;
        }

        public BuilderRhomb setFill(boolean b) {
            BuilderRhomb.this.fill = b;
            return this;
        }

        public Rhomb bulid() {
            return new Rhomb(this);
        }
    }
}
