package cs355.view;

import java.awt.geom.Point2D;

import cs355.Matrix_4;
import cs355.Vector_4;

public class Camera {

	public double x, y, z;
	public double angle = 0;
	
	double fov = 60, near = 1, far = 50;
	double zoom = 1/Math.tan(Math.toRadians(fov / 2));
	double WIDTH = 2048;
	double HEIGHT = 2048;
	
	public Camera(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Matrix_4 getWorldToCameraMatrix() {
		double c = Math.cos(Math.toRadians(angle));
		double s = Math.sin(Math.toRadians(angle));
		Matrix_4 p = new Matrix_4(
				1, 0, 0, -x,
				0, 1, 0, -y,
				0, 0, 1, -z,
				0, 0, 0, 1
		);
		p.dot(
				c, 0, s, 0,
				0, 1, 0, 0,
			   -s, 0, c, 0,
			    0, 0, 0, 1
		);
			
		return p;
	}
	
	public Vector_4 getClipMatrix(Vector_4 matrix) {
		matrix.dot(new Matrix_4(
					zoom, 0, 0, 0,
					0, zoom, 0, 0,
					0, 0, (far + near) / (far-near), (-2*far*near)/ (far-near),
					0, 0, 1, 0
				));
		
		matrix.setX1(matrix.getX1() / matrix.getF1());
		matrix.setY1(matrix.getY1() / matrix.getF1());
		matrix.setZ1(matrix.getZ1() / matrix.getF1());
		matrix.setF1(1);
		
		return matrix;
	}
	
	public boolean isWithinView(Vector_4 vector) {
		return (vector.getX1() < 1 && vector.getX1() > -1 && 
				vector.getY1() < 1 && vector.getY1() > -1 &&
				vector.getZ1() < 1 && vector.getZ1() > -1);
	}
	
	public Point2D getScreenPoint(Vector_4 vector) {
		Point2D p = new Point2D.Double();
		p.setLocation(
				((WIDTH/2) * vector.getX1() + (WIDTH/2)) + .5, 
				-(((-HEIGHT/2) * vector.getY1() + (HEIGHT/2)) + .5)
		);
		
		return p;
	}
}
