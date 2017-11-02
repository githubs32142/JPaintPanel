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

public class Rhomb implements Serializable, Figure {

    private double x, y, width, height;
    private boolean fill;
    List<Point> points = new ArrayList();

    public Rhomb() {
    }

    public Rhomb(double x, double y, double width, double height) {
        double b;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = false;
        points.add(new Point((int) (x), (int) (y + height)));
        try {//tg(60) = sqrt(3)
            b = this.height / Math.sqrt(3);
        } catch (Exception ex) {
            b = 1;
        }
        points.add(new Point((int) (x + b), (int) (y)));
        points.add(new Point((int) (x + b + width), (int) (y)));
        points.add(new Point((int) (x - b + width), (int) (y + height)));
        
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
        setXY(this.x,this.y);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        setXY(this.x,this.y);
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public void paint(Graphics2D g2) {
        Polygon p = new Polygon();
        p.addPoint(points.get(0).x, points.get(0).y);
        p.addPoint(points.get(1).x, points.get(1).y);
        p.addPoint(points.get(2).x, points.get(2).y);
        p.addPoint(points.get(3).x, points.get(3).y);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setXY(double x, double y) {
        double b;
        this.x = x;
        this.y = y;
        this.fill = false;
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
        points.add(new Point((int) (x  + width), (int) (y + height)));
    }

}
