package cs355;

import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

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
		
		drawer.draw(model.getActiveShape());
		
		for (Shape shape : model.getShapes())
		{
			drawer.draw(shape);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		GUIFunctions.refresh();
	}

}
