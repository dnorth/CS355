package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

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
	
	@Override
	public boolean within(Point2D point, double tolerance) {
		double x1 = startPoint.x;
		double y1 = startPoint.y;
		double x2 = endPoint.x;
		double y2 = endPoint.y;
		double x0 = point.getX();
		double y0 = point.getY();
		double length = startPoint.distance(endPoint);

		double distance = Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1) / Math.pow(((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)), .5);
	
		return (distance <= tolerance && startPoint.distance(point) <= length + tolerance && endPoint.distance(point) <= length + tolerance);
	}
}
