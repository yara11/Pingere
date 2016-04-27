/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author User
 */
public class Line implements MyShape {

    private double x1, y1, x2, y2;
    private Line2D.Double lineShape;
    private Color stroke = Color.BLACK;

    /**
     * Constructors *
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        lineShape = new Line2D.Double(x1, y1, x2, y2);
    }

    /**
     * Operations *
     */
    @Override
    public void draw(Graphics2D g) {
        g.draw(lineShape);
        System.out.println("Drawing Line");
    }

    public Line2D.Double getLine() {
        return lineShape;
    }

    public void setStrokeColor(Color c) {
        stroke = c;
    }

    public Color getStrokeColor() {
        return stroke;
    }

    public void setFillColor(Color c) {
    }

    public Color getFillColor() {
        return null;
    }

    public void fill(Graphics2D g) {

    }
}
