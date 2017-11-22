/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.Figure;

import edu.Interface.Figure;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import edu.Interface.ICheckFill;
import java.awt.geom.Rectangle2D;

public class Square implements Serializable, Figure {

    private double width;
    private double x, y;
    private boolean fill;
    private Color colorFill;
    private Color colorBorder;
    private int id;

    private Square(Square.BuilderSquare b) {
        this.colorBorder = b.colorBorder;
        this.colorFill = b.colorFill;
        this.width = b.width;
        this.fill=b.fill;
        setXY(b.x, b.y);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setXY(double x, double y) {
        this.x = x;
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
    public void paint(Graphics2D g2) {
        Rectangle r = new Rectangle((int) getX(), (int) getY(), (int) width, (int) width);
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
    public void drawBorder(Graphics2D g2D){
        Rectangle2D rc= new Rectangle2D.Double(x-10,y-10,width+20,width+20);
        g2D.draw(rc);
    }
    @Override
    public boolean contains(double x, double y) {
        Rectangle r = new Rectangle((int) getX(), (int) getY(), (int) width, (int) width);
        return r.contains(x, y);
    }

    public static class BuilderSquare {

        private double x, y, width;
        private boolean fill;
        private Color colorFill;
        private Color colorBorder;

        public BuilderSquare setX(double x) {
            BuilderSquare.this.x = x;
            return this;
        }

        public BuilderSquare setY(double y) {
            BuilderSquare.this.y = y;
            return this;
        }

        public BuilderSquare setWidth(double width) {
            BuilderSquare.this.width = width;
            return this;
        }

        public BuilderSquare setColorFill(Color c) {
            BuilderSquare.this.colorFill = c;
            return this;
        }

        public BuilderSquare setColorBorder(Color c) {
            BuilderSquare.this.colorBorder = c;
            return this;
        }

        public BuilderSquare setFill(boolean b) {
            BuilderSquare.this.fill = b;
            return this;
        }

        public Square bulid() {
            return new Square(this);
        }
    }
}
