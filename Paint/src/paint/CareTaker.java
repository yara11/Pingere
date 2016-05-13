/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.util.Stack;
import paint.ShapeContainer.Memento;

/**
 *
 * @author User
 */
public class CareTaker {
    private Stack<Memento> undoStack = new Stack<Memento>();
    private Stack<Memento> redoStack = new Stack<Memento>();
    
    /*public void addToUndo(Memento state){
        undoStack.push(state);
    }
    
    public Memento getFromUndo(){
        if(undoStack.empty())
            return null;
        return undoStack.pop();
    }
    
    public void addToRedo(Memento state){
        redoStack.push(state);
    }
    
    public Memento getFromRedo(){
        if(redoStack.empty())
            return null;
        return redoStack.pop();
    }
    
    public void clearRedo(){
        redoStack.clear();
    }*/
    
    public Memento undo(Memento state){
        if(undoStack.empty())
            return null;
        redoStack.push(state);
        return undoStack.pop();
    }
    
    public Memento redo(Memento state){
        if(redoStack.empty())
            return null;
        undoStack.push(state);
        return redoStack.pop();
    }
    
    public void change(Memento state){
        undoStack.push(state);
        redoStack.clear();
    }
}
