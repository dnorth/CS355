package cs355;

import java.awt.Color;
import java.awt.Point;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	
	public Line(Color color){
		super(color);
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
}
