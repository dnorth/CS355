package cs355.controller.handler;

import java.awt.Point;

import cs355.controller.MainController;
import cs355.model.shape.Triangle;

public class TriangleHandler implements DrawingHandler {

	MainController controller;
	Triangle triangle;
	Point currentPoint;
	
	public TriangleHandler(MainController controller) {
		this.controller = controller;
		this.triangle = new Triangle(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		triangle.setColor(controller.getColor());
		currentPoint = start;
	}

	@Override
	public void drag(Point end) {
		currentPoint = end;
	}

	@Override
	public void end() {
		if(triangle.getPoint1() == null) {
			triangle.setPoint1(currentPoint);
		} else if (triangle.getPoint2() == null) {
			triangle.setPoint2(currentPoint);
		} else if (triangle.getPoint3() == null) {
			triangle.setPoint3(currentPoint);
			controller.getModel().setActiveShape(triangle);
			controller.getModel().addActiveShape();
			triangle = new Triangle(controller.getColor());
		}
	}

}
