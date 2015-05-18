package cs355.model.shape;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import cs355.view.CustomAffineTransform;

public abstract class Shape {
	
	private Color color;
	private Point2D center; 
	private double rotateAngle;
	private boolean selected;

	public Shape() {
		this.color = Color.WHITE;
		this.center = new Point2D.Double();
		this.rotateAngle = 0;
		this.selected = false;
	}
	
	public Shape(Color color) {
		this.color = color;
		this.center = new Point2D.Double();
		this.rotateAngle = 0;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Point2D getCenter() {
		return center;
	}

	public void setCenter(Point2D p) {
		center.setLocation(p);
	}

	public double getRotateAngle() {
		return rotateAngle;
	}

	public void setRotateAngle(double rotateAngle) {
		this.rotateAngle = rotateAngle;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean within(Point2D point, double tolerance) { return false; };
	
	public AffineTransform objToWorld()
	{
		AffineTransform objToWorld = new CustomAffineTransform();
		//Add .5 to round and make sure the double isn't converted weirdly
		objToWorld.translate(this.getCenter().getX() + .5, this.getCenter().getY() + .5);
		objToWorld.rotate(this.getRotateAngle());
		return objToWorld;
	}
	
	public AffineTransform worldToObj()
	{
		AffineTransform worldToObj = new CustomAffineTransform();
		worldToObj.rotate(-this.getRotateAngle());
		//Subtract .5 to round and make sure the double isn't converted weirdly
		worldToObj.translate(-this.getCenter().getX() - .5, -this.getCenter().getY() - .5);
		return worldToObj;
	}

	public boolean withinRotator(Point2D p) { return false; };
}
