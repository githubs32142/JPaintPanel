/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;

import edu.Interface.IChechSquare;
import java.awt.Graphics2D;


public class Rectangle { 
    private double width,height;
    private double x, y;
    private boolean fill;

    public Rectangle(double x, double y,double width,double height) {
        this.width = width;
        this.x = x;
        this.y = y;
        this.height=height;
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
        public void paintRectangle(Graphics2D g2){
        java.awt.Rectangle r= new java.awt.Rectangle((int)getX(), (int)getY(),(int)width, (int)height);
        IChechSquare s;
        s = (boolean b) -> {
            if(b){
                g2.draw(r);
            }
            else{
                g2.fill(r);
            }
        };
        s.ifsquare(fill);
    }
    public boolean contains(double x, double y){
        java.awt.Rectangle r= new java.awt.Rectangle((int)getX(), (int)getY(),(int)width, (int)height);
        return r.contains(x, y);
    }
}
