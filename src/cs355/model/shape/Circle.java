package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape{
	
	private int radius;	
	
	public Circle(Color color) {
		super(color);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	
}
