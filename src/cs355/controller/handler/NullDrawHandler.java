package cs355.controller.handler;

import java.awt.Point;

public class NullDrawHandler implements DrawingHandler {

	@Override
	public void start(Point start) {}

	@Override
	public void drag(Point end) {}

	@Override
	public void end() {}

}
