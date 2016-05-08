/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author User
 */
public class Triangle extends MyShape {

    protected Polygon triangle = new Polygon();
    int bottomLeftx, bottomLefty, bottomRightx, bottomRighty, topVertexx, topVertexy;

    public Triangle(double x1, double y1, double x2, double y2) {
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        bottomLeftx = (int)x1;
        bottomLefty = (int)y2;
        bottomRightx = (int)x2;
        bottomRighty = (int)y2;
        topVertexx = (int)(x1+x2)/2;
        topVertexy = (int)y1;
        
        
    }

    /**
     * Operations
     *
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        System.out.println("Drawing triangle");
        g.setStroke(this.strokeType);
        g.setPaint(this.stroke);
        System.out.println(bottomLefty);
        triangle.addPoint(bottomLeftx, bottomLefty);
        triangle.addPoint(bottomRightx, bottomRighty);
        triangle.addPoint(topVertexx, topVertexy);
        g.drawPolygon(triangle);
        
        if (this.fill != null) {
            g.setPaint(this.fill);
            g.fill(triangle);
        }
    }

    @Override
    public String getType() {
        return "Triangle";
    }

    public void color(Graphics2D g, Color newFill) {
        System.out.println("Color");
    }

    public void resize(double newWidth, double newHeight) {
        System.out.println("resize");
    }

    /**
     *
     */
    public void move(double xDifference, double yDifference) {
        System.out.println("move");

    }

    @Override
    public Shape getShape() {
        return triangle;
    }
}
