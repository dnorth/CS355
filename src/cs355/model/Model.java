package cs355.model;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import cs355.model.shape.Circle;
import cs355.model.shape.Ellipse;
import cs355.model.shape.Line;
import cs355.model.shape.Rectangle;
import cs355.model.shape.Shape;
import cs355.model.shape.Square;
import cs355.model.shape.Triangle;

public class Model extends Observable {
	private Shape activeShape;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private currentImage openImage = null;
	
	public void addActiveShape() {
		shapes.add(activeShape);
		update();
	}

	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Shape getActiveShape() {
		return activeShape;
	}

	public void setActiveShape(Shape activeShape) {
		this.activeShape = activeShape;
		update();
	}
	
	public void setSelectedShape(Point2D worldPoint, double tolerance) {
		Shape selected = null;
		for (Shape shape : shapes) {
			AffineTransform worldToObj = new AffineTransform();
			worldToObj.rotate(-1 * shape.getRotateAngle());
			worldToObj.translate(-1 * shape.getCenter().getX(), -1 * shape.getCenter().getY());
			
			Point2D objCoord = new Point2D.Double();
			worldToObj.transform(worldPoint, objCoord);
			
			if(shape.within(objCoord, tolerance))
			{
				selected = shape;
			}
			shape.setSelected(false);
		}
		if(selected != null)
		{
			selected.setSelected(true);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void deselectAll() {
		for (Shape shape : shapes) {
			shape.setSelected(false);
		}
		update();
	}
	
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public Shape getSelectedShape() {
		for (Shape shape : shapes) {
			if(shape.isSelected())
			{
				return shape;
			}
		}
		
		return null;
	}
	
	public void setSelectedColor(Shape shape, Color c) {
		shape.setColor(c);
		update();
	}



	public currentImage getOpenImage() {
		return openImage;
	}



	public void setOpenImage(currentImage openImage) {
		this.openImage = openImage;
		update();
	}
	
	public void changeImageBrightness(int value) {
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int data = openImage.pixelData[i][j];
				if(data + value > 255) {
					openImage.pixelData[i][j] = 255;
				} else if(data + value < 0 ) {
					openImage.pixelData[i][j] = 0;
				}	else {
					openImage.pixelData[i][j] = data + value;
				}
			}
		}
		update();
	}
	
	public void changeImageConstrast(int value) {
		double scalar = Math.pow((double)(value + 100)/ 100.00, 4);
		
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int data = openImage.pixelData[i][j];
				openImage.pixelData[i][j] = (int)(scalar*(data - 128) + 128);
				
				if(openImage.pixelData[i][j] > 255) {
					openImage.pixelData[i][j] = 255;
				} else if(openImage.pixelData[i][j] < 0 ) {
					openImage.pixelData[i][j] = 0;
				}
			}
		}
		update();
	}
	
	public void doUniformBlur() {
		int[][] newPixelData = new int[openImage.width][openImage.height];
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int column = 0;
				int count = 0;
				for(int x = -1; x < 2; x++) {
					for(int y = -1; y < 2; y++) {
						if((x + i) >= 0 && (x + i) < openImage.width && (y + j) >= 0 && (y + j) < openImage.height) {
							column += openImage.pixelData[i + x][j + y];
							count++;
						}
					}
				}
				newPixelData[i][j] = (int)((column*1.0)/count);
			}
		}
		openImage.setPixelData(newPixelData);
		update();
	}
	
	public void doMedianBlur() {
		int[][] newPixelData = new int[openImage.width][openImage.height];
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int[] column = new int[9];
				int count = 0;
				for(int x = -1; x < 2; x++) {
					for(int y = -1; y < 2; y++) {
						if((x + i) >= 0 && (x + i) < openImage.width && (y + j) >= 0 && (y + j) < openImage.height) {
							column[count] =  openImage.pixelData[i + x][j + y];
							count++;
						}
					}
				}
				Arrays.sort(column);
				if(count % 2 == 0) newPixelData[i][j] = (int)(.5 * (column[count/2] + column[count/2 - 1]));
				else newPixelData[i][j] = (int)(column[count/2]);
			}
		}
		openImage.setPixelData(newPixelData);
		update();
	}
	
	public int[][] convolve(int[][] mask, int division) {
		int[][] newPixelData = new int[openImage.width][openImage.height];

		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				int column = 0;
				int count = 0;
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 3; y++) {
						if((x + i - 1) >= 0 && (x + i - 1) < openImage.width && (y + j - 1) >= 0 && (y + j - 1) < openImage.height) {
							column += (mask[x][y] * openImage.pixelData[i + x - 1][j + y - 1]);
							count++;
						}
					}
				}
				newPixelData[i][j] = (int)((column*1.0)/division);
				
				if(newPixelData[i][j] > 255) {
					newPixelData[i][j] = 255;
				} else if(newPixelData[i][j] < 0 ) {
					newPixelData[i][j] = 0;
				}
			}
		}
		
		return newPixelData;
	}
	
	public void doEdgeDetection() {
		
		int[][] xMask = {
				{-1, 0, 1},
				{-2, 0, 2},
				{-1, 0, 1},
			}; 
		
		int[][] yMask = {
				{-1, -2, -1},
				{0, 0, 0},
				{1, 2, 1},
			}; 
		
		int[][] newXData = convolve(xMask, 8);
		int[][] newYData = convolve(yMask, 8);
		int[][] newPixelData = new int[openImage.width][openImage.height];
		for(int i=0; i < openImage.width; i++) {
			for(int j=0; j < openImage.height; j++) {
				newPixelData[i][j] = (int) (Math.pow((double)(newXData[i][j]*newXData[i][j] + newYData[i][j] * newYData[i][j]),  .5));
			}
		}
		openImage.setPixelData(newPixelData);
		update();
	}
	
	
	public void doSharpen() {
		int[][] mask = {
				{0, -1, 0},
				{-1, 6, -1},
				{0, -1, 0 },
			};
		
		int[][] newPixelData = convolve(mask, 2);
		openImage.setPixelData(newPixelData);
		update();
	}
}
