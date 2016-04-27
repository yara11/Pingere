/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    
    /**  **/
    
    public static String selectedBut = null;
    public static Graphics2D graph;
    
    public Paint(){
        // Set environment
        this.setSize(800, 600);//set size
        this.setTitle("Java Paint");//set name
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);//set background color
        
        // Set toolbox
        createToolBox();//where all the buttons are created
        add(new Canvas());
        buttonPanel.add(optionBox);//where all the buttons are set inside and added to the pannel
        this.add(buttonPanel,BorderLayout.NORTH);//we used the pannel to set its positions in the drawing area
        this.setVisible(true);//set its visibilty to true
        
    }
    //Add Action listenr later to the button int the createToolBox method and find out which button the user has pressed
    public JButton createButton(String imgPath,String name){
        JButton ret = new JButton();//Creating JButton
        Icon i = new ImageIcon(imgPath);
        ret.setIcon(i);//Setting it to the images placed in a certaing path (the project's source)
        ret.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
                    selectedBut = name;
    		}
        });
        return ret;
    }
    //Creating the buttons and setting their ImageIcons and the action listner
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
        
        Paint p = new Paint();
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
