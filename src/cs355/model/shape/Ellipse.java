package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Ellipse extends Shape{
	
	private double height;
	private double width;
	
	public Ellipse(Color color) {
		super(color);
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public boolean within(Point2D point, double tolerance) {
		return (
			(Math.pow((point.getX() - this.getCenter().getX()) / (width/2), 2) + Math.pow((point.getY() - this.getCenter().getY()) / (height/2), 2)) < 1	
		);
	}
}
