/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author User
 */
public class Square extends Rectangle{
    
    /** Constructors **/
    public Square(double x1, double y1, double x2, double y2){
        super(x1,y1,x2,y2);
        this.width = Math.min(this.width,this.height);
        this.height = this.width;
        this.rectShape = new Rectangle2D.Double(x,y,width,height);
    }
    
    /** Operations **/
    @Override
    public void draw(Graphics2D g){
        System.out.println("Drawing Square");
    }
}
