package cs355.controller.handler;

import java.awt.Point;
import java.awt.geom.Point2D;

import cs355.controller.MainController;
import cs355.model.shape.Circle;

public class CircleHandler implements DrawingHandler {

	MainController controller;
	Circle circle;
	Point corner;
	
	public CircleHandler(MainController controller) {
		this.controller = controller;
		this.circle = new Circle(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		circle.setColor(controller.getColor());
		corner = start;
	}

	@Override
	public void drag(Point end) {
		circle.setRadius(Math.min(Math.abs((end.y - corner.y)), Math.abs((end.x - corner.x)))/2);
	
		double x, y;
		if(end.x < corner.x) {
			x = corner.x - circle.getRadius();
		} else {
			x = corner.x + circle.getRadius();
		}
		
		if(end.y < corner.y) {
			y = corner.y - circle.getRadius();
		} else {
			y= corner.y + circle.getRadius();
		}
		
		circle.setCenter(new Point2D.Double(x, y));
		controller.getModel().setActiveShape(circle);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		controller.getModel().addActiveShape();
		circle = new Circle(controller.getColor());
	}

}
