package cs355.view;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import cs355.model.shape.Circle;
import cs355.model.shape.Ellipse;
import cs355.model.shape.Line;
import cs355.model.shape.Rectangle;
import cs355.model.shape.Shape;
import cs355.model.shape.Square;
import cs355.model.shape.Triangle;

public class Drawer {
	private Graphics2D g2D;
	
	public Graphics2D getG2D() {
		return g2D;
	}

	public void setG2D(Graphics2D g2d) {
		g2D = g2d;
	}

	public void draw(Line line) {
		g2D.drawLine(line.getStartPoint().x , line.getStartPoint().y, line.getEndPoint().x, line.getEndPoint().y);
	}
	
	public void draw(Square square) {
		g2D.fillRect(-square.getSize()/2, -square.getSize()/2, square.getSize(), square.getSize());
	}
	
	public void draw(Rectangle rectangle) {
		g2D.fillRect((int)(-rectangle.getWidth()/2), (int)(-rectangle.getHeight()/2), (int)rectangle.getWidth(), (int)rectangle.getHeight());
	}
	
	public void draw(Circle circle) {
		g2D.fillOval(-circle.getRadius(), -circle.getRadius(), circle.getRadius() * 2, circle.getRadius() * 2);
	}
	
	public void draw(Ellipse ellipse) {
		g2D.fillOval(-ellipse.getWidth()/2, -ellipse.getHeight()/2, ellipse.getWidth(), ellipse.getHeight());
	}
	
	public void draw(Triangle triangle) {
		int[] xCoords = new int[] {(int)triangle.getPoint1().getX(), (int)triangle.getPoint2().getX(), (int)triangle.getPoint3().getX()};
		int[] yCoords = new int[] {(int)triangle.getPoint1().getY(), (int)triangle.getPoint2().getY(), (int)triangle.getPoint3().getY()};
		g2D.fillPolygon(xCoords, yCoords, 3);
	}
	
	public void draw(Shape shape) {
		if (shape != null)
		{			
			AffineTransform objToWorld = new AffineTransform();
			objToWorld.translate(shape.getCenter().getX(), shape.getCenter().getY());
			objToWorld.rotate(shape.getRotateAngle());
			g2D.setColor(shape.getColor());	
			
			g2D.setTransform(objToWorld);
			
			if(shape instanceof Line) {
				draw((Line) shape);
			} else if (shape instanceof Square){
				draw((Square) shape);
			} else if (shape instanceof Rectangle) {
				draw((Rectangle) shape);
			} else if (shape instanceof Circle) {
				draw((Circle) shape);
			} else if (shape instanceof Ellipse) {
				draw((Ellipse) shape);
			} else if (shape instanceof Triangle) {
				draw((Triangle) shape);
			}
		}
	}
}
