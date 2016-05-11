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
    
    /** Constructor **/
    public Square(double x1, double y1, double x2, double y2){
        super(x1,y1,x2,y2);
        this.width = Math.min(this.width,this.height);
        this.height = this.width;
        this.rectShape = new Rectangle2D.Double(x,y,width,height);
        selectX = x - 10; selectY = y - 10; selectWidth = width + 20; selectHeight = height + 20;
    }
    
    public Square(){}
    
    @Override
    public void resize(double newWidth, double newHeight){
        if(newWidth != width)
            super.resize(newWidth, newWidth);
        else
            super.resize(newHeight, newHeight);
    }
    @Override
    public String getType() {
        return "Square";
    }
}
