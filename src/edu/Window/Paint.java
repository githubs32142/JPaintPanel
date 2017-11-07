package edu.Window;

import edu.Class.Figure.Arc;
import edu.Class.Figure.Line;
import edu.Class.Figure.Rhomb;
import edu.Class.JPaintPanel;
import edu.Class.Figure.Square;
import edu.Class.Figure.Triangle;
import edu.Class.WhatClicked;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Paint extends javax.swing.JFrame {

    JPaintPanel pp = new JPaintPanel();
    private Rhomb drawRhomb;
    private Square drawSquare;
    private Triangle drawTriangle;
    private Arc drawArc = new Arc(0, 0, 0, 0);
    private Line drawLine = new Line(0, 0, 0, 0);
    String whatDraw = "";
    private WhatClicked wC = new WhatClicked();

    public Paint() {
        initComponents();
        add(pp, java.awt.BorderLayout.CENTER);
        this.setSize(1000, 600);
        pp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                wC = pp.whatFigureClicked(me.getX(), me.getY());
                System.out.println(wC.getId());
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (choiseRhomb()) {
                    drawRhomb = pp.getDrawRhomb();
                    drawRhomb = new Rhomb.Builder()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setHeight(0)
                            .setWidth(0.0)
                            .setFill(Boolean.FALSE)
                            .setColorBorder(Color.black)
                            .setColorFill(Color.red)
                            .bulid();
                    pp.setDrawRhomb(drawRhomb);
                    pp.repaint();
                }
                if (choiseSquare()) {
                    drawSquare = pp.getDrawSquare();
                    drawSquare = new Square.BuilderSquare()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setWidth(0.0)
                            .setFill(Boolean.FALSE)
                            .setColorBorder(Color.black)
                            .setColorFill(Color.red)
                            .bulid();
                    pp.setDrawSquare(drawSquare);
                    pp.repaint();
                }
                if (choiseTriangle()) {
                    drawTriangle = pp.getDrawTriangle();
                    drawTriangle = new Triangle.BuilderTriangle()
                            .setX(me.getX())
                            .setY(me.getY())
                            .setHeight(0)
                            .setWidth(0.0)
                            .setFill(Boolean.FALSE)
                            .setColorBorder(Color.black)
                            .setColorFill(Color.red)
                            .bulid();
                    pp.setDrawTriangle(drawTriangle);
                    pp.repaint();
                }
                if (choiseArc()) {
                    drawArc = pp.getDrawArc();
                    drawArc = new Arc(me.getX(), me.getY(), me.getX(), me.getY());
                    pp.setDrawArc(drawArc);
                    pp.repaint();
                }
                if (choiseLine()) {
                    drawLine = pp.getDrawLine();
                    drawLine = new Line(me.getX(), me.getY(), me.getX(), me.getY());
                    pp.setDrawLine(drawLine);
                    pp.repaint();
                }

            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (choiseSquare()) {
                    pp.addObject(whatDraw, drawSquare);
                }
                if (choiseRhomb()) {
                    pp.addObject(whatDraw, drawRhomb);
                }
                if (choiseTriangle()) {
                    pp.addObject(whatDraw, drawTriangle);
                }
                if (choiseArc()) {
                    pp.addObject(whatDraw, drawArc);
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        pp.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                double tmpx = 0.0;
                double tmpy = 0.0;
                if (choiseRhomb()) {
                    tmpx = me.getX() - drawRhomb.getX();
                    tmpy = me.getY() - drawRhomb.getY();
                    drawRhomb.setWidth(tmpx);
                    drawRhomb.setHeight(tmpy);
                    pp.setDrawRhomb(drawRhomb);
                    pp.repaint();
                }
                if (choiseSquare()) {
                    tmpy = me.getY() - drawSquare.getY();
                    drawSquare.setWidth(tmpy);
                    pp.setDrawSquare(drawSquare);
                    pp.repaint();
                }
                if (choiseTriangle()) {
                    tmpx = me.getX() - drawTriangle.getX();
                    tmpy = me.getY() - drawTriangle.getY();
                    drawTriangle.setHeight(tmpy);
                    drawTriangle.setWidth(tmpx);
                    pp.setDrawTriangle(drawTriangle);
                    pp.repaint();
                }
                if (choiseArc()) {
                    drawArc.setxEnd(me.getX());
                    drawArc.setyEnd(me.getY());
                    pp.setDrawArc(drawArc);
                    pp.repaint();
                }
                if (choiseLine()) {
                    drawLine.setxEnd(me.getX());
                    drawLine.setyEnd(me.getY());
                    pp.setDrawLine(drawLine);
                    pp.repaint();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PWSTE Paint");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setText("Kształty");

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

        buttonGroup1.add(jToggleButton3);
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/rhomb.png"))); // NOI18N
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton4);
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/Resourse/circle.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 459, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        whatDraw = "rhomb";
    }//GEN-LAST:event_jToggleButton3ActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    // End of variables declaration//GEN-END:variables
}
