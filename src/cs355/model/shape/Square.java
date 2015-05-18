package cs355.model.shape;

import java.awt.Color;
import java.awt.geom.Point2D;

public class Square extends Shape{

	private double size;	
	
	public Square(Color color) {
		super(color);
	}

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public boolean within(Point2D point, double tolerance) {
		return (
				point.getX() >= (-size/2) &&
				point.getX() <= (size/2) &&
				point.getY() >= (-size/2) &&
				point.getY() <= (size/2)
		);
	}
	
	@Override
	public boolean withinRotator(Point2D point) {
		Point2D rotator = new Point2D.Double(5, (int)(-this.getSize()/2 - 20));
		return point.distance(rotator) <= 8;
	}
}
