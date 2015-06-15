package cs355.model;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
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
	private currentImage openImage = null;
	
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



	public currentImage getOpenImage() {
		return openImage;
	}



	public void setOpenImage(currentImage openImage) {
		this.openImage = openImage;
		update();
	}
	
	public void changeImageBrightness(int value) {
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int data = openImage.pixelData[i][j];
				if(data + value > 255) {
					openImage.pixelData[i][j] = 255;
				} else if(data + value < 0 ) {
					openImage.pixelData[i][j] = 0;
				}	else {
					openImage.pixelData[i][j] = data + value;
				}
			}
		}
		update();
	}
	
	public void changeImageConstrast(int value) {
		double scalar = Math.pow((double)(value + 100)/ 100.00, 4);
		
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int data = openImage.pixelData[i][j];
				openImage.pixelData[i][j] = (int)(scalar*(data - 128) + 128);
				
				if(openImage.pixelData[i][j] > 255) {
					openImage.pixelData[i][j] = 255;
				} else if(openImage.pixelData[i][j] < 0 ) {
					openImage.pixelData[i][j] = 0;
				}
			}
		}
		update();
	}
}
