package cs355.model;

public class currentImage {
	int height;
	int width;
	int[][] pixelData;
	
	public currentImage(int width, int height, int[][] pixelData) {
		super();
		this.height = height;
		this.width = width;
		this.pixelData = pixelData;
	}
	
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int[][] getPixelData() {
		return pixelData;
	}
	public void setPixelData(int[][] pixelData) {
		this.pixelData = pixelData;
	}
	
	
}
