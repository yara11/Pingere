/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author User
 */
public class Circle extends Ellipse{
    
    /** Constructors **/
    public Circle(double x1, double y1, double x2, double y2){
        super(x1,x2,y1,y2); // width = height
        x = Math.min(x1,x2);
        y = Math.min(y1,y2);
        double a = Math.abs(x1 - x2);
        double b = Math.abs(y1 - y2);
        //this.width = a;
        this.height = this.width = a+b/5;
        ellipseShape = new Ellipse2D.Double(x,y,width,height);
    }
    
}
