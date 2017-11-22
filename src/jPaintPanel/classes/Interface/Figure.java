
package edu.Interface;

import java.awt.Graphics2D;

public interface Figure {
/**
 ** Metoda do odmalowywania danej figury geometrycznej 
 * @param g2 parametr do rysowania
 */
    public void paint(Graphics2D g2);
/**
 ** Metoda, która sprawdza czy na podanych współrzędnych znajduje się w obiekcie 
 * @param x współrzędna x
 * @param y współrzędna y
 * @return true jeżeli zawiera się false w przeciwnym wypadku
 */
    public boolean contains(double x, double y);
/**
 ** Metoda, która ustawia współrżędne 
 * @param x współrzędna x
 * @param y współrzędna y
 */
    public void setXY(double x, double y);
}
