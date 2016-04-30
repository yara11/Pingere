/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import paint.Resize;

/**
 *
 * @author Krietallo
 */
//The canvas used to draw
public class Canvas extends JComponent {

    // Tracking each shape in the project
    ArrayList<MyShape> shapeList = new ArrayList<MyShape>();

    // To find the coordinates of the mouse from the begining and endng of the dragging
    Point startPoint, endPoint, endPointMove;
    public static MyShape selectedShape = null;
    Graphics2D g2;

    // Tracking index of next shape
    int nextIndex = 0;

    // This is the Stroke for the helper (dashed) rectangles when we select something
    float dash1[] = {10.0f};
    BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

    //We use the MouseListener to determine when the mouse is pressed and released to store the start and end point of the coordinates of the shape
    public Canvas() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                startPoint = e.getPoint();

                if (Paint.selectedBut.equals("select")) {
                    selectedShape = getSelectedShape(startPoint);
                    if (selectedShape != null) {
                        bringFront(selectedShape);
                        // Unselect already selected shape, if any:
                        // Remove the dashed rectangle from shapeList
                        for (MyShape s : shapeList) {
                            if (s.getStroke().equals(dashed)) {
                                shapeList.remove(s);
                                break;
                            }
                        }

                        shapeList.add(selectedShape.drawSelectRectangle());
                        repaint();
                    }
                }

                if (Paint.selectedBut.equals("fill")) {
                    selectedShape = getSelectedShape(startPoint);
                    // User didn't press an empty space
                    if (selectedShape != null) {
                        selectedShape.color(g2, Paint.fillColor);
                        repaint();
                    }
                }
                if (Paint.selectedBut.equals("move")) {
                    selectedShape = getSelectedShape(startPoint);
                    if (selectedShape != null) {
                        bringFront(selectedShape);
                        // Unselect already selected shape, if any:
                        // Remove the dashed rectangle from shapeList
                        for (MyShape s : shapeList) {
                            if (s.getStroke().equals(dashed)) {
                                shapeList.remove(s);
                                break;
                            }
                        }

                        shapeList.add(selectedShape.drawSelectRectangle());
                        repaint();
                    }
                }
                if (Paint.selectedBut.equals("delete")) {
                    selectedShape = getSelectedShape(startPoint);
                    if (selectedShape != null) {
                        bringFront(selectedShape);
                        shapeList.remove(selectedShape);
                    }
                    repaint();
                }
                if (Paint.selectedBut.equals("resize")) {
                    selectedShape = getSelectedShape(startPoint);
                    Resize r = new Resize();
                    System.out.println(r.getW() + " the dimensios " + r.getH());
                    if (r.flag) {
                        selectedShape.resize(r.getW(), r.getH());
                        repaint();
                    }

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // I need the start and end point only if I am drawing a shape
                endPoint = e.getPoint();
                if (Paint.selectedBut.equals("move") && selectedShape != null) {
                    selectedShape.move(endPoint.x - startPoint.x, endPoint.y - startPoint.y);
                    //System.out.println((endPoint.x - startPoint.x) + " " + (endPoint.y - startPoint.y));
                    for (MyShape s : shapeList) {
                        if (s.getStroke().equals(dashed)) {
                            shapeList.remove(s);
                            break;
                        }
                    }
                    shapeList.add(selectedShape.drawSelectRectangle());
                    repaint();
                }
                if (!isShape(Paint.selectedBut)) {
                    endPoint = null;
                    return;
                }

                repaint();

            }

        });
        /*this.addMouseMotionListener(new MouseMotionAdapter() {
//            MyShape aShape = null;
            public void mouseMoved(MouseEvent e) {
                endPoint = e.getPoint();
            }

            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
            }
        });*/
    }

    // Overriden paint() method from JComponent
    @Override
    public void paint(Graphics g) {
        g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        if (startPoint != null && endPoint != null) {

            // Create new shape from the shape factory
            ShapeFactory sf = new ShapeFactory();
            MyShape aShape = sf.getShape(Paint.selectedBut, startPoint.x, startPoint.y, endPoint.x, endPoint.y);

            // if a shape is not selected, go away, else...
            if (aShape != null) {
                aShape.setStrokeColor(Paint.strokeColor);
                aShape.setIndex(nextIndex++);
                shapeList.add((MyShape) aShape);
            }

            // to avoid drawing extra stuff (will draw the shape once 
            startPoint = endPoint = null;

            //System.out.println(startPoint.x + " " + startPoint.y + " " + endPoint.x + " " + endPoint.y);
        }
        Color tempPaint = (Color) g2.getPaint();
        Stroke tempStroke = g2.getStroke();
        MyShape sel = null;
        for (MyShape s : shapeList) {
            //System.out.println(s.getIndex());
            //System.out.println(Paint.strokeColor.toString());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (s.getStroke().equals(dashed) && !Paint.selectedBut.equals("select") && !Paint.selectedBut.equals("move")) {
                sel = s;
                continue;
            }
            s.draw(g2);
            //g2.setPaint(s.getFillColor());
        }
        shapeList.remove(sel);

        // Because the draw(g2) methods will change the paint and stroke into the shape's fill & stroke colors
        g2.setPaint(tempPaint);
        g2.setStroke(tempStroke);
        System.out.println();
    }

    // Utility methods
    boolean isShape(String s) {
        return s.equals("triangle") || s.equals("rectangle") || s.equals("square") || s.equals("circle") || s.equals("ellipse") || s.equals("line");
    }

    // We could get rid of the index parameter at this point ... But might need it for later.
    MyShape getSelectedShape(Point p) {
        int greatestInd = -1;
        MyShape ret = null;
        for (MyShape sh : shapeList) {
            if (sh.getShape().contains(p) && sh.getIndex() > greatestInd) {
                if (sh.getStroke().equals(dashed)) {
                    continue;
                }
                ret = sh;
                greatestInd = sh.getIndex();
            }
        }
        return ret;
    }

    void bringFront(MyShape k) {
        shapeList.remove(k);//remove the shape in the back
        //k.setIndex(nextIndex++);
        shapeList.add(k);//then added again so that it is the newest shape in the ArrayList
    }
}
