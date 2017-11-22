package Class;

import Class.Figure.Arc;
import Class.Figure.Line;
import Class.Figure.Rhomb;
import Class.Figure.Triangle;
import Class.Figure.Square;
import Class.Figure.Wheel;
import Interface.Contains;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import Interface.ContainsSquare;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
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
    private WhatClicked wC = new WhatClicked();

    /**
     ** Metoda czyści wszystkie figury geometryczne.
     */
    public void wipe() {
        square.clear();
        triangles.clear();
        lines.clear();
        arcs.clear();
        rhombs.clear();
        wheel.clear();
        drawArc = null;
        drawLine = null;
        drawRhomb = null;
        drawSquare = null;
        drawTriangle = null;
        drawWheel = null;
        repaint();
    }

    /**
     ** Metoda, która zmienia rozmiar okna
     *
     * @param width szerokość
     * @param height wysokość
     */
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

        square.stream().forEach((t) -> {
            t.paint(g2D);
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

        if (isLine(wC.getType())) {
            lines.get(wC.getId()).drawBorder(g2D);
        }
        if (isWheelType(wC.getType())) {
            wheel.get(wC.getId()).drawBorder(g2D);
        }
        if (isArcType(wC.getType())) {
            arcs.get(wC.getId()).drawBorder(g2D);
        }
        if (isRhombType(wC.getType())) {
            rhombs.get(wC.getId()).drawBorder(g2D);
        }
        if (isSquareType(wC.getType())) {
            square.get(wC.getId()).drawBorder(g2D);
        }
        if (isTriangleType(wC.getType())) {
            triangles.get(wC.getId()).drawBorder(g2D);
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
    private int returnIndexdrawTriangle(double x, double y) {
        Interface.ContainsTriangle t = (List<Triangle> list, double x1, double y1) -> {
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

    private int returnIndexLine(double x, double y) {
        Interface.Contains c = (Contains<Line>) (List<Line> list, double x1, double y1) -> {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(x1, y1)) {
                    return i;
                }
            }
            return -1;
        };
        return c.contains(lines, x, y);
    }

    private int returnIndexArc(double x, double y) {
        Interface.Contains c = (Contains<Arc>) (List<Arc> list, double x1, double y1) -> {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(x1, y1)) {
                    return i;
                }
            }
            return -1;
        };
        return c.contains(arcs, x, y);
    }

    private int returnIndexWheel(double x, double y) {
        Interface.Contains c = (Contains<Wheel>) (List<Wheel> list, double x1, double y1) -> {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(x1, y1)) {
                    return i;
                }
            }
            return -1;
        };
        return c.contains(wheel, x, y);
    }

    private int returnIndexRhomb(double x, double y) {
        Interface.Contains c = (Contains<Rhomb>) (List<Rhomb> list, double x1, double y1) -> {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(x1, y1)) {
                    return i;
                }
            }
            return -1;
        };
        return c.contains(rhombs, x, y);
    }

    /**
     ** Metoda, która stawia kolor dla odpowiednio wybranej figury
     *
     * @param wC- zmienna która zawiera typ oraz id obiektu
     * @param c wybrany kolor
     */
    public void setColorBorder(WhatClicked wC, Color c) {
        if (isLine(wC.getType())) {
            setColorLine(wC.getId(), c);
        }
        if (isWheelType(wC.getType())) {
            setColorBorderWheel(wC.getId(), c);
        }
        if (isArcType(wC.getType())) {
            setColorArc(wC.getId(), c);
        }
        if (isRhombType(wC.getType())) {
            setColorBorderRhomb(wC.getId(), c);
        }
        if (isSquareType(wC.getType())) {
            setColorBorderSquare(wC.getId(), c);
        }
        if (isTriangleType(wC.getType())) {
            setColorBorderTriangle(wC.getId(), c);
        }
        repaint();
    }

    private void setColorLine(int id, Color c) {
        lines.get(id).setColor(c);
    }

    private void setColorBorderWheel(int id, Color c) {
        wheel.get(id).setColorBorder(c);
    }

    private void setColorBorderRhomb(int id, Color c) {
        rhombs.get(id).setColorBorder(c);
    }

    private void setColorBorderSquare(int id, Color c) {
        square.get(id).setColorBorder(c);
    }

    private void setColorBorderTriangle(int id, Color c) {
        triangles.get(id).setColorBorder(c);
    }

    private void setColorArc(int id, Color c) {
        arcs.get(id).setColor(c);
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

    /**
     ** Metoda, która zwraca index oraz typ figury która znajduje się na
     * podanych parametrach
     *
     * @param x - współrzędna x
     * @param y - współrzędna y
     * @return zmienna, która zawiera typ oraz id obiektu na liście
     */
    public WhatClicked whatFigureClicked(double x, double y) {
        int tmp = -1;
        tmp = returnIndexSquare(x, y);
        WhatClicked wC = new WhatClicked(-1, "");
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("square");
            return wC;
        }
        tmp = returnIndexdrawTriangle(x, y);
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("triangle");
            return wC;
        }
        tmp = returnIndexLine(x, y);
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("line");
            return wC;
        }
        tmp = returnIndexArc(x, y);
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("arc");
            return wC;
        }
        tmp = returnIndexRhomb(x, y);
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("rhomb");
            return wC;
        }
        tmp = returnIndexWheel(x, y);
        if (tmp >= 0) {
            wC.setId(tmp);
            wC.setType("wheel");
            return wC;
        }
        return wC;
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

    /**
     ** Metoda, która ładuje obrazek o podanej ścieżce dostępu
     *
     * @param file- plik z ktorego pobieramy dane
     * @throws IOException wyjątek I/O
     */
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

    private Color colorBorderSquare(int i) {
        return square.get(i).getColorBorder();
    }

    private Color colorFillSquare(int i) {
        return square.get(i).getColorFill();
    }

    private Color colorBorderTriangle(int i) {
        return triangles.get(i).getColorBorder();
    }

    private Color colorFillTriangle(int i) {
        return triangles.get(i).getColorFill();
    }

    private Color colorBorderWheel(int i) {
        return wheel.get(i).getColorBorder();
    }

    private Color colorFillWheel(int i) {
        return wheel.get(i).getColorFill();
    }

    private Color colorBorderRhomb(int i) {
        return rhombs.get(i).getColorBorder();
    }

    private Color colorFillRhomb(int i) {
        return rhombs.get(i).getColorFill();
    }

    private Color getColorArc(int i) {
        return arcs.get(i).getColor();
    }

    private Color getColorLine(int i) {
        return lines.get(i).getColor();
    }

    /**
     ** Metoda, która zwraca kolor obramowania podanej figury
     *
     * @param wC zmienna, która zawiera id oraz typ obiektu
     * @return kolor obramowania figury jeżeli nic nie znajdzie zwraca kolor
     * czarny
     */
    public Color getColorBorder(WhatClicked wC) {
        if (isSquareType(wC.getType())) {
            return square.get(wC.getId()).getColorBorder();
        }
        if (isRhombType(wC.getType())) {
            return rhombs.get(wC.getId()).getColorBorder();
        }
        if (isWheelType(wC.getType())) {
            return wheel.get(wC.getId()).getColorBorder();
        }
        if (isArcType(wC.getType())) {
            return arcs.get(wC.getId()).getColor();
        }
        if (isLine(wC.getType())) {
            return lines.get(wC.getId()).getColor();
        }
        return Color.black;
    }

    private boolean isFillRhomb(int i) {
        return rhombs.get(i).isFill();
    }

    private boolean isFillSquare(int i) {
        return square.get(i).isFill();
    }

    private boolean isFillTriangle(int i) {
        return triangles.get(i).isFill();
    }

    private boolean isFillWheel(int i) {
        return wheel.get(i).isFill();
    }

    /**
     ** Metoda, która sprawdza, czy obiekt posiada wypełnienie
     *
     * @param wC zmienna która przechowuje informacje na temat id oraz typu
     * obiektu
     * @return true jeżeli zawiera wypełnienie w przeciwnym wypadku false
     */
    public boolean isFillObject(WhatClicked wC) {
        if ("rhomb".equals(wC.getType())) {
            return isFillRhomb(wC.getId());
        }
        if ("square".equals(wC.getType())) {
            return isFillSquare(wC.getId());
        }
        if ("triangle".equals(wC.getType())) {
            return isFillTriangle(wC.getId());
        }
        if ("wheel".equals(wC.getType())) {
            return isFillWheel(wC.getId());
        }
        return false;
    }

    /**
     ** Metoda, która ustawia kolor wypełnienia
     *
     * @param wC zmienna, która przechowuje informacje na temat id oraz typu
     * obiektu
     * @param c kolor
     */
    public void setFillColor(WhatClicked wC, Color c) {
        if ("rhomb".equals(wC.getType())) {
            rhombs.get(wC.getId()).setColorFill(c);
        }
        if ("square".equals(wC.getType())) {
            square.get(wC.getId()).setColorFill(c);
        }
        if ("triangle".equals(wC.getType())) {
            triangles.get(wC.getId()).setColorFill(c);
        }
        if ("wheel".equals(wC.getType())) {
            wheel.get(wC.getId()).setColorFill(c);
        }
        repaint();
    }

    public Color getColorFill(WhatClicked wC) {
        if (isSquareType(wC.getType())) {
            return square.get(wC.getId()).getColorFill();
        }
        if (isRhombType(wC.getType())) {
            return rhombs.get(wC.getId()).getColorFill();
        }
        if (isWheelType(wC.getType())) {
            return wheel.get(wC.getId()).getColorFill();
        }
        if (isTriangleType(wC.getType())) {
            return triangles.get(wC.getId()).getColorFill();
        }
        return Color.black;
    }

    public void setFill(WhatClicked wC, boolean isFiil) {
        if (isSquareType(wC.getType())) {
            square.get(wC.getId()).setFill(isFiil);
        }
        if (isRhombType(wC.getType())) {
            rhombs.get(wC.getId()).setFill(isFiil);
        }
        if (isWheelType(wC.getType())) {
            wheel.get(wC.getId()).setFill(isFiil);
        }
        if (isTriangleType(wC.getType())) {
            triangles.get(wC.getId()).setFill(isFiil);
        }
        repaint();
    }

    public void setwC(WhatClicked wC) {
        this.wC = wC;
        repaint();
    }

}
