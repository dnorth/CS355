package cs355.controller.handler;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import cs355.controller.MainController;
import cs355.model.shape.Shape;

public class SelectionHandler implements DrawingHandler{

	MainController controller;
	Point2D point = new Point2D.Double();
	boolean rotate = false;
	
	public SelectionHandler(MainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void start(Point start) {
		this.point = start;
		
		if (this.controller.getModel().getSelectedShape() != null) {
			AffineTransform worldToObj = this.controller.getModel().getSelectedShape().worldToObj();
			Point2D objCoord = new Point2D.Double();
			worldToObj.transform(point, objCoord);

			if (this.controller.getModel().getSelectedShape().withinRotator(objCoord))
			{
				rotate=true;
			}
			else
			{
				this.controller.getModel().setSelectedShape(point, 4);
			}
		}
		else
		{
			this.controller.getModel().setSelectedShape(point, 4);
		}

	}

	@Override
	public void drag(Point end) {
		if (this.controller.getModel().getSelectedShape() != null) {
			if(rotate)
			{
				Point2D center = this.controller.getModel().getSelectedShape().getCenter();
				double dx = end.getX() - center.getX();
				double dy = end.getY() - center.getY();
				double angle = Math.atan2(dx, dy) + Math.PI;
				this.controller.getModel().getSelectedShape().setRotateAngle(-angle);
			}
			else
			{
				Point2D currCenter = this.controller.getModel().getSelectedShape().getCenter();
				double xDiff = end.getX() - point.getX();
				double yDiff = end.getY() - point.getY();
				currCenter.setLocation(currCenter.getX()+xDiff, currCenter.getY()+yDiff);
				this.controller.getModel().getSelectedShape().setCenter(currCenter);
			}
			
			this.controller.getModel().update();
		}

		this.point = end;

	}

	@Override
	public void end() {
		rotate = false;
	}
	
	public void changeColor(Color c) {
		controller.getModel().setSelectedColor(controller.getModel().getSelectedShape(), c);
	}

}
