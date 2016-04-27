/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author User
 */
public class Ellipse implements MyShape{
    protected double x, y, width, height;
    protected Ellipse2D.Double ellipseShape;
    protected Color fill = Color.WHITE, stroke = Color.BLACK;
    
    /** Constructors **/
    public Ellipse(double x1, double y1, double x2, double y2){
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        
        ellipseShape = new Ellipse2D.Double(x,y,width,height);
    }
    
    /** Operations **/
    @Override
    public void draw(Graphics2D g){
        System.out.println("Drawing Ellipse");
    }
}
