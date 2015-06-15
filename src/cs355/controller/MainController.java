package cs355.controller;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Iterator;

import cs355.GUIFunctions;
import cs355.controller.CS355Controller;
import cs355.controller.handler.CircleHandler;
import cs355.controller.handler.DrawingHandler;
import cs355.controller.handler.EllipseHandler;
import cs355.controller.handler.LineHandler;
import cs355.controller.handler.NullDrawHandler;
import cs355.controller.handler.RectangleHandler;
import cs355.controller.handler.SelectionHandler;
import cs355.controller.handler.SquareHandler;
import cs355.controller.handler.TriangleHandler;
import cs355.model.Model;
import cs355.model.currentImage;
import cs355.view.MainView;

public class MainController implements CS355Controller, MouseListener, MouseMotionListener{

	private Model model;
	private MainView view;
	private Color color;
	private DrawingHandler drawingHandler;
	
	public MainController(Model model, MainView view) {
		this.model = model;
		this.view = view;
		this.color = Color.WHITE;
		this.drawingHandler = new NullDrawHandler();
	}

	@Override
	public void colorButtonHit(Color c) {
		if(drawingHandler instanceof SelectionHandler)
		{
			((SelectionHandler) drawingHandler).changeColor(c);
		}
		else
		{
			this.color = c;
			GUIFunctions.changeSelectedColor(c);
		}
	}

	@Override
	public void triangleButtonHit() {
		model.deselectAll();
		this.drawingHandler = new TriangleHandler(this);
	}

	@Override
	public void squareButtonHit() {
		model.deselectAll();
		this.drawingHandler = new SquareHandler(this);
	}

	@Override
	public void rectangleButtonHit() {
		model.deselectAll();
		this.drawingHandler = new RectangleHandler(this);
	}

	@Override
	public void circleButtonHit() {
		model.deselectAll();
		this.drawingHandler = new CircleHandler(this);
	}

	@Override
	public void ellipseButtonHit() {
		model.deselectAll();
		this.drawingHandler = new EllipseHandler(this);
	}

	@Override
	public void lineButtonHit() {
		model.deselectAll();
		this.drawingHandler = new LineHandler(this);
	}

	@Override
	public void selectButtonHit() {
		this.drawingHandler = new SelectionHandler(this);
	}

	@Override
	public void zoomInButtonHit() {
		view.zoomIn();
	}

	@Override
	public void zoomOutButtonHit() {
		view.zoomOut();
	}

	@Override
	public void hScrollbarChanged(int value) {
		view.scrollXTo(value);
	}

	@Override
	public void vScrollbarChanged(int value) {
		view.scrollYTo(value);
	}

	@Override
	public void toggle3DModelDisplay() {
		view.setDraw3D(!view.isDraw3D());
		GUIFunctions.refresh();
	}

	@Override
	public void keyPressed(Iterator<Integer> iterator) {
		if(view.isDraw3D()) {
			while(iterator.hasNext()) {
				view.handleKey((char) (int) iterator.next());
			}
		}
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
		
		WritableRaster raster = openImage.getRaster();
		int[][] pixels = new int[raster.getWidth()][raster.getHeight()];
		
		for(int i=0; i < raster.getWidth(); i++) {
			for(int j=0; j < raster.getHeight(); j++) {
				pixels[i][j] = raster.getSample(i, j, 0);
			}
		}
		
		currentImage newImage = new currentImage(
				raster.getWidth(),
				raster.getHeight(), 
				pixels
				);
		
		model.setOpenImage(newImage);
		
	}

	@Override
	public void toggleBackgroundDisplay() {
		view.setDisplayImage(!view.isDisplayImage());
		GUIFunctions.refresh();
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
		Point2D p = new Point2D.Double();
        view.getViewToWorld().transform(e.getPoint(), p);
		drawingHandler.drag(new Point((int) p.getX(), (int) p.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
        Point2D p = new Point2D.Double();
        view.getViewToWorld().transform(e.getPoint(), p);
        System.out.println(p);
		drawingHandler.start(new Point((int) p.getX(), (int) p.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drawingHandler.end();		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		this.view = view;
	}

	public DrawingHandler getDrawingHandler() {
		return drawingHandler;
	}

	public void setDrawingHandler(DrawingHandler drawingHandler) {
		this.drawingHandler = drawingHandler;
	}

}
