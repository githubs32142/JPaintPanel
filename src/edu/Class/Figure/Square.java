/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Class.Figure;
import edu.Interface.Figure;
import edu.Interface.IChechSquare;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

public class Square implements Serializable,Figure {

    private double width;
    private double x, y;
    private boolean fill;
    public Square( double x, double y,double width) {
        this.width = width;
        this.x = x;
        this.y = y;
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
    
    @Override
    public void paint(Graphics2D g2){
        Rectangle r= new Rectangle((int)getX(), (int)getY(),(int)width, (int)width);
        IChechSquare s;
        s = (boolean b) -> {
            if(!b){
                g2.draw(r);
            }
            else{
                g2.fill(r);
            }
        };
        s.ifsquare(fill);
    }
    
    @Override
    public boolean contains(double x, double y){
        Rectangle r= new Rectangle((int)getX(), (int)getY(),(int)width, (int)width);
        return r.contains(x, y);
    }


}
