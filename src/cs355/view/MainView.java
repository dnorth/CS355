package cs355.view;

import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import cs355.GUIFunctions;
import cs355.ViewRefresher;
import cs355.model.Model;
import cs355.model.shape.Shape;

public class MainView implements ViewRefresher, Observer{

	private Model model;
	private Drawer drawer = new Drawer();
	
	public MainView(Model model) {
		this.model = model;
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

}
