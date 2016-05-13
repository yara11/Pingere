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
    int bottomLeftx, bottomLefty, bottomRightx, bottomRighty, topVertexx, topVertexy, i = 0;

    public Triangle(double x1, double y1, double x2, double y2) {
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        bottomLeftx = (int) x1;
        bottomLefty = (int) y2;
        bottomRightx = (int) x2;
        bottomRighty = (int) y2;
        topVertexx = (int) (x1 + x2) / 2;
        topVertexy = (int) y1;
        setShape();
    }

    public Triangle(){}
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
        g.rotate(Math.toRadians(angle),x+width/2,y+height/2);
        g.drawPolygon(triangle);
        if (this.fill != null) {
            g.setPaint(this.fill);
            g.fill(triangle);
        }
        g.rotate(Math.toRadians(- angle),x+width/2,y+height/2);
    }

    @Override
    public void color(Color newFill) {
        this.setFillColor(newFill);
    }

    @Override
    public void resize(double newWidth, double newHeight) {
        width = Math.abs(bottomLeftx - bottomRightx);
        height = Math.abs(topVertexy - bottomRighty);
        System.out.println("Before : bottomLeftx " + bottomLeftx + " bottomRightx " + bottomRightx + " topVertexy " + topVertexy);
        System.out.println();
        double ratiox = (newWidth / width);
        double ratioy = (newHeight / height);
        System.out.println("Ratiox : " + ratiox + " Ratioy " + ratioy);
        System.out.println();
        i++;
        if (i % 2 == 0) {

            if (ratiox > 1) {
                bottomLeftx -= Math.abs(width - newWidth) / 2;
                bottomRightx += Math.abs(width - newWidth) / 2;
            } else if (ratiox < 1) {
                bottomLeftx += Math.abs(width - newWidth) / 2;
                bottomRightx -= Math.abs(width - newWidth) / 2;
            } else {
                bottomLeftx = bottomLeftx;
                bottomRightx = bottomRightx;
            }

            if (ratioy < 1) {
                topVertexy += Math.abs(height - newHeight);
            } else if (ratioy > 1) {
                topVertexy -= Math.abs(height - newHeight);
            } else {
                topVertexy = topVertexy;
            }

            System.out.println("After : bottomLeftx " + bottomLeftx + " bottomRightx " + bottomRightx + " topVertexy " + topVertexy);
            System.out.println();
            x = bottomLeftx;
            y = topVertexy;
            width = Math.abs(bottomLeftx - bottomRightx);
            height = Math.abs(topVertexy - bottomRighty);
            setShape();
        }
    }

    @Override
    public void move(double xDifference, double yDifference) {
        bottomLeftx += xDifference;
        bottomLefty += yDifference;
        bottomRightx += xDifference;
        bottomRighty += yDifference;
        topVertexx += xDifference;
        topVertexy += yDifference;
        x = bottomLeftx;
        y = topVertexy;
        setShape();
    }
    
    @Override
    protected void setShape(){
        selectX = x - 10;
        selectY = y - 10;
        selectWidth = width + 20;
        selectHeight = height + 20;
        triangle = new Polygon();
        triangle.addPoint(bottomLeftx, bottomLefty);
        triangle.addPoint(bottomRightx, bottomRighty);
        triangle.addPoint(topVertexx, topVertexy);
    }
    
    @Override
    public Shape getShape() {
        return triangle;
    }
    
    @Override
    public String getType() {
        return "Triangle";
    }
}
