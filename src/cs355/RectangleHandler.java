package cs355;

import java.awt.Point;

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
		//TODO add line to the model
		rectangle.setColor(controller.getColor());
		rectangle.setStartPoint(start);
		corner = start;
		rectangle.setWidth(start.x);
		rectangle.setHeight(start.y);
	}

	@Override
	public void drag(Point end) {

		if(end.x < corner.x) {
			rectangle.setStartPoint(end);
			rectangle.setWidth(corner.x - end.x);
		} else {
			rectangle.setWidth(Math.abs(end.x - rectangle.getStartPoint().x));
		}
		
		if(end.y < corner.y) {
			rectangle.setStartPoint(end);
			rectangle.setHeight(corner.y - end.y);
		} else {
			rectangle.setHeight(Math.abs(end.y - rectangle.getStartPoint().y));
		}
		
		controller.getModel().setActiveShape(rectangle);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		rectangle = new Rectangle(controller.getColor());
	}
}
