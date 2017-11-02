/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Interface;

import edu.Class.Figure.Square;
import java.util.List;

/**
 *
 * @author Admin
 */
@FunctionalInterface
public interface ContainsSquare {
    public int contains(List<Square> list,double x, double y);
}
