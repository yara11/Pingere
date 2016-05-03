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
public class ShapeFactory {
    public MyShape getShape(String shape,double x1,double y1,double x2,double y2){
        //if(shape.equalsIgnoreCase("triangle"))  return new Triangle();
        if(shape.equals("rectangle")) return new Rectangle(x1,y1,x2,y2);
        if(shape.equals("square"))    return new Square(x1,y1,x2,y2);
        if(shape.equals("circle"))    return new Circle(x1,y1,x2,y2);
        if(shape.equals("ellipse"))   return new Ellipse(x1,y1,x2,y2);
        if(shape.equals("line"))      return new Line(x1,y1,x2,y2);
        return null;
    }
}
