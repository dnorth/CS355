package cs355;

import java.awt.Point;

public interface DrawingHandler {
	public void start(Point start);
	public void drag(Point end);
	public void end();
}
