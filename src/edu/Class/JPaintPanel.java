package edu.Class;

import edu.Class.Figure.Line;
import edu.Class.Figure.Rhomb;
import edu.Class.Figure.Triangle;
import edu.Class.Figure.Square;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import edu.Interface.ContainsSquare;

public class JPaintPanel extends JPanel {

    private Square drawSquare = new Square(0, 0, 0);
    private Triangle drawTriangle = new Triangle(0, 0, 0, 0);
    private Rhomb drawRhomb = new Rhomb(0, 0, 0, 0);
    private Line drawLine = new Line(0,0,0,0);
    List<Square> square = new ArrayList<>();
    List<Triangle> triangles = new ArrayList<>();
    List<Line> lines = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2D.setRenderingHints(rh);
        square.forEach((square1) -> {
            square1.paint(g2D);
        });
        triangles.forEach((t)->{
        t.paint(g2D);
        });
        lines.forEach((l)->{
            l.paint(g2D);
        });
        if (drawSquare != null) {
            drawSquare.paint(g2D);
        }
        if (drawTriangle != null) {
            drawTriangle.paint(g2D);
        }
        if (drawRhomb != null) {
            drawRhomb.paint(g2D);
        }
        
    }

    public void addSquare(double x, double y, double width) {
        square.add(new Square(width, x, y));
    }

    public void addSquare(double x, double y, double width, boolean fill) {
        square.add(new Square(width, x, y));
        square.get(square.size() - 1).setFill(fill);
    }
    public void addSquare(Square s) {
        square.add(s);
    }
    public void addTrinagle(double x, double y, double weight, double height) {
        triangles.add(new Triangle(x, y, weight, height));
    }
    
    public void addTrinagle(double x, double y, double width, double height, boolean fill) {
        triangles.add(new Triangle(x, y, width, height));
        triangles.get(triangles.size() - 1).setFill(fill);
    }
    /**
     ** Metoda która ustawia wypełnienie podanego kwadratu
     *
     * @param i indeks kwadratu
     * @param fill ustawienia wypełnienia
     */
    public void setFillSquare(int i, boolean fill) {
        if (i >= 0 && i < square.size()) {
            square.get(i).setFill(fill);
        }
    }

    private int returnIndexSquare(double x, double y) {
        ContainsSquare c = (List<Square> list, double x1, double y1) -> {
            for (int i = 0; i < list.size(); i++) {
                Square s = (Square) list.get(i);
                if (list.get(i).contains(x, y)) {
                    return i;
                }
            }
            return -1;
        };
        return c.contains(square, x, y);
    }

    public int returnIndexdrawTriangle(double x, double y) {
        edu.Interface.ContainsTriangle t = (List<Triangle> list, double x1, double y1) -> {
            for (int i = 0; i < list.size(); i++) {
                Triangle s = (Triangle) list.get(i);
                if (list.get(i).contains(x1, y1)) {
                    return i;
                }
            }
            return -1;
        };
        return t.contains(triangles, x, y);
    }

    public Square getDrawSquare() {
        return drawSquare;
    }

    public void setDrawSquare(Square drawSquare) {
        this.drawSquare = drawSquare;
        repaint();
    }

    public Triangle getDrawTriangle() {
        return drawTriangle;
    }

    public void setDrawTriangle(Triangle drawTriangle) {
        this.drawTriangle = drawTriangle;
    }

    public Rhomb getDrawRhomb() {
        return drawRhomb;
    }

    public void setDrawRhomb(Rhomb drawRhomb) {
        this.drawRhomb = drawRhomb;
    }

    public Line getDrawLine() {
        return drawLine;
    }

    public void setDrawLine(Line drawLine) {
        this.drawLine = drawLine;
    }
    public WhatClicked whatFigureClicked(double x, double y){
        int tmp= returnIndexSquare(x, y);
        WhatClicked wC = new WhatClicked(-1,"");
        if(tmp>=0){
            wC.setId(tmp);
            wC.setType("square");
        }
        return wC;
    }
}
