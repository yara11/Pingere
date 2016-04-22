/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Paint extends JFrame{
    /** Toolbox **/
    JPanel buttonPanel = new JPanel();
    JButton lineBut = new JButton("Line");
    JButton rectBut = new JButton("Rectangle");
    JButton squareBut = new JButton("Square");
    JButton ellipseBut = new JButton("Ellipse");
    JButton circleBut = new JButton("Circle");
    JButton triBut = new JButton("Triangle");
    Box optionBox = Box.createHorizontalBox();
    //JComponent drawingSpace = new JComponent();
    
    /**  **/
    
    public static String selectedBut = null;
    public static Graphics2D graph;
    
    public Paint(){
        // Set environment
        this.setSize(800, 600);
        this.setTitle("Java Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set toolbox
        createToolBox();
        buttonPanel.add(optionBox);
        this.add(buttonPanel,BorderLayout.NORTH);
        this.setVisible(true);
    }
    
    public JButton createButton(String imgPath,String name){
        JButton ret = new JButton();
        Icon i = new ImageIcon(imgPath);
        ret.setIcon(i);
        ret.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
                    selectedBut = name;
    		}
        });
        return ret;
    }
    
    public void createToolBox(){
        lineBut = createButton("./line.png", "line");
        rectBut = createButton("./rect.png", "rectangle");
        squareBut = createButton("./square.png", "square");
        ellipseBut = createButton("./ellipse.png", "ellipse");
        circleBut = createButton("./circle.png", "circle");
        triBut = createButton("./tri.png", "triangle");
        
        optionBox.add(lineBut);
        optionBox.add(rectBut);
        optionBox.add(squareBut);
        optionBox.add(ellipseBut);
        optionBox.add(circleBut);
        optionBox.add(triBut);
    }
    
    public static void main(String[] args) {
        Paint newPaint = new Paint();
        
        /*// TEST FACTORY
        ShapeFactory f = new ShapeFactory();
        Line l = (Line)f.getShape("line");
        Circle c = (Circle)f.getShape("CIRCLE");
        Rectangle r = (Rectangle)f.getShape("rEctangle");
        l.draw();
        c.draw();
        r.draw();
        // OK GOOD...*/
    }
    
}
