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
public abstract class MyShape implements Cloneable {

    protected double x, y, width, height;
    // these parameters are used to draw a rectangle around shape when selected
    protected double selectX, selectY, selectWidth, selectHeight;
    // graphics attributes
    protected Color fill = null, stroke = Color.BLACK;
    protected Stroke strokeType = new BasicStroke(4);
    protected double angle = 0;

    // functionality methods
    public abstract void draw(Graphics2D g);

    public abstract void color(Color newFill);

    public abstract void resize(double newWidth, double newHeight);

    public abstract void move(double xDifference, double yDifference);

    public void rotate(double angle) {
        this.angle += angle;
    }

    

//public abstract void delete(Graphics2D g);
    public MyShape copy() {
        MyShape temp = (MyShape) this.clone();
        return temp;
    }

    // getters & setters
    public abstract String getType();

    public abstract Shape getShape();

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
    public double getAngle() {
        return angle;
    }

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

    public Stroke getStroke() {
        return strokeType;
    }

    protected abstract void setShape();

    // when shape is selected a red, dashed rectangle is drawn around it
    public Rectangle drawSelectRectangle() {
        Rectangle z = new Rectangle(selectX, selectY, selectWidth + selectX, selectHeight + selectY);
        float dash1[] = {10.0f};
        BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        z.strokeType = dashed;
        z.stroke = Color.red;
        return z;

    }

    // Using Prototype design pattern
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    /*public void rotate(Graphics2D g) {

        System.out.println(x + " " + y);
        if(angle!=0)
            g.rotate(Math.toRadians(angle),0,0);
            g.draw(this.getShape());
    }*/
}
