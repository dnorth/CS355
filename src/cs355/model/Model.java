package cs355.model;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;

import cs355.model.shape.Circle;
import cs355.model.shape.Ellipse;
import cs355.model.shape.Line;
import cs355.model.shape.Rectangle;
import cs355.model.shape.Shape;
import cs355.model.shape.Square;
import cs355.model.shape.Triangle;

public class Model extends Observable {
	private Shape activeShape;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private BufferedImage openImage = null;
	
	public void addActiveShape() {
		shapes.add(activeShape);
		update();
	}

	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Shape getActiveShape() {
		return activeShape;
	}

	public void setActiveShape(Shape activeShape) {
		this.activeShape = activeShape;
		update();
	}
	
	public void setSelectedShape(Point2D worldPoint, double tolerance) {
		Shape selected = null;
		for (Shape shape : shapes) {
			AffineTransform worldToObj = new AffineTransform();
			worldToObj.rotate(-1 * shape.getRotateAngle());
			worldToObj.translate(-1 * shape.getCenter().getX(), -1 * shape.getCenter().getY());
			
			Point2D objCoord = new Point2D.Double();
			worldToObj.transform(worldPoint, objCoord);
			
			if(shape.within(objCoord, tolerance))
			{
				selected = shape;
			}
			shape.setSelected(false);
		}
		if(selected != null)
		{
			selected.setSelected(true);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void deselectAll() {
		for (Shape shape : shapes) {
			shape.setSelected(false);
		}
		update();
	}
	
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public Shape getSelectedShape() {
		for (Shape shape : shapes) {
			if(shape.isSelected())
			{
				return shape;
			}
		}
		
		return null;
	}
	
	public void setSelectedColor(Shape shape, Color c) {
		shape.setColor(c);
		update();
	}



	public BufferedImage getOpenImage() {
		return openImage;
	}



	public void setOpenImage(BufferedImage openImage) {
		this.openImage = openImage;
		update();
	}
}
