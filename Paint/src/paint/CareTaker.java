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
    
    public Memento undo(Memento state){
        if(undoStack.isEmpty())
            return null;
        redoStack.push(state);
        return undoStack.pop();
    }
    
    public Memento redo(Memento state){
        if(redoStack.isEmpty())
            return null;
        undoStack.push(state);
        return redoStack.pop();
    }
    
    public void change(Memento state){
        undoStack.push(state);
        redoStack.clear();
    }
}
