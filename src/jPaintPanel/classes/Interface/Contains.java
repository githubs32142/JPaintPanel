/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
@FunctionalInterface
public interface Contains<T extends Object>  {
   public int contains(List<T> list,double x, double y);
}
