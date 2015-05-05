package cs355;

import java.awt.Color;

public abstract class Shape {
	
	private Color color;
	
	public Shape() {
		this.color = Color.BLACK;
	}
	
	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
