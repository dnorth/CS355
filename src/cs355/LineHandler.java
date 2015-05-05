package cs355;

import java.awt.Point;

public class LineHandler implements DrawingHandler {

	MainController controller;
	Line line;
	
	public LineHandler(MainController controller) {
		this.controller = controller;
		this.line = (Line)controller.getShape();
	}
	
	@Override
	public void start(Point start) {
		//TODO add line to the model
		//controller.getModel().add(line);
		line.setStartPoint(start);
		line.setEndPoint(start);
	}

	@Override
	public void drag(Point end) {
		line.setEndPoint(end);
		GUIFunctions.refresh();
	}

	@Override
	public void end() {
		line = null;
		GUIFunctions.refresh();
	}

}
