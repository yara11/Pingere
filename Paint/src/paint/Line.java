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
public class Line implements Shape{
    private double x1, y1, x2, y2;
    
    /** Constructors **/
    public Line(double x1,double y1,double x2,double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Line(){}
    
    /** Operations **/
    @Override
    public void draw(){
        System.out.println("Drawing Line");
    }
}
