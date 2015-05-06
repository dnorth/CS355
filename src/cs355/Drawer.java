package cs355;

import java.awt.Color;
import java.awt.Graphics2D;

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
		g2D.fillOval(circle.getStartPoint().x, circle.getStartPoint().y, circle.getWidth(), circle.getWidth());
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
			}
		}
	}
}
