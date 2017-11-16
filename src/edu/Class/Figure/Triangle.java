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

public class Triangle implements Serializable, Figure {

    private double x, y, width, height;
    private boolean fill;
    private List<Point> points = new ArrayList();
    private Color colorFill;
    private Color colorBorder;
    private int id;

    private Triangle(Triangle.BuilderTriangle b) {
        this.colorBorder = b.colorBorder;
        this.colorFill = b.colorFill;
        this.height = b.height;
        this.width = b.width;
        this.fill = b.fill;
        setXY(b.x, b.y);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double x) {
        setXY(x, this.y);
    }

    public void setY(double y) {
        this.y = y;
        setXY(this.x, y);
    }

    public void setHeight(double height) {
        this.height = height;
        this.setXY(x, y);
    }

    public void setWidth(double weight) {
        this.width = weight;
        this.setXY(x, y);
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public boolean isFill() {
        return fill;
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
        ICheckFill s;
        s = (boolean b) -> {
            if (!b) {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(p);
                g2.setColor(col);
            } else {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(p);
                g2.setColor(colorFill);
                g2.fill(p);
                g2.setColor(col);
            }
        };
        s.ifFill(fill);
    }

    @Override
    public boolean contains(double x, double y) {
        points.clear();
        points.add(new Point((int) this.x, (int) (this.y + height)));
        points.add(new Point((int) (this.x + (this.width / 2)), (int) (this.y)));
        points.add(new Point((int) ((this.x + this.width)), (int) (this.y + height)));
        Polygon p = new Polygon();
        p.addPoint(points.get(0).x, points.get(0).y);
        p.addPoint(points.get(1).x, points.get(1).y);
        p.addPoint(points.get(2).x, points.get(2).y);
        return p.contains(x, y);
    }

    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
        points.clear();
        points.add(new Point((int) (x + (this.width / 2)), (int) (y)));
        points.add(new Point((int) x, (int) (y + height)));
        points.add(new Point((int) ((x + this.width)), (int) (y + height)));
    }

    public static class BuilderTriangle {

        private double x, y, width, height;
        private boolean fill;
        private Color colorFill;
        private Color colorBorder;

        public BuilderTriangle setX(double x) {
            BuilderTriangle.this.x = x;
            return this;
        }

        public BuilderTriangle setY(double y) {
            BuilderTriangle.this.y = y;
            return this;
        }

        public BuilderTriangle setWidth(double width) {
            BuilderTriangle.this.width = width;
            return this;
        }

        public BuilderTriangle setHeight(double height) {
            BuilderTriangle.this.height = height;
            return this;
        }

        public BuilderTriangle setColorFill(Color c) {
            BuilderTriangle.this.colorFill = c;
            return this;
        }

        public BuilderTriangle setColorBorder(Color c) {
            BuilderTriangle.this.colorBorder = c;
            return this;
        }

        public BuilderTriangle setFill(boolean b) {
            BuilderTriangle.this.fill = b;
            return this;
        }

        public Triangle bulid() {
            return new Triangle(this);
        }
    }
}
