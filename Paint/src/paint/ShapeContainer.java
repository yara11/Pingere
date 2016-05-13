/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BasicStroke;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Krietallo
 */

// MEMENTO AND ITERATOR PATTERNS APPLIED TO SHAPECONTAINER
// PROXY DESIGN PATTERN, THE SHAPECONTAINER IS PROXY CLASS FOR THE ARRAYLIST : SHAPELIST
public class ShapeContainer implements Container {

    private final float dash1[] = {10.0f};
    private final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
    private ArrayList<MyShape> shapeList = new ArrayList<MyShape>();

    @Override
    public Iterator getIterator() {
        return new ShapeIterator();
    }

    void addShape(MyShape s) {
        shapeList.add(s);
    }

    void removeShape(MyShape s) {
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
    
    MyShape getSelectedShape(Point p) {
        MyShape ret = null;
        for (Iterator it = getIterator(); it.hasNext();) {
            MyShape sh = (MyShape) it.next();
            if (sh.getShape().contains(p)) {
                if (sh.getStroke().equals(dashed)) {
                    continue;
                }
                ret = sh;
            }
        }
        return ret;
    }
    
    private class ShapeIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < shapeList.size();
        }

        @Override
        public MyShape next() {
            if (this.hasNext()) {
                return shapeList.get(index++);
            }
            return null;
        }
    }

    // MEMENTO DESIGN PATTERN IMPLEMENTATION 
    public void setState(ArrayList<MyShape> newState) {
        // Shallow copy
        shapeList = newState;
        // Deep copy
        /*shapeList = new ArrayList<MyShape>();
        for (MyShape shape : newState) {
            shapeList.add((MyShape)shape.clone());
        }*/
    }
    
    public ArrayList<MyShape> getState(){
        return shapeList;
    }
    
    public Memento saveStateToMemento(){
        return new Memento(shapeList);
    }
    
    public void getStateFromMemento(Memento memento){
        shapeList = memento.getState();
    }
    
    public class Memento {

        private ArrayList<MyShape> state;

        public Memento(ArrayList<MyShape> newState) {
            // Deep copy
            state = new ArrayList<MyShape>();
            for (MyShape shape : newState) {
                state.add((MyShape)shape.clone());
            }
        }

        public ArrayList<MyShape> getState() {
            return state;
        }
    }
}
