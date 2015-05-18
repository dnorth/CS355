package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Rectangle extends Shape{

	//private Point startPoint;
	private double height;
	private double width;
	
	public Rectangle(Color color) {
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
				point.getX() >= (-width/2) &&
				point.getX() <= (width/2) &&
				point.getY() >= (-height/2) &&
				point.getY() <= (height/2)
		);
	}
	
	@Override
	public boolean withinRotator(Point2D point) {
		Point2D rotator = new Point(5, (int)(-this.getHeight()/2 - 19));
		return point.distance(rotator) <= 8;
	}
}
