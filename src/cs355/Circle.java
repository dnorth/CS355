package cs355;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape{
	

	private Point startPoint;
	private double radius;
	private int width;
	
	
	public Circle(Color color) {
		super(color);
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
