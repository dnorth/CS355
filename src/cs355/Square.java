package cs355;

import java.awt.Color;
import java.awt.Point;

public class Square extends Shape{

	private Point startPoint;
	private int size;	
	
	public Square(Color color) {
		super(color);
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	
	
}
