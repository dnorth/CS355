package cs355.controller.handler;

import java.awt.Point;

import cs355.controller.MainController;
import cs355.model.shape.Rectangle;

public class RectangleHandler implements DrawingHandler {

	MainController controller;
	Rectangle rectangle;
	Point corner;
	
	public RectangleHandler(MainController controller) {
		this.controller = controller;
		this.rectangle = new Rectangle(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		rectangle.setColor(controller.getColor());
		corner = start;
	}

	@Override
	public void drag(Point end) {


		rectangle.setWidth(Math.abs(end.x - corner.x));
		rectangle.setHeight(Math.abs(end.y - corner.y));
		
		int x, y;
		
		if(end.x < corner.x) {
			x = end.x;
		} else {
			x = corner.x;
		}
		
		if(end.y < corner.y) {
			y = end.y;
		} else {
			y= corner.y;
		}
		
		rectangle.setStartPoint(new Point(x, y));
		controller.getModel().setActiveShape(rectangle);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		rectangle = new Rectangle(controller.getColor());
	}
}
