package cs355.controller.handler;

import java.awt.Point;

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
		
		int x, y;
		if(end.x < corner.x) {
			x = corner.x - square.getSize();
		} else {
			x = corner.x;
		}
		
		if(end.y < corner.y) {
			y = corner.y - square.getSize();
		} else {
			y= corner.y;
		}
		
		square.setStartPoint(new Point(x, y));
		controller.getModel().setActiveShape(square);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		square = new Square(controller.getColor());
	}

}
