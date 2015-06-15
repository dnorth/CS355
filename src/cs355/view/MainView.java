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
	private boolean draw3D; 
	private boolean displayImage;
	
	public MainView(Model model) {
		this.model = model;
		this.zoom = .25;
		this.canvasHeight = 512;
		this.canvasWidth = 512;
		this.scrollX = 0;
		this.scrollY = 0;
		this.draw3D = false;
		this.displayImage = false;
		this.worldToView = new CustomAffineTransform();
		this.viewToWorld = new CustomAffineTransform();	
		this.drawer = new Drawer(this);
		this.model.addObserver(this);
		this.updateViewToWorld();
		this.updateWorldToView();
	}

	@Override
	public void refreshView(Graphics2D g2d) {
		drawer.setG2D(g2d);
		
		if(model.getOpenImage() != null && displayImage) {
			drawer.displayActiveImage(model.getOpenImage());
		}
				
		for (Shape shape : model.getShapes())
		{
			drawer.draw(shape);
		}
		
		drawer.draw(model.getActiveShape());
		drawer.drawOutline(model.getSelectedShape());
		
		if( draw3D) {
			drawer.drawHouse();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		GUIFunctions.refresh();
	}
	
	public void zoomIn() {
		if (zoom >= 4) return;
		zoom *= 2;
		
		Point2D center = new Point2D.Double((canvasWidth)/2.0, (canvasHeight)/2.0);
		viewToWorld.transform(center, center);
		
		updateWorldToView();
		updateViewToWorld();
		
		scrollToCenter(center);
		
		updateScrollBars();
		GUIFunctions.refresh();
	}
	
	public void zoomOut() {	
		if (zoom <= .25) return;
		zoom /= 2;

		
		Point2D center = new Point2D.Double((canvasWidth)/2.0, (canvasHeight)/2.0);
		viewToWorld.transform(center, center);
		
		
		updateWorldToView();
		updateViewToWorld();
		
		scrollToCenter(center);
		updateScrollBars();
		
		GUIFunctions.refresh();
	}
	
	public void scrollToCenter(Point2D center) {

		worldToView.transform(center, center);

		double x = center.getX() - (canvasWidth/(4*zoom));

		double y = center.getY() - (canvasHeight/(4*zoom));


		GUIFunctions.setHScrollBarPosit((int) x);
		GUIFunctions.setVScrollBarPosit((int) y);

		this.scrollXTo(x);
		this.scrollYTo(y);

	}
	
	public void scrollXTo(double x_scroll) {
		this.scrollX = x_scroll;
		updateWorldToView();
		updateViewToWorld();
		GUIFunctions.refresh();
	}
	
	public void scrollYTo(double y_scroll) {
		this.scrollY = y_scroll;
		updateWorldToView();
		updateViewToWorld();
		GUIFunctions.refresh();
	}
	
    public void updateScrollBars() {
    	
    	if(zoom == .25) {
            GUIFunctions.setHScrollBarPosit(0);
            GUIFunctions.setVScrollBarPosit(0);
    	}
    	
        GUIFunctions.setHScrollBarKnob((int) (canvasWidth / zoom));
        GUIFunctions.setHScrollBarMax((int) (2048 * zoom));
        GUIFunctions.setVScrollBarMax((int) (2048 * zoom));
        GUIFunctions.setVScrollBarKnob((int) (canvasHeight / zoom));
    }
	
	public void updateWorldToView() {
		worldToView.setToIdentity();
		worldToView.translate(-scrollX, -scrollY);
		worldToView.scale(zoom, zoom);
	}
	
	public void updateViewToWorld() {
		viewToWorld.setToIdentity();
		viewToWorld.scale(1/zoom, 1/zoom);
		viewToWorld.translate(scrollX, scrollY);
	}
	
	public void handleKey(char c) {
	    if(c == 'W') 
	    {
	    	drawer.getCamera().z += 0.1 * Math.cos(Math.toRadians(drawer.getCamera().angle));
	    	drawer.getCamera().x -= 0.1 * Math.sin(Math.toRadians(drawer.getCamera().angle));
	    }
	    if(c == 'A') 
	    {
	    	drawer.getCamera().z += 0.1 * Math.cos(Math.toRadians(drawer.getCamera().angle + 90));
	    	drawer.getCamera().x -= 0.1 * Math.sin(Math.toRadians(drawer.getCamera().angle + 90));
	    }
	    if(c == 'S') 
	    {
	    	drawer.getCamera().z -= 0.1 * Math.cos(Math.toRadians(drawer.getCamera().angle));
	    	drawer.getCamera().x += 0.1 * Math.sin(Math.toRadians(drawer.getCamera().angle));
	    }
	    if(c == 'D') 
	    {
	    	drawer.getCamera().z -= 0.1 * Math.cos(Math.toRadians(drawer.getCamera().angle + 90));
	    	drawer.getCamera().x += 0.1 * Math.sin(Math.toRadians(drawer.getCamera().angle + 90));
	    }
	    if(c == 'Q') 
	    {
	    	drawer.getCamera().angle+=1;
	    }
	    if(c == 'E') 
	    {
	    	drawer.getCamera().angle-=1;
	    }
	    if(c == 'R') 
	    {
	    	drawer.getCamera().y+=0.1;
	    }
	    if(c == 'F') 
	    {
	    	drawer.getCamera().y-=0.1;
	    }
	    if(c == 'H') 
	    {
	    	drawer.setCamera(new Camera(0,5,20));
	    	drawer.getCamera().angle = 180;
	    }
		GUIFunctions.refresh();
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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Drawer getDrawer() {
		return drawer;
	}

	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	public double getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(double canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	public double getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(double canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public double getScrollX() {
		return scrollX;
	}

	public void setScrollX(double scrollX) {
		this.scrollX = scrollX;
	}

	public double getScrollY() {
		return scrollY;
	}

	public void setScrollY(double scrollY) {
		this.scrollY = scrollY;
	}

	public boolean isDraw3D() {
		return draw3D;
	}

	public void setDraw3D(boolean draw3d) {
		updateWorldToView();
		draw3D = draw3d;
	}

	public boolean isDisplayImage() {
		return displayImage;
	}

	public void setDisplayImage(boolean displayImage) {
		this.displayImage = displayImage;
	}

}
