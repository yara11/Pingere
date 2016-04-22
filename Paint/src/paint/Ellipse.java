/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

/**
 *
 * @author User
 */
public class Ellipse implements Shape{
    private double x, y, width, height;
    
    /** Constructors **/
    public Ellipse(double X, double Y, double w, double h){
        x = X;
        y = Y;
        width = w;
        height = h;
    }
    public Ellipse(){}
    
    /** Operations **/
    @Override
    public void draw(){
        System.out.println("Drawing Ellipse");
    }
}
