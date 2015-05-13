package cs355.controller.handler;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

import cs355.controller.MainController;
import cs355.model.shape.Shape;

public class SelectionHandler implements DrawingHandler{

	MainController controller;
	Point2D point = new Point2D.Double();
	
	public SelectionHandler(MainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void start(Point start) {
		this.point = start;
	}

	@Override
	public void drag(Point end) {
		this.point = end;
		controller.getModel().getSelectedShape();
		
	}

	@Override
	public void end() {
		controller.getModel().setSelectedShape(point, 4);
	}
	
	public void changeColor(Color c) {
		controller.getModel().setSelectedColor(controller.getModel().getSelectedShape(), c);
	}

}
