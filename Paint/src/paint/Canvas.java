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

    Point startPoint, endPoint;//To find the coordinates of the mouse from the begining and endng of the dragging
    int x1, y1, x2, y2;
    static Graphics2D g2;
    //We use the MouseListener to determine when the mouse is pressed and released to store the start and end point of the coordinates of the shape
    public Canvas() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                /*startPoint = new Point(e.getX(), e.getY());
                x1 = e.getX();
                y1 = e.getY();
                x2 = x1;
                y2 = y1;
                endPoint = startPoint;
                System.out.println("Start Point x: "+x1+" Start Point y: "+y1);*/

                //endPoint = startPoint;//Because we don't know yet if the user let go of the mouese
                //repaint();
                startPoint = e.getPoint();
                x1 = startPoint.x;
                y1 = startPoint.y;
            }

            public void mouseReleased(MouseEvent e) {
                startPoint = null;

            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                x2 = endPoint.x;
                y2 = endPoint.y;
                
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        Line2D shape = new Line2D.Double();
        if (startPoint != null && endPoint != null) {
            shape.setLine(startPoint.x,startPoint.y,endPoint.x,endPoint.y);
            g2.draw(shape);
            //repaint();
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        }

    }

}
