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
		double l = x1, m = y1, q = z1, o = f1;
		
		x1 = matrix.getX1() * l + matrix.getX2() * m + matrix.getX3() * q + matrix.getX4() * o;
		y1 = matrix.getY1() * l + matrix.getY2() * m + matrix.getY3() * q + matrix.getY4() * o;
		z1 = matrix.getZ1() * l + matrix.getZ2() * m + matrix.getZ3() * q + matrix.getZ4() * o;
		f1 = matrix.getF1() * l + matrix.getF2() * m + matrix.getF3() * q + matrix.getF4() * o;
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
