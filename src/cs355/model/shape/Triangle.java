package cs355.model.shape;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Vector;

public class Triangle extends Shape{
	private Point2D point1;
	private Point2D point2;
	private Point2D point3;
	
	public Triangle(Color color) {
		super(color);
		point1 = null;
		point2 = null;
		point3 = null;
	}

	public Point2D getPoint1() {
		return point1;
	}

	public void setPoint1(Point2D point1) {
		this.point1 = point1;
	}

	public Point2D getPoint2() {
		return point2;
	}

	public void setPoint2(Point2D point2) {
		this.point2 = point2;
	}

	public Point2D getPoint3() {
		return point3;
	}

	public void setPoint3(Point2D point3) {
		this.point3 = point3;
	}
	
	@Override
	public boolean within(Point2D point, double tolerance) {
		boolean b1, b2, b3;
				
		b1 = sign(point, point1, point2) < 0;
		b2 = sign(point, point2, point3) < 0;
		b3 = sign(point, point3, point1) < 0;
		return ((b1 == b2) && (b2 == b3));
	}
		
	
	public double sign(Point2D point1, Point2D point2, Point2D point3)
	{
	    return (point1.getX() - point3.getX()) * (point2.getY() - point3.getY()) - (point2.getX() - point3.getX()) * (point1.getY() - point3.getY());

	}
	
	@Override

	public boolean withinRotator(Point2D point) {
		double x = (getPoint1().getX() +  getPoint2().getX() + getPoint3().getX())/3;
		double y = Math.min(Math.min(getPoint1().getY(), getPoint2().getY()), getPoint3().getY());
		Point2D rotator = new Point2D.Double((int)x+5, (int)y-20);
		return (point.distance(rotator) <= 8);
	}
	
}
