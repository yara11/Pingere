/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
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
        setShape();
    }
    
    public Line(){}
    
    /**
     * Operations *
     */
    @Override
    public void draw(Graphics2D g) {
        g.setStroke(this.strokeType);
        g.setPaint(this.stroke);
        g.rotate(Math.toRadians(-angle),(x1+x2)/2,(y1+y2)/2);
        g.draw(lineShape);
        g.rotate(Math.toRadians(angle),(x1+x2)/2,(y1+y2)/2);
        System.out.println("Drawing Line");
    }

    @Override
    public void color(Color newFill) {
        // do nothing here.
    }
    
    public void move(double xDifference, double yDifference) {
        x1 += xDifference;
        y1 += yDifference;
        x2 += xDifference;
        y2 += yDifference;
        width = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        setShape();
    }
    
    @Override
    public void resize(double newWidth, double newHeight) {
        System.out.println("Resize called");
        double newLength = newWidth;
        double oldLength = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        System.out.println("Old coordinates: (" + x1 + ", " + y1 +") (" + x2 + ", " + y2 + ")");
        x2  = (newLength / oldLength) * (x2 - x1) + x1;
        y2  = (newLength / oldLength) * (y2 - y1) + y1;
        System.out.println("New coordinates: (" + x1 + ", " + y1 +") (" + x2 + ", " + y2 + ")");
        width = newLength;
        setShape();
    }

    
    protected void setShape(){
        lineShape = new Line2D.Double(x1, y1, x2, y2);
        selectX = Math.min(x1, x2) - 5;
        selectY = Math.min(y1, y2) - 5;
        selectWidth = Math.abs(x1 - x2) + 10;
        selectHeight = Math.abs(y1 - y2) + 10;
        rectangularBoundry = new Rectangle2D.Double(selectX, selectY, selectWidth, selectHeight);
    }
    
    @Override
    public Shape getShape() {
        return rectangularBoundry;
    }
    
    @Override
    public String getType() {
        return "Line";
    }
    
}
