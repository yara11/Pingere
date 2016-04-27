/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author User
 */
public interface MyShape{
    public void draw(Graphics2D g);
    public void fill(Graphics2D g);
    public void setStrokeColor(Color c);
    public Color getStrokeColor();
    public void setFillColor(Color c);
    public Color getFillColor();
    //public void color(Graphics2D g);
    
}
