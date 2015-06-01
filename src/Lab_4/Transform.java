package Lab_4;

import java.awt.Color;

public class Transform {

	int displacement;
	float angle;
	Color color;
	public Transform(int displacement, float angle, Color color) {
		super();
		this.displacement = displacement;
		this.angle = angle;
		this.color = color;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public float getAngle() {
		return angle;
	}
	public void setAngle(float angle) {
		this.angle = angle;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
