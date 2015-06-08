package cs355;


public class Vector_4 {

	double x1, y1, z1, f1;

	public Vector_4(double x1, double y1, double z1, double f1) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.f1 = f1;
	}
	
	public void dot(Matrix_4 matrix) {
		double a = x1; double b = y1; double c = z1; double d = f1;

		this.x1 = matrix.getX1()*a + matrix.getX2()*b + matrix.getX3()*c + matrix.getX4()*d;
		this.y1 = matrix.getY1()*a + matrix.getY2()*b + matrix.getY3()*c + matrix.getY4()*d;
		this.z1 = matrix.getZ1()*a + matrix.getZ2()*b + matrix.getZ3()*c + matrix.getZ4()*d;
		this.f1 = matrix.getF1()*a + matrix.getF2()*b + matrix.getF3()*c + matrix.getF4()*d;
		}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getZ1() {
		return z1;
	}

	public void setZ1(double z1) {
		this.z1 = z1;
	}

	public double getF1() {
		return f1;
	}

	public void setF1(double f1) {
		this.f1 = f1;
	}
}
