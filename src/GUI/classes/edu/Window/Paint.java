package edu.Window;

import Class.Figure.Arc;
import Class.Figure.Line;
import Class.Figure.Rhomb;
import Class.JPaintPanel;
import Class.Figure.Square;
import Class.Figure.Triangle;
import Class.Figure.Wheel;
import Class.WhatClicked;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Paint extends javax.swing.JFrame {

    int a = 0, b = 0;
    JPaintPanel paintPanel = new JPaintPanel();
    private Rhomb drawRhomb;
    private Square drawSquare;
    private Triangle drawTriangle;
    private Wheel drawWheel;
    private Arc drawArc;
    private Line drawLine;
    String whatDraw = "arc";
    private Color colorBorder = Color.BLACK;
    private Color colorFill = Color.black;
    private boolean fill = false;
    private WhatClicked wC = new WhatClicked();
    JScrollPane scroll = new JScrollPane();

    public Paint() {
        initComponents();
        initText();
        paintPanel.setSize(1000, 1000);
        scroll.getViewport().setView(paintPanel);
        scroll.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(BorderLayout.CENTER, scroll);
        this.setSize(1000, 600);
        paintPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                wC = paintPanel.whatFigureClicked(me.getX(), me.getY());
                paintPanel.setwC(wC);
                if ("point".equals(whatDraw)) {
                    colorBorder = paintPanel.getColorBorder(wC);
                    jPanel4.setBackground(colorBorder);
                }
                if ("point".equals(whatDraw)) {
                    colorFill = paintPanel.getColorFill(wC);
                    jPanel5.setBackground(colorFill);
                }
                if ("point".equals(whatDraw)) {
                    fill = paintPanel.isFillObject(wC);
                    jCheckBox1.setSelected(fill);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (choiseRhomb()) {
                    drawRhomb = paintPanel.getDrawRhomb();
                    drawRhomb = new Rhomb.BuilderRhomb()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setHeight(0)
                            .setWidth(0.0)
                            .setFill(fill)
                            .setColorBorder(colorBorder)
                            .setColorFill(colorFill)
                            .bulid();
                    // drawRhomb.setFill(fill);
                    paintPanel.setDrawRhomb(drawRhomb);
                    paintPanel.repaint();
                }
                if (choiseSquare()) {
                    drawSquare = paintPanel.getDrawSquare();
                    drawSquare = new Square.BuilderSquare()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setWidth(0.0)
                            .setFill(fill)
                            .setColorBorder(colorBorder)
                            .setColorFill(colorFill)
                            .bulid();
                    paintPanel.setDrawSquare(drawSquare);
                    paintPanel.repaint();
                }
                if (choiseTriangle()) {
                    drawTriangle = paintPanel.getDrawTriangle();
                    drawTriangle = new Triangle.BuilderTriangle()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setHeight(0)
                            .setWidth(0.0)
                            .setFill(fill)
                            .setColorBorder(colorBorder)
                            .setColorFill(colorFill)
                            .bulid();
                    paintPanel.setDrawTriangle(drawTriangle);
                    paintPanel.repaint();
                }
                if (choiseArc()) {
                    drawArc = paintPanel.getDrawArc();
                    drawArc = new Arc.Builder()
                            .setXStart(me.getX())
                            .setYStart(me.getY())
                            .setXEnd(me.getX())
                            .setYEnd(me.getY())
                            .setFill(fill)
                            .setColor(colorBorder)
                            .bulid();
                    paintPanel.setDrawArc(drawArc);
                    paintPanel.repaint();
                }
                if (choiseLine()) {
                    drawLine = paintPanel.getDrawLine();
                    drawLine = new Line.Builder()
                            .setXStart(me.getX())
                            .setYStart(me.getY())
                            .setXEnd(me.getX())
                            .setYEnd(me.getY())
                            .setFill(fill)
                            .setColor(colorBorder)
                            .bulid();
                    paintPanel.setDrawLine(drawLine);
                    paintPanel.repaint();
                }
                if (choiseWheel()) {
                    drawWheel = paintPanel.getDrawWheel();
                    drawWheel = new Wheel.Builder()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setRadius(0)
                            .setFill(fill)
                            .setColorBorder(colorBorder)
                            .setColorFill(colorFill)
                            .bulid();
                    paintPanel.setDrawWheel(drawWheel);
                    paintPanel.repaint();
                }
                if ("point".equals(whatDraw)) {
                    wC = paintPanel.whatFigureClicked(me.getX(), me.getY());
                    if (wC.getId() >= 0) {
                        if ("arc".equals(wC.getType())) {
                            drawArc = (Arc) paintPanel.getObject(wC);
                        }
                        if ("rhomb".equals(wC.getType())) {
                            drawRhomb = (Rhomb) paintPanel.getObject(wC);
                        }
                        if ("square".equals(wC.getType())) {
                            drawSquare = (Square) paintPanel.getObject(wC);
                        }
                        if ("line".equals(wC.getType())) {
                            drawLine = (Line) paintPanel.getObject(wC);
                        }
                        if ("triangle".equals(wC.getType())) {
                            drawTriangle = (Triangle) paintPanel.getObject(wC);
                        }
                        if ("wheel".equals(wC.getType())) {
                            drawWheel = (Wheel) paintPanel.getObject(wC);
                        }
                    }
                }

            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (choiseSquare()) {
                    paintPanel.addObject(whatDraw, drawSquare);
                }
                if (choiseRhomb()) {
                    paintPanel.addObject(whatDraw, drawRhomb);
                }
                if (choiseTriangle()) {
                    paintPanel.addObject(whatDraw, drawTriangle);
                }
                if (choiseArc()) {
                    paintPanel.addObject(whatDraw, drawArc);
                }
                if (choiseLine()) {
                    paintPanel.addObject(whatDraw, drawLine);
                }
                if (choiseWheel()) {
                    paintPanel.addObject(whatDraw, drawWheel);
                }
                wC = new WhatClicked(-1, "");
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        paintPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                double tmpx = 0.0;
                double tmpy = 0.0;
                if (choiseRhomb()) {
                    tmpx = me.getX() - drawRhomb.getX();
                    tmpy = me.getY() - drawRhomb.getY();
                    drawRhomb.setWidth(tmpx);
                    drawRhomb.setHeight(tmpy);
                    paintPanel.setDrawRhomb(drawRhomb);
                    paintPanel.repaint();
                }
                if (choiseSquare()) {
                    tmpy = me.getY() - drawSquare.getY();
                    drawSquare.setWidth(tmpy);
                    paintPanel.setDrawSquare(drawSquare);
                    paintPanel.repaint();
                }
                if (choiseTriangle()) {
                    tmpx = me.getX() - drawTriangle.getX();
                    tmpy = me.getY() - drawTriangle.getY();
                    drawTriangle.setHeight(tmpy);
                    drawTriangle.setWidth(tmpx);
                    paintPanel.setDrawTriangle(drawTriangle);
                    paintPanel.repaint();
                }
                if (choiseArc()) {
                    drawArc.setxEnd(me.getX());
                    drawArc.setyEnd(me.getY());
                    paintPanel.setDrawArc(drawArc);
                    paintPanel.repaint();
                }
                if (choiseLine()) {
                    drawLine.setxEnd(me.getX());
                    drawLine.setyEnd(me.getY());
                    paintPanel.setDrawLine(drawLine);
                    paintPanel.repaint();
                }
                if (choiseWheel()) {
                    tmpx = me.getX() - drawWheel.getX();
                    drawWheel.setRadius(tmpx);
                    paintPanel.setDrawWheel(drawWheel);
                    paintPanel.repaint();
                }
                if ("point".equals(whatDraw)) {
                    if (wC.getId() >= 0) {
                        if ("arc".equals(wC.getType())) {
                            drawArc.setxEnd(me.getX());
                            drawArc.setyEnd(me.getY());
                            paintPanel.setObject(wC, drawArc);
                        }
                        if ("rhomb".equals(wC.getType())) {
                            drawRhomb.setXY(me.getX(), me.getY());
                            paintPanel.setObject(wC, drawRhomb);
                        }
                        if ("square".equals(wC.getType())) {
                            drawSquare.setXY(me.getX(), me.getY());
                            paintPanel.setObject(wC, drawSquare);
                        }
                        if ("line".equals(wC.getType())) {
                            drawLine.setxEnd(me.getX());
                            drawLine.setyEnd(me.getY());
                            paintPanel.setObject(wC, drawLine);
                        }
                        if ("triangle".equals(wC.getType())) {
                            drawTriangle.setXY(me.getX(), me.getY());
                            paintPanel.setObject(wC, drawTriangle);
                        }
                        if ("wheel".equals(wC.getType())) {
                            drawWheel.setXY(me.getX(), me.getY());
                            paintPanel.setObject(wC, drawWheel);
                        }
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent me) {

            }
        });

    }

    private boolean choiseLine() {
        return "line".equals(whatDraw);
    }

    private boolean choiseArc() {
        return "arc".equals(whatDraw);
    }

    private boolean choiseTriangle() {
        return "triangle".equals(whatDraw);
    }

    private boolean choiseSquare() {
        return "square".equals(whatDraw);
    }

    private boolean choiseRhomb() {
        return "rhomb".equals(whatDraw);
    }

    private boolean choiseWheel() {
        return "wheel".equals(whatDraw);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        rhombBtn = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        removeObj = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        clear = new javax.swing.JMenuItem();
        saveAsJPG = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        buttonGroup1.add(jToggleButton1);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/arrow.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton2);
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/line.png"))); // NOI18N
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rhombBtn);
        rhombBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/rhomb.png"))); // NOI18N
        rhombBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rhombBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton4);
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/circle.png"))); // NOI18N
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton5);
        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/triangle.png"))); // NOI18N
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton6);
        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/square.png"))); // NOI18N
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton7);
        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/point.png"))); // NOI18N
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        removeObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/delete.png"))); // NOI18N
        removeObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeObjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(removeObj, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rhombBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rhombBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(removeObj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(223, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 136, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        clear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jMenu1.add(clear);

        saveAsJPG.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveAsJPG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsJPGActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsJPG);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rhombBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rhombBtnActionPerformed
        whatDraw = "rhomb";
    }//GEN-LAST:event_rhombBtnActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        whatDraw = "square";
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        whatDraw = "arc";
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        whatDraw = "line";
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        whatDraw = "triangle";
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        whatDraw = "wheel";
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if ("point".equals(whatDraw)) {
            fill = paintPanel.isFillObject(wC);
            fill = !fill;
            paintPanel.setFill(wC, fill);
        } else {
            fill = !fill;
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        Color newColor = JColorChooser.showDialog(
                this,
                "Wybierz kolor obramowania",
                colorBorder);
        jPanel4.setBackground(newColor);
        colorBorder = newColor;
        if ("point".equals(whatDraw)) {
            paintPanel.setColorBorder(wC, newColor);
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Win.jSize.run(paintPanel);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        Color newColor = JColorChooser.showDialog(
                this,
                "Wybierz kolor wypełnienia",
                colorFill);
        jPanel5.setBackground(newColor);
        colorFill = newColor;
        if ("point".equals(whatDraw)) {
            paintPanel.setFillColor(wC, newColor);
        }
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        whatDraw = "point";
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        paintPanel.wipe();
    }//GEN-LAST:event_clearActionPerformed

    private void saveAsJPGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsJPGActionPerformed
        JFileChooser saveDialog = new JFileChooser();
        saveDialog.setDialogTitle("Zapisz jako jpg");
        UIManager.put("FileChooser.saveDialogTitleText", "Zapisz");
        UIManager.put("FileChooser.saveInLabelText", "Zapisz w");
        UIManager.put("FileChooser.saveButtonText", "Zapisz");
        UIManager.put("FileChooser.cancelButtonText", "Zamknij");
        UIManager.put("FileChooser.fileNameLabelText", "Nazwa pliku:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Typ pliku");
        UIManager.put("FileChooser.openButtonToolTipText", "Otwórz zaznaczony plik");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Zamknij okno");
        UIManager.put("FileChooser.fileNameHeaderText", "Nazwa pliku");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder wyżej");
        UIManager.put("FileChooser.homeFolderToolTipText", "Pulpit");
        UIManager.put("FileChooser.newFolderToolTipText", "Utwórz nowy folder");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.newFolderButtonText", "Utwórz nowy folder");
        UIManager.put("FileChooser.renameFileButtonText", "Zmień nazwę pliku");
        UIManager.put("FileChooser.deleteFileButtonText", "Usuń plik");
        UIManager.put("FileChooser.filterLabelText", "Typ pliku");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Szczegóły");
        UIManager.put("FileChooser.fileSizeHeaderText", "Rozmiar");
        UIManager.put("FileChooser.fileDateHeaderText", "Data modyfikacji");
        SwingUtilities.updateComponentTreeUI(saveDialog);
        if (saveDialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = saveDialog.getSelectedFile();
            paintPanel.saveToPdf(selectedFile);
        }
    }//GEN-LAST:event_saveAsJPGActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        JFileChooser otworz = new JFileChooser();
        otworz.setDialogTitle("Otwórz projekt");
        UIManager.put("FileChooser.openDialogTitleText", "Otwórz");
        UIManager.put("FileChooser.lookInLabelText", "Zobacz w");
        UIManager.put("FileChooser.openButtonText", "Otwórz");
        UIManager.put("FileChooser.cancelButtonText", "Zamknij");
        UIManager.put("FileChooser.fileNameLabelText", "Nazwa pliku:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Typ pliku");
        UIManager.put("FileChooser.openButtonToolTipText", "Otwórz zaznaczony plik");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Zamknij okno");
        UIManager.put("FileChooser.fileNameHeaderText", "Nazwa pliku");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder wyżej");
        UIManager.put("FileChooser.homeFolderToolTipText", "Pulpit");
        UIManager.put("FileChooser.newFolderToolTipText", "Utwórz nowy folder");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.newFolderButtonText", "Utwórz nowy folder");
        UIManager.put("FileChooser.renameFileButtonText", "Zmień nazwę pliku");
        UIManager.put("FileChooser.deleteFileButtonText", "Usuń plik");
        UIManager.put("FileChooser.filterLabelText", "Typ pliku");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Szczegóły");
        UIManager.put("FileChooser.fileSizeHeaderText", "Rozmiar");
        UIManager.put("FileChooser.fileDateHeaderText", "Data modyfikacji");
        SwingUtilities.updateComponentTreeUI(otworz);
        if (otworz.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = otworz.getSelectedFile();
            try {
                paintPanel.loadImage(file);
            } catch (IOException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void removeObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeObjActionPerformed
      int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "Czy usunąć zaznaczony element?","Ostrzeżenie", dialogButton);
            if(dialogButton == JOptionPane.YES_OPTION) {
                paintPanel.deleteObject(wC);
              }
    }//GEN-LAST:event_removeObjActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Paint().setVisible(true);
        });
    }

    private void initText() {
        jLabel1.setText("Kształty");
        jCheckBox1.setText("Wypełnienie");
        jLabel2.setText("Obramowanie");
        jMenu1.setText("Plik");
        jMenuItem1.setText("Nowy");
        clear.setText("Wyczyść");
        saveAsJPG.setText("Zapisz do jpg");
        openFile.setText("Otwórz plik jpg");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem clear;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JButton removeObj;
    private javax.swing.JToggleButton rhombBtn;
    private javax.swing.JMenuItem saveAsJPG;
    // End of variables declaration//GEN-END:variables
}
