package cs355.model;

import java.util.ArrayList;
import java.util.Observable;

import cs355.model.shape.Shape;

public class Model extends Observable {
	private Shape activeShape;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addActiveShape() {
		shapes.add(activeShape);
		this.setChanged();
		this.notifyObservers();
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
		this.setChanged();
		this.notifyObservers();
	}
}
