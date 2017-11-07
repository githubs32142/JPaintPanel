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

}
