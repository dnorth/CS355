package cs355.model.shape;

import java.awt.Color;

public abstract class Shape {
	
	private Color color;
	
	public Shape() {
		this.color = Color.WHITE;
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
