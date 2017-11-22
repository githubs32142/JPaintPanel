/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.Figure;

import edu.Interface.Figure;
import java.awt.Color;
import java.awt.Graphics2D;
import edu.Interface.ICheckFill;
import java.awt.geom.Rectangle2D;

public class Rectangle implements Figure {

    private double width, height;
    private double x, y;
    private boolean fill;
    private Color colorFill;
    private Color colorBorder;
private int id;
    private Rectangle(Rectangle.Builder b) {
        this.colorBorder = b.colorBorder;
        this.colorFill = b.colorFill;
        this.width = b.width;
        this.x = b.x;
        this.y = b.y;
        this.fill=b.fill;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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
    public boolean contains(double x, double y) {
        java.awt.Rectangle r = new java.awt.Rectangle((int) getX(), (int) getY(), (int) width, (int) height);
        return r.contains(x, y);
    }

    @Override
    public void paint(Graphics2D g2) {
        java.awt.Rectangle r = new java.awt.Rectangle((int) getX(), (int) getY(), (int) width, (int) height);
        ICheckFill s;
        s = (boolean b) -> {
            if (!b) {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(r);
                g2.setColor(col);
            } else {
                Color col = g2.getColor();
                g2.setColor(colorBorder);
                g2.draw(r);
                g2.setColor(colorFill);
                g2.fill(r);
                g2.setColor(col);
            }
        };
        s.ifFill(fill);
    }

    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void drawBorder(Graphics2D g2D){
        Rectangle2D rc= new Rectangle2D.Double(x-10,y-10,width+20,height+20);
        g2D.draw(rc);
    }
    public static class Builder {

        private double x, y, width, height;
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

        public Builder setWidth(double width) {
            Builder.this.width = width;
            return this;
        }

        public Builder setHeight(double height) {
            Builder.this.height = height;
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

        public Rectangle bulid() {
            return new Rectangle(this);
        }
    }
}
