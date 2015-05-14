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
		double rx = width/2.0;
		double ry = height/2.0;
		return (
			(point.getX() * point.getX() / (rx * rx) + point.getY() * point.getY() / (ry*ry)) <= 1	
		);
	}
	
	@Override
	public boolean withinRotator(Point2D point) {
		Point2D rotator = new Point(5, (int)(-this.getHeight()/2 - 20));
		if (point.distance(rotator) <= 8) return true;
		else return false;

	}
}
