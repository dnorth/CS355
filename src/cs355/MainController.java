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
	private DrawingHandler drawingHandler;
	
	public MainController(Model model) {
		this.model = model;
		this.color = Color.WHITE;
		this.drawingHandler = new NullDrawHandler();
	}

	@Override
	public void colorButtonHit(Color c) {
		this.color = c;
		GUIFunctions.changeSelectedColor(c);
	}

	@Override
	public void triangleButtonHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void squareButtonHit() {
		this.drawingHandler = new SquareHandler(this);
	}

	@Override
	public void rectangleButtonHit() {
		this.drawingHandler = new RectangleHandler(this);
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
