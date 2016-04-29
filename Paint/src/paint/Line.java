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

/**
 *
 * @author User
 */
public class Line extends MyShape {
    private double x1, y1, x2, y2;
    private Line2D.Double lineShape;

    /** Constructor **/
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        lineShape = new Line2D.Double(x1, y1, x2, y2);
        selectX = Math.min(x1,x2); selectY = Math.min(y1,y2); 
        selectWidth = Math.abs(x1 - x2); selectHeight = Math.abs(y1 - y2);
    }

    /** Operations **/
    @Override
    public void draw(Graphics2D g) {
        g.setStroke(this.strokeType);
        g.setPaint(this.stroke);
        g.draw(lineShape);
        System.out.println("Drawing Line");
    }

    public void color(Graphics2D g, Color newFill){
        // do nothing here.
    }
    
    public Shape getShape(){
        return lineShape;
    }
}
