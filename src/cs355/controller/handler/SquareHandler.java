package cs355.controller.handler;

import java.awt.Point;
import java.awt.geom.Point2D;

import cs355.controller.MainController;
import cs355.model.shape.Square;

public class SquareHandler implements DrawingHandler {

	MainController controller;
	Square square;
	Point corner;
	
	public SquareHandler(MainController controller) {
		this.controller = controller;
		this.square = new Square(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		square.setColor(controller.getColor());
		corner = start;
	}

	@Override
	public void drag(Point end) {
		square.setSize(Math.min(Math.abs(end.y - corner.y), Math.abs(end.x - corner.x)));
		
		double x, y;
		if(end.x < corner.x) {
			x = corner.x - square.getSize()/2;
		} else {
			x = corner.x + square.getSize()/2;
		}
		
		if(end.y < corner.y) {
			y = corner.y - square.getSize()/2;
		} else {
			y= corner.y + square.getSize()/2;
		}
		
		square.setCenter(new Point2D.Double(x, y));
		controller.getModel().setActiveShape(square);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		square = new Square(controller.getColor());
	}

}
