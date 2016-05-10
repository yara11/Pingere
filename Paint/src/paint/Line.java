/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author User
 */
public class Line extends MyShape {

    private double x1, y1, x2, y2;
    private Line2D.Double lineShape;
    private Rectangle2D.Double rectangularBoundry;

    /**
     * Constructor *
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        width = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        height = 0;
        lineShape = new Line2D.Double(x1, y1, x2, y2);
        selectX = Math.min(x1, x2);
        selectY = Math.min(y1, y2);
        selectWidth = Math.abs(x1 - x2);
        selectHeight = Math.abs(y1 - y2);
        rectangularBoundry = new Rectangle2D.Double(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x1-x2), Math.abs(y1-y2));
    }
    
    public Line(){}
    
    /**
     * Operations *
     */
    @Override
    public void draw(Graphics2D g) {
        g.setStroke(this.strokeType);
        g.setPaint(this.stroke);
        g.draw(lineShape);
        System.out.println("Drawing Line");
    }

    public void move(double xDifference, double yDifference) {
        x1 += xDifference;
        y1 += yDifference;
        x2 += xDifference;
        y2 += yDifference;
        width = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        lineShape = new Line2D.Double(x1, y1, x2, y2);
        selectX = Math.min(x1, x2);
        selectY = Math.min(y1, y2);
        selectWidth = Math.abs(x1 - x2);
        selectHeight = Math.abs(y1 - y2);
        rectangularBoundry = new Rectangle2D.Double(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x1-x2), Math.abs(y1-y2));
    }
    
    
    @Override
    public void color(Graphics2D g, Color newFill) {
        // do nothing here.
    }

    @Override
    public Shape getShape() {
        return rectangularBoundry;
    }

    @Override
    public void resize(double newWidth, double newHeight) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double newLength = newWidth;
        double oldLength = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        x2  = (newLength / oldLength) * (x2 - x1) + x1;
        y2  = (newLength / oldLength) * (y2 - y1) + y1;
        lineShape = new Line2D.Double(x1, y1, x2, y2);
        width = newLength;
        selectX = Math.min(x1, x2);
        selectY = Math.min(y1, y2);
        selectWidth = Math.abs(x1 - x2);
        selectHeight = Math.abs(y1 - y2);
        rectangularBoundry = new Rectangle2D.Double(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x1-x2), Math.abs(y1-y2));
    }

    @Override
    public String getType() {
        return "Line";
    }
}
