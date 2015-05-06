package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape{
	
	private Point center;
	private int radius;	
	
	public Circle(Color color) {
		super(color);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	
}
