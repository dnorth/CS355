package cs355.model.shape;

import java.awt.Color;

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

	
}
