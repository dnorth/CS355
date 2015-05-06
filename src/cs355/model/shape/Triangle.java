package cs355.model.shape;

import java.awt.Color;
import java.awt.Point;

public class Triangle extends Shape{
	private Point point1;
	private Point point2;
	private Point point3;
	
	public Triangle(Color color) {
		super(color);
		point1 = null;
		point2 = null;
		point3 = null;
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public Point getPoint3() {
		return point3;
	}

	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	
	
}
