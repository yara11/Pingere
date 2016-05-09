/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BasicStroke;
import java.util.ArrayList;

/**
 *
 * @author Krietallo
 */
public class ShapeContainer implements Container{
    float dash1[] = {10.0f};
    BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

    ArrayList<MyShape> shapeList = new ArrayList<MyShape>();
    
    @Override
   public Iterator getIterator() {
      return new ShapeIterator();
   }
   
   void addShape(MyShape s){
       shapeList.add(s);
   }
   
   void removeShape(MyShape s){
       shapeList.remove(s);
   }
   
    void bringFront(MyShape k) {
        shapeList.remove(k);//remove the shape in the back
        shapeList.add(k);//then added again so that it is the newest shape in the ArrayList
    }

    void removeStrokedShape() {
        for (Iterator it = getIterator(); it.hasNext();) {
            MyShape s = (MyShape) it.next();
            if (s.getStroke().equals(dashed)) {
                shapeList.remove(s);
                break;
            }
        }
    }
   
   
   private class ShapeIterator implements Iterator{
       int index = 0;
       
       @Override
       public boolean hasNext(){
           return index < shapeList.size();
       }
       
       @Override
       public MyShape next(){
           if(this.hasNext())
               return shapeList.get(index++);
           return null;
       }
   }
}
