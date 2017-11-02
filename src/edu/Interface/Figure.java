/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Interface;

import java.awt.Graphics2D;

public interface Figure {

    public void paint(Graphics2D g2);

    public boolean contains(double x, double y);

    public void setXY(double x, double y);
}
