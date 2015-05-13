package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;

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
}
