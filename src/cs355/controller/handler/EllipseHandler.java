package cs355.controller.handler;

import java.awt.Point;
import java.awt.geom.Point2D;

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
			x = corner.x - ellipse.getWidth()/2;
		} else {
			x = corner.x + ellipse.getWidth()/2;
		}
		
		if(end.y < corner.y) {
			y = corner.y - ellipse.getHeight()/2;
		} else {
			y= corner.y + ellipse.getHeight()/2;
		}
		
		ellipse.setCenter(new Point2D.Double(x, y));
		controller.getModel().setActiveShape(ellipse);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		ellipse = new Ellipse(controller.getColor());
	}

}
