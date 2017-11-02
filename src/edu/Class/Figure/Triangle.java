/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;

import edu.Interface.Figure;
import edu.Interface.IChechSquare;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Triangle implements Serializable, Figure {

    private double x, y, width, height;
    private boolean fill;
    private List<Point> points = new ArrayList();

    public Triangle(double x, double y, double weight, double height) {
        this.x = x;
        this.y = y;
        this.width = weight;
        this.height = height;
        fill = true;
        points.add(new Point((int) x, (int) y));
        points.add(new Point((int) (x + (this.width / 2)), (int) (y + height)));
        points.add(new Point((int) ((x + this.width)), (int) (y)));
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

    @Override
    public void paint(Graphics2D g2) {
        Polygon p = new Polygon();
        p.addPoint(points.get(0).x, points.get(0).y);
        p.addPoint(points.get(1).x, points.get(1).y);
        p.addPoint(points.get(2).x, points.get(2).y);
        IChechSquare s;
        s = (boolean b) -> {
            if (b) {
                g2.draw(p);
            } else {
                g2.fill(p);
            }
        };
        s.ifsquare(fill);
    }

    @Override
    public boolean contains(double x, double y) {
        points.clear();
        points.add(new Point((int) (x + (this.width / 2)), (int) (y)));
        points.add(new Point((int) x, (int) (y + height)));
        points.add(new Point((int) ((x + this.width)), (int) (y + height)));
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

}
