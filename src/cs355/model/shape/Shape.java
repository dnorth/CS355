package cs355.model.shape;

import java.awt.Color;
import java.awt.geom.Point2D;

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
	
}
