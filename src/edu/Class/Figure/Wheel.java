/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;

import edu.Interface.Figure;
import edu.Interface.ICheckFill;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Wheel implements Figure, Serializable {

    private double x, y, radius;
    private boolean fill;
    private Color colorFill;
    private Color colorBorder;
    private int id;
    private Wheel(Wheel.Builder b) {
        this.colorBorder = b.colorBorder;
        this.colorFill = b.colorFill;
        this.radius = b.radius;
        this.x = b.x;
        this.y = b.y;
        this.fill=b.fill;

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void paint(Graphics2D g2) {
        ICheckFill s;
        s = (boolean b) -> {
            if (!b) {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(new Ellipse2D.Double(x, y,
                        radius,
                        radius));
                g2.setColor(col);
            } else {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(new Ellipse2D.Double(x, y,
                        radius,
                        radius));
                g2.setColor(colorFill);
                g2.fill(new Ellipse2D.Double(x, y,
                        radius,
                        radius));
                g2.setColor(col);
            }
        };
        s.ifFill(fill);
    }

    @Override
    public boolean contains(double x, double y) {
        return new Ellipse2D.Double(this.x, this.y, radius, radius).contains(x, y);
    }

    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Builder {

        private double x, y, radius;
        private boolean fill;
        private Color colorFill;
        private Color colorBorder;

        public Builder setX(double x) {
            Builder.this.x = x;
            return this;
        }

        public Builder setY(double y) {
            Builder.this.y = y;
            return this;
        }

        public Builder setRadius(double rad) {
            Builder.this.radius = rad;
            return this;
        }

        public Builder setColorFill(Color c) {
            Builder.this.colorFill = c;
            return this;
        }

        public Builder setColorBorder(Color c) {
            Builder.this.colorBorder = c;
            return this;
        }

        public Builder setFill(boolean b) {
            Builder.this.fill = b;
            return this;
        }

        public Wheel bulid() {
            return new Wheel(this);
        }
    }
}
