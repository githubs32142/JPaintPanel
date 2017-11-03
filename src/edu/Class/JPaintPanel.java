package edu.Class;

import edu.Class.Figure.Arc;
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
import java.util.function.Consumer;

public class JPaintPanel extends JPanel {

    private Square drawSquare = new Square(0, 0, 0);
    private Triangle drawTriangle = new Triangle(0, 0, 0, 0);
    private Rhomb drawRhomb = new Rhomb(0, 0, 0, 0);
    private Line drawLine = new Line(0, 0, 0, 0);
    List<Square> square = new ArrayList<>();
    List<Triangle> triangles = new ArrayList<>();
    List<Line> lines = new ArrayList<>();
    List<Arc> arcs = new ArrayList<>();
    List<Rhomb> rhombs = new ArrayList<>();

    /**
     ** Metoda, która odmalowywuje komponent
     *
     * @param g parametr którym rysujemy na komponencie
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2D.setRenderingHints(rh);
        square.stream().forEach((square1) -> {
            square1.paint(g2D);
        });
        triangles.stream().forEach((t) -> {
            t.paint(g2D);
        });
        lines.stream().forEach((l) -> {
            l.paint(g2D);
        });
        arcs.forEach((a) -> {
            a.paint(g2D);
        });
        rhombs.forEach((t) -> {
            t.paint(g2D);
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

    /**
     ** Metoda, która dodaje kwasrat
     *
     * @param x -współrzędna x
     * @param y - współrzędna y
     * @param width - szerokość
     */
    public void addSquare(double x, double y, double width) {
        square.add(new Square(width, x, y));
    }

    /**
     ** Metoda, która dodaje kwadrat
     *
     * @param x - współrzędna x
     * @param y - współrzędna y
     * @param width - szerokość
     * @param fill - wypełnienie
     */
    public void addSquare(double x, double y, double width, boolean fill) {
        square.add(new Square(width, x, y));
        square.get(square.size() - 1).setFill(fill);
    }

    /**
     ** Metoda, która dodaje kwadrat
     *
     * @param s kwadrat
     */
    private void addSquare(Square s) {
        square.add(s);
    }

    /**
     ** Metoda, która dodaje trójkąt
     *
     * @param x - współrzędna x
     * @param y - współrzędna y
     * @param weight - szerokość
     * @param height - wysokość
     */
    public void addTrinagle(double x, double y, double weight, double height) {
        triangles.add(new Triangle(x, y, weight, height));
    }

    /**
     ** Metoda, która dodaje trójkąt
     *
     * @param x - współrzędna x
     * @param y - współrzędna y
     * @param width - szerokość
     * @param height - wysokość
     * @param fill wypełnienie
     */
    public void addTrinagle(double x, double y, double width, double height, boolean fill) {
        triangles.add(new Triangle(x, y, width, height));
        triangles.get(triangles.size() - 1).setFill(fill);
    }

    /**
     ** Metoda, która dodaje trójkąt
     *
     * @param t zmienna typu Triangle
     */
    private void addTrinagle(Triangle t) {
        triangles.add(t);
    }

    /**
     ** Metoda, która dodaje romb
     *
     * @param r zminna typu Rhomb
     */
    private void addRhomb(Rhomb r) {
        rhombs.add(r);
    }

    /**
     ** Metoda, która dodaje linie
     *
     * @param l zmienna typu Line
     */
    private void addLines(Line l) {
        lines.add(l);
    }

    private void addArc(Arc a) {
        arcs.add(a);
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

    /**
     ** metoda która zwraca index kwadratu o podanych współrzędnych. Zwraca -1
     * jeżeli współrzędne nie znajdują się w żadnym miejscu
     *
     * @param x współrzędna x
     * @param y współrzędna y
     * @return index kwadratu jeżeli >=0 . jeżeli -1 to nie zawiera się
     */
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

    /**
     ** metoda która zwraca index trójkąta o podanych współrzędnych. Zwraca -1
     * jeżeli współrzędne nie znajdują się w żadnym miejscu
     *
     * @param x współrzędna x
     * @param y współrzędna y
     * @return index trójkąta jeżeli >=0 . jeżeli -1 to nie zawiera się
     */
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

    public WhatClicked whatFigureClicked(double x, double y) {
        int tmp = returnIndexSquare(x, y);
        WhatClicked wC = new WhatClicked(-1, "");
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("square");
        }
        return wC;
    }

    /**
     ** Metoda, która dodaje obiekt
     * @param typeObj typ obiektu
     * @param t obiekt
     */
    public void addObject(String typeObj, Object t) {
        if ("square".equals(typeObj)) {
            addSquare((Square) t);
        }
        if ("triangle".equals(typeObj)) {
            addTrinagle((Triangle) t);
        }
        if ("rhomb".equals(typeObj)) {
            addRhomb((Rhomb) t);
        }
        if ("arc".equals(typeObj)) {
            addArc((Arc) t);
        }
        if ("line".equals(typeObj)) {
            addLines((Line) t);
        }

    }
}
