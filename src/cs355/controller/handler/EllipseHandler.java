package cs355.controller.handler;

import java.awt.Point;

import cs355.controller.MainController;
import cs355.model.shape.Ellipse;

public class EllipseHandler implements DrawingHandler {

	MainController controller;
	Ellipse ellipse;
	Point corner;
	
	public EllipseHandler(MainController controller) {
		this.controller = controller;
		this.ellipse = new Ellipse(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		ellipse.setColor(controller.getColor());
		corner = start;
	}

	@Override
	public void drag(Point end) {
		ellipse.setWidth(Math.abs(end.x - corner.x));
		ellipse.setHeight(Math.abs(end.y - corner.y));
		
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
		
		ellipse.setCenter(new Point(x + ellipse.getWidth()/2, y + ellipse.getHeight()/2));
		controller.getModel().setActiveShape(ellipse);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		ellipse = new Ellipse(controller.getColor());
	}

}
