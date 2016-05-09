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
    
    /** Constructor **/
    public Circle(double x1, double y1, double x2, double y2){
        super(x1,y1,x2,y2); // width = height
        //x = Math.min(x1,x2);
        //y = Math.min(y1,y2);
        //double a = Math.abs(x1 - x2);
        //double b = Math.abs(y1 - y2);
        //this.width = a;
        //this.height = this.width = a+b/5;
        this.height = this.width = Math.max(this.width, this.height);
        ellipseShape = new Ellipse2D.Double(x,y,width,height);
        selectX = x - 10; selectY = y - 10; selectWidth = width + 20; selectHeight = height + 20;
    }
    public Circle(){
    }
    @Override
    public void resize(double newWidth, double newHeight){
        super.resize(Math.min(newWidth, newHeight),Math.min(newWidth, newHeight));
    }
    @Override
    public String getType() {
        return "Circle";
    }
}
