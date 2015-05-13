package cs355.model.shape;

import java.awt.Color;
import java.awt.geom.Point2D;

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
		double firstSign = (point.getX() - point1.getX()) * (point2.getX() - point1.getX());
		System.out.println("\n ------------------------------------ /n");
		return (
				sameSign(firstSign, (point.getY() - point1.getY()) * (point2.getY() - point1.getY())) && 
				sameSign(firstSign, (point.getX() - point2.getX()) * (point3.getX() - point2.getX())) && 
				sameSign(firstSign, (point.getY() - point2.getY()) * (point3.getY() - point2.getY())) && 
				sameSign(firstSign, (point.getX() - point3.getX()) * (point1.getX() - point3.getX())) && 
				sameSign(firstSign, (point.getY() - point3.getY()) * (point1.getY() - point3.getY()))
		);
	}
	
	public boolean sameSign(double a, double b)
	{
		boolean trying = a*b >= 0;
		System.out.println("Comparing a: " + a + " and b: " + b + " ----> " +  trying);
		return trying;
	}
	
}
