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
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Krietallo
 */
//The canvas used to draw
public class Canvas extends JComponent {

    //Tracking each shape in the project, its color, stroke and transparency
    ArrayList<MyShape> shapeList = new ArrayList<MyShape>();

    //To find the coordinates of the mouse from the begining and endng of the dragging
    Point startPoint, endPoint;

    int x1, y1, x2, y2;
    Line2D line2d;
    Graphics2D g2;

    //We use the MouseListener to determine when the mouse is pressed and released to store the start and end point of the coordinates of the shape
    public Canvas() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                x1 = startPoint.x;
                y1 = startPoint.y;
            }

            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                
                repaint();
                //startPoint = null;
                /*x2 = endPoint.x;
                y2 = endPoint.y;*/

                //endPoint = null;
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
//            MyShape aShape = null;
            public void mouseMoved(MouseEvent e) {
                endPoint = e.getPoint();
                x2 = endPoint.x;
                y2 = endPoint.y;
            }

            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                x2 = endPoint.x;
                y2 = endPoint.y;
                //ShapeFactory sf = new ShapeFactory();
                //MyShape aShape = sf.getShape(Paint.selectedBut,startPoint.x,startPoint.y,endPoint.x,endPoint.y);
                //System.out.println(Paint.selectedBut);
                //shapeList.add((MyShape)aShape);
                //aShape.draw(g2);
                //repaint();
            }
        });
    }

    public void paint(Graphics g) {
        g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke (4));
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

        if (startPoint != null && endPoint != null) {
            ShapeFactory sf = new ShapeFactory();
            MyShape aShape = sf.getShape(Paint.selectedBut, startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            aShape.setStrokeColor(Paint.strokeColor);
            aShape.setFillColor(Paint.fillColor);
            shapeList.add((MyShape) aShape);
            //aShape.draw(g2);
            //g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            for (int i = 0; i < shapeList.size(); i++) {
                //System.out.println(Paint.strokeColor.toString());
                g2.setPaint(shapeList.get(i).getStrokeColor());
                shapeList.get(i).draw(g2);
                g2.setPaint(shapeList.get(i).getFillColor());
                shapeList.get(i).fill(g2);
            }   //repaint();
        }

    }

}
