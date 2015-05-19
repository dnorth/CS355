package cs355.view;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import cs355.GUIFunctions;
import cs355.ViewRefresher;
import cs355.model.Model;
import cs355.model.shape.Shape;

public class MainView implements ViewRefresher, Observer{

	private Model model;
	private Drawer drawer;
	private AffineTransform worldToView;
	private AffineTransform viewToWorld;
	private double zoom;
	private double canvasHeight;
	private double canvasWidth;
	private double scrollX;
	private double scrollY;
	
	public MainView(Model model) {
		this.model = model;
		this.zoom = 1;
		this.canvasHeight = 512;
		this.canvasWidth = 512;
		this.scrollX = 0;
		this.scrollY = 0;
		this.worldToView = new CustomAffineTransform();
		this.viewToWorld = new CustomAffineTransform();	
		this.drawer = new Drawer(this);
		this.model.addObserver(this);
	}

	@Override
	public void refreshView(Graphics2D g2d) {
		drawer.setG2D(g2d);
				
		for (Shape shape : model.getShapes())
		{
			drawer.draw(shape);
		}
		
		drawer.draw(model.getActiveShape());
		drawer.drawOutline(model.getSelectedShape());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		GUIFunctions.refresh();
	}
	
	public void zoomIn()
	{
		if (zoom >= 4) return;
		
		Point2D center = new Point2D.Double(canvasWidth/2.0, canvasHeight/2.0);
		viewToWorld.transform(center, center);
		
		zoom *= 2;
		
		updateScrollBars();
		updateWorldToView();
		updateViewToWorld();
		
        GUIFunctions.setHScrollBarPosit((int) center.getX());
        GUIFunctions.setVScrollBarPosit((int) center.getY());
		
		GUIFunctions.refresh();
	}
	
	public void zoomOut()
	{	
		if (zoom <= 0.25) return;
		
		Point2D center = new Point2D.Double(canvasWidth/2.0, canvasHeight/2.0);
		viewToWorld.transform(center, center);
		
		zoom /= 2;
		
		updateScrollBars();
		updateWorldToView();
		updateViewToWorld();
		
        GUIFunctions.setHScrollBarPosit((int) center.getX());
        GUIFunctions.setVScrollBarPosit((int) center.getY());
		
		GUIFunctions.refresh();
	}
	
	public void scrollXTo(double x_scroll)
	{
		this.scrollX = x_scroll;
		updateWorldToView();
		updateViewToWorld();
		GUIFunctions.refresh();
	}
	
	public void scrollYTo(double y_scroll)
	{
		this.scrollY = y_scroll;
		updateWorldToView();
		updateViewToWorld();
		GUIFunctions.refresh();
	}
	
    public void updateScrollBars() {
        GUIFunctions.setHScrollBarMax((int) (zoom*canvasWidth));
        GUIFunctions.setHScrollBarKnob((int) canvasWidth);

        GUIFunctions.setVScrollBarMax((int) (zoom*canvasHeight));
        GUIFunctions.setVScrollBarKnob((int) canvasHeight);
    }
	
	public void updateWorldToView()
	{
		worldToView.setToIdentity();
		worldToView.translate(-scrollX, -scrollY);
		worldToView.scale(zoom, zoom);
	}
	
	public void updateViewToWorld()
	{
		viewToWorld.setToIdentity();
		viewToWorld.scale(1/zoom, 1/zoom);
		viewToWorld.translate(scrollX, scrollY);
	}

	public AffineTransform getWorldToView() {
		return worldToView;
	}

	public void setWorldToView(AffineTransform worldToView) {
		this.worldToView = worldToView;
	}

	public AffineTransform getViewToWorld() {
		return viewToWorld;
	}

	public void setViewToWorld(AffineTransform viewToWorld) {
		this.viewToWorld = viewToWorld;
	}

}
