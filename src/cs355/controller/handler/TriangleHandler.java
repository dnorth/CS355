package cs355.controller.handler;

import java.awt.Point;
import java.awt.geom.Point2D;

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
		//Get World Coordinates
		if(triangle.getPoint1() == null) {
			triangle.setPoint1(currentPoint);
		} else if (triangle.getPoint2() == null) {
			triangle.setPoint2(currentPoint);
		} else if (triangle.getPoint3() == null) {
			triangle.setPoint3(currentPoint);
			
			double centerX = (triangle.getPoint1().getX() + triangle.getPoint2().getX() + triangle.getPoint3().getX()) / 3;
			double centerY = (triangle.getPoint1().getY() + triangle.getPoint2().getY() + triangle.getPoint3().getY()) / 3;
			triangle.setCenter(new Point2D.Double(centerX, centerY));
			
			//Set Triangle Corners based on Object Coordinates
			triangle.setPoint1(new Point2D.Double(triangle.getPoint1().getX() - centerX, triangle.getPoint1().getY() - centerY));
			triangle.setPoint2(new Point2D.Double(triangle.getPoint2().getX() - centerX, triangle.getPoint2().getY() - centerY));
			triangle.setPoint3(new Point2D.Double(triangle.getPoint3().getX() - centerX, triangle.getPoint3().getY() - centerY));
			
			controller.getModel().setActiveShape(triangle);
			controller.getModel().addActiveShape();
			triangle = new Triangle(controller.getColor());
		}
	}

}
