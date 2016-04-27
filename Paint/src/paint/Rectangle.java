/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author User
 */
public class Rectangle implements MyShape{
    protected double x, y, width, height;
    protected Rectangle2D.Double rectShape;
    protected Color fill = Color.WHITE, stroke = Color.BLACK;
    
    /** Constructors **/
    public Rectangle(double x1, double y1, double x2, double y2){
        x = Math.min(x1,x2);
        y = Math.min(y1,y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        rectShape = new Rectangle2D.Double(x,y,width,height);
    }
    
    /** Operations
     * @param g **/
    @Override
    public void draw(Graphics2D g){
        System.out.println("Drawing rectangle");
        g.draw(rectShape);
    }
    public Rectangle2D.Double getRect(){
        return rectShape;
    }
}
