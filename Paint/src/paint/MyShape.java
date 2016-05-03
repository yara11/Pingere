/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

/**
 *
 * @author User
 */
public abstract class MyShape{
    protected double x, y, width, height;
    // index of drawn shape
    private int index;
    // these parameters are used to draw a rectangle around shape when selected
    protected double selectX, selectY, selectWidth, selectHeight; 
    // graphics attributes
    protected Color fill = null, stroke = Color.BLACK;
    //We have option of trasparency or white
    //protected Color newfFill = Color.WHITE;
    protected Stroke strokeType = new BasicStroke (4);
    
    // functionality methods
    public abstract void draw(Graphics2D g);
    public abstract void color(Graphics2D g, Color newFill);
    
    public abstract void resize(double newWidth, double newHeight);
    public abstract void move(double xDifference, double yDifference);
    //public abstract void delete(Graphics2D g);
    public abstract String getType();
    
    public abstract Shape getShape();
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    
    // getters and setters
    public void setStrokeColor(Color c) {
        stroke = c;
    }

    public Color getStrokeColor() {
        return stroke;
    }

    public void setFillColor(Color c) {
        fill = c;
    }

    public Color getFillColor() {
        return fill;
    }
    
    public void setIndex(int x){
        index = x;
    }
    
    public int getIndex(){
        return index;
    }
    
    public Stroke getStroke(){
        return strokeType;
    }
    
    // when shape is selected a red, dashed rectangle is drawn around it
    public Rectangle drawSelectRectangle(){
            Rectangle z = new Rectangle(selectX, selectY, selectWidth + selectX, selectHeight + selectY);
            float dash1[] = {10.0f};
            BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
            z.strokeType = dashed;
            z.stroke = Color.red;
            return z;
            
    }
}
