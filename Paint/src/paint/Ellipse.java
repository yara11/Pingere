/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author User
 */
public class Ellipse extends MyShape {

    //protected double x, y, width, height;
    protected Ellipse2D.Double ellipseShape;
    //protected Color fill = Color.WHITE, stroke = Color.BLACK;

    /**
     * Constructors *
     */
    
    public Ellipse(double x1, double y1, double x2, double y2) {
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        setShape();
    }
    
    public Ellipse(){}
    
    /**
     * Operations
     *
     * @param g *
     */
    @Override
    public void draw(Graphics2D g) {
        System.out.println("Drawing Ellipse");
        g.setStroke(this.strokeType);
        g.setPaint(this.stroke);
        g.draw(ellipseShape);
        if (this.fill != null) {
            g.setPaint(this.fill);
            g.fill(ellipseShape);
        }
    }

    @Override
    public void color(Color newFill) {
        this.setFillColor(newFill);
    }

    public void move(double xDifference, double yDifference) {
        x += xDifference;
        y += yDifference;
        setShape();
    }
    
    @Override
    public void resize(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
        setShape();
    }

    
    /*public void rotate(Graphics2D g) {
        
        g.translate(100, 100);
        g.draw(ellipseShape);
        System.out.println(x+" "+y);
        if (this.fill != null) {
            g.setPaint(this.fill);
            g.fill(ellipseShape);
        }
        //g.rotate(Math.toRadians(45));
        //draw(g);
    }*/
    
    protected void setShape(){
        ellipseShape = new Ellipse2D.Double(x, y, width, height);
        selectX = x - 10;
        selectY = y - 10;
        selectWidth = width + 20;
        selectHeight = height + 20;
    }

    @Override
    public Shape getShape() {
        return ellipseShape;
    }
    
    public String getType() {
        return "Ellipse";
    }

}
