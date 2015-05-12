package cs355.controller.handler;

import java.awt.Point;
import java.awt.geom.Point2D;

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
		double x = (corner.getX() + end.getX()) / 2;
		double y = (corner.getY() + end.getY()) / 2;
		
		rectangle.setCenter(new Point2D.Double(x, y));
		rectangle.setWidth(Math.abs(end.x - corner.x));
		rectangle.setHeight(Math.abs(end.y - corner.y));
		controller.getModel().setActiveShape(rectangle);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		rectangle = new Rectangle(controller.getColor());
	}
}
