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
				point.getX() >= (this.getCenter().getX() - size/2) &&
				point.getX() <= (this.getCenter().getX() + size/2) &&
				point.getY() >= (this.getCenter().getY() - size/2) &&
				point.getY() <= (this.getCenter().getY() + size/2)
		);
	}
}
