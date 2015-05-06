package cs355.view;

import java.awt.Graphics2D;

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
		g2D.fillRect(square.getStartPoint().x, square.getStartPoint().y, square.getSize(), square.getSize());
	}
	
	public void draw(Rectangle rectangle) {
		g2D.fillRect(rectangle.getStartPoint().x, rectangle.getStartPoint().y, rectangle.getWidth(), rectangle.getHeight());
	}
	
	public void draw(Circle circle) {
		g2D.fillOval(circle.getCenter().x - circle.getRadius(), circle.getCenter().y - circle.getRadius(), circle.getRadius()*2, circle.getRadius()*2);
	}
	
	public void draw(Ellipse ellipse) {
		g2D.fillOval(ellipse.getCenter().x - ellipse.getWidth()/2, ellipse.getCenter().y - ellipse.getHeight()/2, ellipse.getWidth(), ellipse.getHeight());
	}
	
	public void draw(Triangle triangle) {
		int[] xCoords = new int[] {triangle.getPoint1().x, triangle.getPoint2().x, triangle.getPoint3().x};
		int[] yCoords = new int[] {triangle.getPoint1().y, triangle.getPoint2().y, triangle.getPoint3().y};
		g2D.fillPolygon(xCoords, yCoords, 3);
	}
	
	public void draw(Shape shape) {
		if (shape != null)
		{
			g2D.setColor(shape.getColor());	
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
