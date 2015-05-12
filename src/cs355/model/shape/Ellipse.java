package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;

public class Ellipse extends Shape{
	
	private int height;
	private int width;
	
	public Ellipse(Color color) {
		super(color);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}
