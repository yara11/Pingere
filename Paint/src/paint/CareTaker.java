/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.util.ArrayList;
import java.util.Stack;
import paint.ShapeContainer.Memento;

/**
 *
 * @author User
 */
public class CareTaker {
    private Stack<Memento> undoStack = new Stack<Memento>();
    private Stack<Memento> redoStack = new Stack<Memento>();
    public ArrayList<String> changes = new ArrayList<String>();
    public int size = 0, current = 0;
    
    public Memento undo(Memento state){
        if(undoStack.isEmpty())
            return null;
        redoStack.push(state);
        current--;
        return undoStack.pop();
    }
    
    public Memento redo(Memento state){
        if(redoStack.isEmpty())
            return null;
        undoStack.push(state);
        current++;
        return redoStack.pop();
    }
    
    public void change(Memento state, String action){
        undoStack.push(state);
        if(size == current){
            changes.add(action);
            current++;
            size++;
        }
        else{
            changes.set(current, action);
            current++;
            size = current;
        }
        redoStack.clear();
    }
    
    Memento changeState(int index){
        System.out.println("Current index: "+(current-1));
        Memento m = Paint.canvas.shapes.saveStateToMemento();
        if(index == current)
            return m;
        
        if(index < current){
            int dif = current - index;
            for(int i = 0; i < dif; i++){
                m = undo(m);
            }
            current = index;
        }
        
        else{
            int dif = index - current;
            for(int i = 0; i < dif; i++){
                m = redo(m);
            }
            current = index;
        }
        
        return m;
        /*if(index < current){
            Memento ret = m;
            while(current != index){
                ret = undo(ret);
                current--;
            }
            //current++;
            return ret;
        }
        else{
            Memento ret = m;
            while(current != index){
                ret = redo(ret);
                current++;
            }
            //current--;
            return ret;
        }*/
    }
    
}
