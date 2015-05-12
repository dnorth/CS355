package cs355.model.shape;

import java.awt.Color;

public class Square extends Shape{

	private int size;	
	
	public Square(Color color) {
		super(color);
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	
	
}
