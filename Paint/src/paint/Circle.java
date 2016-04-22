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
public class Circle extends Ellipse{
    
    /** Constructors **/
    public Circle(double X, double Y, double w){
        super(X, Y, w, w); // width = height
    }
    public Circle(){
        super();
    }
    
    /** Operations **/
    @Override
    public void draw(){
        System.out.println("Drawing circle");
    }
}
