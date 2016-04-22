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
public class Square extends Rectangle{
    
    /** Constructors **/
    public Square(double X, double Y, double w){
        super(X,Y,w,w);
    }
    public Square(){
        super();
    }
    
    /** Operations **/
    @Override
    public void draw(){
        System.out.println("Drawing Square");
    }
}
