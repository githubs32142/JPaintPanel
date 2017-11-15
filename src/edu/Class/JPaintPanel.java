package edu.Class;

import edu.Class.Figure.Arc;
import edu.Class.Figure.Line;
import edu.Class.Figure.Rhomb;
import edu.Class.Figure.Triangle;
import edu.Class.Figure.Square;
import edu.Class.Figure.Wheel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import edu.Interface.ContainsSquare;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JPaintPanel extends JPanel {

    private Square drawSquare;
    private Triangle drawTriangle;
    private Rhomb drawRhomb;
    private Line drawLine;
    private Wheel drawWheel;
    private Arc drawArc;
    List<Square> square = new ArrayList<>();
    List<Triangle> triangles = new ArrayList<>();
    List<Line> lines = new ArrayList<>();
    List<Arc> arcs = new ArrayList<>();
    List<Rhomb> rhombs = new ArrayList<>();
    List<Wheel> wheel = new ArrayList<>();
    private BufferedImage paintImage;

    public void wipe(){
        square.clear();
        triangles.clear();
        lines.clear();
        arcs.clear();
        rhombs.clear();
        wheel.clear();
    }
    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
    }
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
        if (imageIsNull()) {
            g2D.drawImage(paintImage, 0, 0, null);
        }
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
        wheel.forEach((Wheel t) -> {
            t.paint(g2D);
        });
        if (squareIsNotNull()) {
            drawSquare.paint(g2D);
        }
        if (triangleIsNotNull()) {
            drawTriangle.paint(g2D);
        }
        if (rhombIsNotNull()) {
            drawRhomb.paint(g2D);
        }
        if (lineIsNotNull()) {
            drawLine.paint(g2D);
        }
        if (arcIsNotNull()) {
            drawArc.paint(g2D);
        }
        if (wheelIsNull()) {
            drawWheel.paint(g2D);
        }
    }

    private boolean wheelIsNull() {
        return drawWheel != null;
    }

    private void addWheel(Wheel w) {
        wheel.add(w);
    }

    private boolean arcIsNotNull() {
        return drawArc != null;
    }

    private boolean lineIsNotNull() {
        return drawLine != null;
    }

    private boolean rhombIsNotNull() {
        return drawRhomb != null;
    }

    private boolean triangleIsNotNull() {
        return drawTriangle != null;
    }

    private boolean squareIsNotNull() {
        return drawSquare != null;
    }

    private boolean imageIsNull() {
        return paintImage != null;
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
        if (containsInSquare(i) && i < square.size()) {
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

    public Arc getDrawArc() {
        return drawArc;
    }

    public void setDrawArc(Arc drawArc) {
        this.drawArc = drawArc;
    }

    public WhatClicked whatFigureClicked(double x, double y) {
        int tmp = returnIndexSquare(x, y);
        WhatClicked wC = new WhatClicked(-1, "");
        if (containsInSquare(tmp)) {
            wC.setId(tmp);
            wC.setType("square");
        }
        return wC;
    }

    private static boolean containsInSquare(int tmp) {
        return tmp >= 0;
    }

    /**
     ** Metoda, która dodaje obiekt
     *
     * @param typeObj typ obiektu
     * @param t obiekt
     */
    public void addObject(String typeObj, Object t) {
        if (isSquareType(typeObj)) {
            addSquare((Square) t);
        }
        if (isTriangleType(typeObj)) {
            addTrinagle((Triangle) t);
        }
        if (isRhombType(typeObj)) {
            addRhomb((Rhomb) t);
        }
        if (isArcType(typeObj)) {
            addArc((Arc) t);
        }
        if (isLine(typeObj)) {
            addLines((Line) t);
        }
        if (isWheelType(typeObj)) {
            addWheel((Wheel) t);
        }

    }

    private static boolean isWheelType(String typeObj) {
        return "wheel".equals(typeObj);
    }

    private static boolean isLine(String typeObj) {
        return "line".equals(typeObj);
    }

    private static boolean isArcType(String typeObj) {
        return "arc".equals(typeObj);
    }

    private static boolean isRhombType(String typeObj) {
        return "rhomb".equals(typeObj);
    }

    private static boolean isTriangleType(String typeObj) {
        return "triangle".equals(typeObj);
    }

    private static boolean isSquareType(String typeObj) {
        return "square".equals(typeObj);
    }

    public void loadImage(File file) throws IOException {
        paintImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        paintImage = ImageIO.read(file);
        repaint();
    }

    public Wheel getDrawWheel() {
        return drawWheel;
    }

    public void setDrawWheel(Wheel drawWheel) {
        this.drawWheel = drawWheel;
    }

}
