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
    public Shape getShape(String shape){
        if(shape.equalsIgnoreCase("triangle"))  return new Triangle();
        if(shape.equalsIgnoreCase("rectangle")) return new Rectangle();
        if(shape.equalsIgnoreCase("square"))    return new Square();
        if(shape.equalsIgnoreCase("circle"))    return new Circle();
        if(shape.equalsIgnoreCase("ellipse"))   return new Ellipse();
        if(shape.equalsIgnoreCase("line"))      return new Line();
        return null;
    }
}
