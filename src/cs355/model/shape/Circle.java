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
			Math.pow((Math.pow(point.getX() - this.getCenter().getX(), 2) + Math.pow(point.getY() - this.getCenter().getY(), 2)), 0.5) < radius	
		);
	}
}
