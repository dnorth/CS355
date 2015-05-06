package cs355;

import java.awt.Point;

public class SquareHandler implements DrawingHandler {

	MainController controller;
	Square square;
	
	public SquareHandler(MainController controller) {
		this.controller = controller;
		this.square = new Square(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		//TODO add line to the model
		square.setColor(controller.getColor());
		square.setStartPoint(start);
		square.setSize(start.x);
	}

	@Override
	public void drag(Point end) {
		square.setSize(end.x - square.getStartPoint().x);
		controller.getModel().setActiveShape(square);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		square = new Square(controller.getColor());
	}

}
