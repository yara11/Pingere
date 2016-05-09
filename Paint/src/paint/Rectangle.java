/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author User
 */
public class Rectangle extends MyShape {

    //protected double x, y, width, height;
    protected Rectangle2D.Double rectShape;

    /**
     * Constructor *
     */
    public Rectangle(double x1, double y1, double x2, double y2) {
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        rectShape = new Rectangle2D.Double(x, y, width, height);
        selectX = x - 10;
        selectY = y - 10;
        selectWidth = width + 20;
        selectHeight = height + 20;
    }
    public Rectangle(){}
    /**
     * Operations *
     */
    @Override
    /*public void rotate(Graphics2D g) {
        
        g.translate(100, 100);
        g.setColor(Color.blue);
        g.draw(rectShape);
        System.out.println(x+" "+y);
        if (this.fill != null) {
            g.setPaint(Color.blue);
            g.fill(rectShape);
        }
        //g.rotate(Math.toRadians(45));
        //draw(g);
    }*/
    public void draw(Graphics2D g) {
        System.out.println("Drawing rectangle");
        g.setStroke(this.strokeType);
        g.setPaint(this.stroke);
        g.draw(rectShape);
        if (this.fill != null) {
            g.setPaint(this.fill);
            g.fill(rectShape);
        }
    }

    public void move(double xDifference, double yDifference) {
        System.out.println("old x and y " + x + " " + y);
        x += xDifference;
        y += yDifference;
        System.out.println("new x and y " + x + " " + y);
        rectShape = new Rectangle2D.Double(x, y, width, height);
        selectX = x - 10;
        selectY = y - 10;
        selectWidth = width + 20;
        selectHeight = height + 20;
    }

    public void color(Graphics2D g, Color newFill) {
        this.setFillColor(newFill);
        draw(g);
    }


    public void resize(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
        rectShape = new Rectangle2D.Double(x, y, width, height);
        selectX = x - 10;
        selectY = y - 10;
        selectWidth = width + 20;
        selectHeight = height + 20;
    }

    public Shape getShape() {
        return rectShape;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

}
