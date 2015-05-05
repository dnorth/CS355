package cs355;

import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

public class MainView implements ViewRefresher, Observer{

	private Model model;
	
	public MainView(Model model) {
		this.model = model;
	}

	@Override
	public void refreshView(Graphics2D g2d) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
