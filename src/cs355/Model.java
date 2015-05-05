package cs355;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
	private ArrayList<Shape> shapes = new ArrayList();
	
	public void add(Shape shape) {
		shapes.add(shape);
	}
}
