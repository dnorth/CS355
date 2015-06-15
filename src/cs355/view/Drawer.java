package cs355.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import cs355.Line3D;
import cs355.HouseModel;
import cs355.Matrix_4;
import cs355.Vector_4;
import cs355.WireFrame;
import cs355.model.currentImage;
import cs355.model.shape.Circle;
import cs355.model.shape.Ellipse;
import cs355.model.shape.Line;
import cs355.model.shape.Rectangle;
import cs355.model.shape.Shape;
import cs355.model.shape.Square;
import cs355.model.shape.Triangle;

public class Drawer {
	private Graphics2D g2D;
	private int THICKNESS = 3;
	private WireFrame houseModel;
	private Camera camera;
	AffineTransform objToWorld;
	AffineTransform worldToView;
	AffineTransform objToView;
	MainView view;
	
	public Drawer(MainView view)
	{
		this.houseModel = new HouseModel();
		this.camera = new Camera(0, 5, 20);
		this.view = view;
	}
	
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
		else {
			g2D.drawLine(line.getStartPoint().x , line.getStartPoint().y, line.getEndPoint().x, line.getEndPoint().y);
		}
	}
	
	public void draw(Square square) {		
		if(square.isSelected()) {
			g2D.drawRect((int)(-square.getSize()/2), (int)(-square.getSize()/2), (int)(square.getSize()), (int)(square.getSize()));
			drawRotateHandle(0.0, -square.getSize()/2, 20);
		}
		else
		{
			g2D.fillRect((int)(-square.getSize()/2), (int)(-square.getSize()/2), (int)(square.getSize()) , (int)(square.getSize()));
		}
	}
	
	public void draw(Rectangle rectangle) {		
		if(rectangle.isSelected()) {
			g2D.drawRect((int)(-rectangle.getWidth()/2), (int)(-rectangle.getHeight()/2), (int)rectangle.getWidth(), (int)rectangle.getHeight());
			drawRotateHandle(0.0, -rectangle.getHeight()/2, 20);
		}
		else
		{
			g2D.fillRect((int)(-rectangle.getWidth()/2), (int)(-rectangle.getHeight()/2), (int)rectangle.getWidth(), (int)rectangle.getHeight());
		}
	}
	
	public void draw(Circle circle) {	
		if(circle.isSelected()) {
			g2D.drawOval((int)-circle.getRadius(), (int)-circle.getRadius(), (int)circle.getRadius() * 2, (int)circle.getRadius() * 2);
			drawRotateHandle(0.0, -circle.getRadius(), 20);
		}
		else
		{
			g2D.fillOval((int)-circle.getRadius(), (int)-circle.getRadius(), (int)circle.getRadius() * 2, (int)circle.getRadius() * 2);
		}
	}
	
	public void draw(Ellipse ellipse) {		
		if(ellipse.isSelected()) {
			g2D.drawOval((int)(-ellipse.getWidth()/2 - 1), (int)(-ellipse.getHeight()/2 - 1), (int) (ellipse.getWidth() + 1), (int)(ellipse.getHeight() + 1));
			drawRotateHandle(0.0, -ellipse.getHeight()/2, 20);
		}
		else
		{
			g2D.fillOval((int)-ellipse.getWidth()/2, (int)-ellipse.getHeight()/2, (int)ellipse.getWidth(), (int)ellipse.getHeight());
		}
	}
	
	public void draw(Triangle triangle) {
		int[] xCoords = new int[] {(int)triangle.getPoint1().getX(), (int)triangle.getPoint2().getX(), (int)triangle.getPoint3().getX()};
		int[] yCoords = new int[] {(int)triangle.getPoint1().getY(), (int)triangle.getPoint2().getY(), (int)triangle.getPoint3().getY()};
			
		if(triangle.isSelected()) {
			g2D.drawPolygon(xCoords, yCoords, 3);
			double x = (triangle.getPoint1().getX() +  triangle.getPoint2().getX() +  triangle.getPoint3().getX())/3;
			double y = Math.min(Math.min(triangle.getPoint1().getY(), triangle.getPoint2().getY()), triangle.getPoint3().getY());
			drawRotateHandle(x, y, 20);
		}
		else
		{
			g2D.fillPolygon(xCoords, yCoords, 3);
		}
	}
	
	public void draw(Shape shape) {
		if (shape != null)
		{
			objToWorld = shape.objToWorld();
			worldToView = view.getWorldToView();
			
			objToView = (AffineTransform)objToWorld.clone();
			objToView.preConcatenate(worldToView);
			g2D.setColor(shape.getColor());	
			
			g2D.setTransform(objToView);
			
			boolean selected = false;
			if(shape.isSelected()) {
				selected = true;
				shape.setSelected(false);
			}
			lockTheTaskBar(shape);
			if (selected)
			{
				shape.setSelected(true);
			}
		}
	}
	
	public void drawOutline(Shape shape) {
		if (shape != null)
		{
			objToWorld = shape.objToWorld();
			worldToView = view.getWorldToView();
			
			objToView = (AffineTransform)objToWorld.clone();
			objToView.preConcatenate(worldToView);			
			g2D.setColor(Color.BLUE);
			g2D.setStroke(new BasicStroke(THICKNESS));
			
			g2D.setTransform(objToView);
			
			lockTheTaskBar(shape);
		}
	}
	
	public void lockTheTaskBar(Shape shape)
	{
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
	
	public void drawHandle(Point2D point)
	{
		g2D.setColor(Color.BLUE);
		g2D.drawRect((int)point.getX() - 3, (int)point.getY() - 3, 7, 7);
	}
	
	public void drawRotateHandle(double x, double y, int offset)
	{
		g2D.setColor(Color.BLUE);
		g2D.fillOval((int)x,(int)y - offset, 10, 10);
	}

	public void drawHouse() {
		
		g2D.setTransform(view.getWorldToView());

	    for (Line3D line : houseModel) {
	    	Vector_4 start = new Vector_4(line.start.x,line.start.y,line.start.z,1);
	    	Vector_4 end = new Vector_4(line.end.x,line.end.y,line.end.z,1);
	    	
	    	Matrix_4 worldToCameraMatrix = camera.getWorldToCameraMatrix();
	    	start.dot(worldToCameraMatrix);
	    	end.dot(worldToCameraMatrix);
	    	
	    	start = camera.getClipMatrix(start);
	    	end = camera.getClipMatrix(end);
	    	if(camera.isWithinView(start, end)) {
	    		Point2D startPoint = camera.getScreenPoint(start);
	    		Point2D endPoint = camera.getScreenPoint(end);
	    		
	    		g2D.drawLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int)endPoint.getY());

	    	}
	    }
	}
	
	public void displayActiveImage(currentImage activeImage) {
		g2D.setTransform(view.getWorldToView());

		BufferedImage bufferedImage = new BufferedImage(activeImage.getWidth(), activeImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		//bufferedImage.getGraphics().drawImage(activeImage, 0, 0, null);
		WritableRaster r = bufferedImage.getRaster();
		for(int i=0; i < activeImage.getWidth(); i++) {
			for(int j=0; j < activeImage.getHeight(); j++) {
				r.setSample(i, j, 0, activeImage.getPixelData()[i][j]);
			}
		}
		bufferedImage.setData(r);
		
		
		g2D.drawImage(bufferedImage, null, (2048 - bufferedImage.getWidth())/2, (2048 - bufferedImage.getHeight())/2);
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
}
