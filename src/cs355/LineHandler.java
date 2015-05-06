package cs355;

import java.awt.Point;

public class LineHandler implements DrawingHandler {

	MainController controller;
	Line line;
	
	public LineHandler(MainController controller) {
		this.controller = controller;
		this.line = new Line(controller.getColor());
	}
	
	@Override
	public void start(Point start) {
		//TODO add line to the model
		line.setColor(controller.getColor());
		line.setStartPoint(start);
		line.setEndPoint(start);
	}

	@Override
	public void drag(Point end) {
		line.setEndPoint(end);
		controller.getModel().setActiveShape(line);
	}

	@Override
	public void end() {
		controller.getModel().addActiveShape();
		line = new Line(controller.getColor());
	}

}
