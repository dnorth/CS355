package cs355.model.shape;

import java.awt.Color;
import java.awt.geom.Point2D;

public class Circle extends Shape{
	
	private double radius;	
	
	public Circle(Color color) {
		super(color);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public boolean within(Point2D point, double tolerance) {
		return (
			(point.getX() * point.getX()) / (radius * radius) + (point.getY() * point.getY()) / (radius*radius) <= 1	
		);
	}
	
	@Override
	public boolean withinRotator(Point2D point) {
		Point2D rotator = new Point2D.Double(5, (int)(-this.getRadius() - 20));
		return point.distance(rotator) <= 8;
	}
}
