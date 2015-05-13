package cs355.view;

import java.awt.Color;
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
	private Shape currentShape;
	
	public Graphics2D getG2D() {
		return g2D;
	}

	public void setG2D(Graphics2D g2d) {
		g2D = g2d;
	}

	public void draw(Line line) {
		if(line.isSelected())
		{
			drawHandle(line.getStartPoint());
			drawHandle(line.getEndPoint());
		}
		g2D.drawLine(line.getStartPoint().x , line.getStartPoint().y, line.getEndPoint().x, line.getEndPoint().y);
	}
	
	public void draw(Square square) {
		g2D.fillRect((int)(-square.getSize()/2), (int)(-square.getSize()/2), (int)(square.getSize()) , (int)(square.getSize()));
	}
	
	public void draw(Rectangle rectangle) {
		g2D.fillRect((int)(-rectangle.getWidth()/2), (int)(-rectangle.getHeight()/2), (int)rectangle.getWidth(), (int)rectangle.getHeight());
	}
	
	public void draw(Circle circle) {
		g2D.fillOval((int)-circle.getRadius(), (int)-circle.getRadius(), (int)circle.getRadius() * 2, (int)circle.getRadius() * 2);
	}
	
	public void draw(Ellipse ellipse) {
		g2D.fillOval((int)-ellipse.getWidth()/2, (int)-ellipse.getHeight()/2, (int)ellipse.getWidth(), (int)ellipse.getHeight());
	}
	
	public void draw(Triangle triangle) {
		int[] xCoords = new int[] {(int)triangle.getPoint1().getX(), (int)triangle.getPoint2().getX(), (int)triangle.getPoint3().getX()};
		int[] yCoords = new int[] {(int)triangle.getPoint1().getY(), (int)triangle.getPoint2().getY(), (int)triangle.getPoint3().getY()};
		g2D.fillPolygon(xCoords, yCoords, 3);
	}
	
	public void draw(Shape shape) {
		if (shape != null)
		{
			currentShape = shape;
			AffineTransform objToWorld = new AffineTransform();
			//Add .5 to round and make sure the double isn't converted weirdly
			objToWorld.translate(shape.getCenter().getX() + .5, shape.getCenter().getY() + .5);
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
	
	public void drawHandle(Point2D point)
	{
		g2D.setColor(Color.ORANGE);
		g2D.drawRect((int)point.getX() - 3, (int)point.getY() - 3, 7, 7);
		g2D.setColor(currentShape.getColor());
	}
}
