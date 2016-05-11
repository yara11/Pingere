/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Paint extends JFrame{
    /** Toolbox **/
    JPanel buttonPanel = new JPanel();
    JPanel buttonPanel2 = new JPanel();
    JButton lineBut, rectBut,squareBut, ellipseBut, circleBut, triBut, fillBut, strokeBut, select, move, resize, delete, fill, copy, rotate;
    Box optionBox = Box.createHorizontalBox();
    Box toolBox = Box.createVerticalBox();
    
    /**  **/
    
    public static String selectedBut = null;
    public static Color strokeColor = Color.BLACK;
    public static Color fillColor = Color.WHITE;
    
    public Paint(){
        // Set environment
        this.setSize(800, 600);//set size
        this.setTitle("Java Paint");//set name
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);//set background color
        
        // Set toolboxes
        createOptionBox();// Where all the buttons are created
        createToolBox();
        buttonPanel.add(optionBox);//where all the buttons are set inside and added to the pannel
        buttonPanel2.add(toolBox);
        
        // We used the pannel to set its positions in the drawing area
        this.add(buttonPanel,BorderLayout.PAGE_START);
        this.add(buttonPanel2,BorderLayout.WEST);
        Canvas canvas = Canvas.getInstance();
        this.add(canvas);
        this.setVisible(true);// Set its visibilty to true
        
    }
 
    // Creates new button with given icon and name
    public JButton createButton(String imgPath, String name) {
        JButton ret = new JButton();//Creating JButton
        Icon i = new ImageIcon(imgPath);
        ret.setIcon(i);//Setting it to the images placed in a certaing path (the project's source)
        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedBut = name;
                System.out.println(selectedBut);
            }
        });
        return ret;
    }

    //Creating the buttons and setting their ImageIcons and the action listner
    public void createOptionBox() {
        lineBut = createButton("./line.png", "line");
        rectBut = createButton("./rect.png", "rectangle");
        squareBut = createButton("./square.png", "square");
        ellipseBut = createButton("./ellipse.png", "ellipse");
        circleBut = createButton("./circle.png", "circle");
        triBut = createButton("./tri.png", "triangle");
        strokeBut = createButton("./pen.png","stroke");
        
        strokeBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JColorChooser is a popup that lets you pick a color
                Color temp = JColorChooser.showDialog(null, "Pick stroke color", Color.BLACK);
                if(temp != null)    
                    strokeColor = temp;
                System.out.println(strokeColor.toString());
            }
        });
        
        optionBox.add(lineBut);
        optionBox.add(rectBut);
        optionBox.add(squareBut);
        optionBox.add(ellipseBut);
        optionBox.add(circleBut);
        optionBox.add(triBut);
        optionBox.add(strokeBut);
    }
    
    public void createToolBox(){
        select = createButton("./select.png","select");
        fillBut = createButton("./fill.png","fill");
        move = createButton("./move.png","move");
        resize = createButton("./resize.jpg","resize");
        delete = createButton("./delete.png","delete");
        copy =  createButton("./copy.png","copy");
        rotate = createButton("./rotate.png","rotate");
        
        fillBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JColorChooser is a popup that lets you pick a color
                Color temp = JColorChooser.showDialog(null, "Pick fill color", Color.white);
                if(temp != null)    
                    fillColor = temp;
                System.out.println(Paint.fillColor.toString());
            }
        });
        
        toolBox.add(select);
        toolBox.add(fillBut);
        toolBox.add(move);
        toolBox.add(resize);
        toolBox.add(delete);
        toolBox.add(copy);
        toolBox.add(rotate);
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
