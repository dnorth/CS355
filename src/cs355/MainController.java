package cs355;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import cs355.CS355Controller;

public class MainController implements CS355Controller, MouseListener, MouseMotionListener{

	private Model model;
	private Color color;
	private Shape shape;
	private DrawingHandler drawingHandler;
	
	public MainController(Model model) {
		this.model = model;
	}

	@Override
	public void colorButtonHit(Color c) {
		this.color = c;
		System.out.println("New Color! " + c);
	}

	@Override
	public void triangleButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void squareButtonHit() {
		System.out.println("Hello!");
		
	}

	@Override
	public void rectangleButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void circleButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ellipseButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lineButtonHit() {
		this.shape = new Line(this.color);
		this.drawingHandler = new LineHandler(this);
	}

	@Override
	public void selectButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zoomInButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zoomOutButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hScrollbarChanged(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vScrollbarChanged(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggle3DModelDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(Iterator<Integer> iterator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doEdgeDetection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSharpen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doMedianBlur() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUniformBlur() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doChangeContrast(int contrastAmountNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doChangeBrightness(int brightnessAmountNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doLoadImage(BufferedImage openImage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggleBackgroundDisplay() {
		// TODO Auto-generated method stub
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawingHandler.drag(e.getPoint());
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		drawingHandler.start(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drawingHandler.end();		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
