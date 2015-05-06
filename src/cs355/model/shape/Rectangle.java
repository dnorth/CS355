package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape{

	private Point startPoint;
	private int height;
	private int width;
	
	public Rectangle(Color color) {
		super(color);
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
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
