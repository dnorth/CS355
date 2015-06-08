package cs355;

public class Matrix_4 {
	private double x1, x2, x3, x4;
	private double y1, y2, y3, y4;
	private double z1, z2, z3, z4;
	private double f1, f2, f3, f4;
	
	public Matrix_4(double x1, double x2, double x3, double x4, double y1,
			double y2, double y3, double y4, double z1, double z2, double z3,
			double z4, double f1, double f2, double f3, double f4) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.z1 = z1;
		this.z2 = z2;
		this.z3 = z3;
		this.z4 = z4;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
	}
	
	public void dot(double x1, double x2, double x3, double x4, double y1,
			double y2, double y3, double y4, double z1, double z2, double z3,
			double z4, double f1, double f2, double f3, double f4){
			double a1 = this.x1; double a2 = this.x2; double a3 = this.x3; double a4 = this.x4;
			double b1 = this.y1; double b2 = this.y2; double b3 = this.y3; double b4 = this.y4;
			double c1 = this.z1; double c2 = this.z2; double c3 = this.z3; double c4 = this.z4;
			double d1 = this.f1; double d2 = this.f2; double d3 = this.f3; double d4 = this.f4;

			this.x1 = a1*x1 + b1*x2 + c1*x3 + d1*x4;
			this.x2 = a2*x1 + b2*x2 + c2*x3 + d2*x4;
			this.x3 = a3*x1 + b3*x2 + c3*x3 + d3*x4;
			this.x4 = a4*x1 + b4*x2 + c4*x3 + d4*x4;

			this.y1 = a1*y1 + b1*y2 + c1*y3 + d1*y4;
			this.y2 = a2*y1 + b2*y2 + c2*y3 + d2*y4;
			this.y3 = a3*y1 + b3*y2 + c3*y3 + d3*y4;
			this.y4 = a4*y1 + b4*y2 + c4*y3 + d4*y4;

			this.z1 = a1*z1 + b1*z2 + c1*z3 + d1*z4;
			this.z2 = a2*z1 + b2*z2 + c2*z3 + d2*z4;
			this.z3 = a3*z1 + b3*z2 + c3*z3 + d3*z4;
			this.z4 = a4*z1 + b4*z2 + c4*z3 + d4*z4;

			this.f1 = a1*f1 + b1*f2 + c1*f3 + d1*f4;
			this.f2 = a2*f1 + b2*f2 + c2*f3 + d2*f4;
			this.f3 = a3*f1 + b3*f2 + c3*f3 + d3*f4;
			this.f4 = a4*f1 + b4*f2 + c4*f3 + d4*f4;
			}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public double getX4() {
		return x4;
	}

	public void setX4(double x4) {
		this.x4 = x4;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getY3() {
		return y3;
	}

	public void setY3(double y3) {
		this.y3 = y3;
	}

	public double getY4() {
		return y4;
	}

	public void setY4(double y4) {
		this.y4 = y4;
	}

	public double getZ1() {
		return z1;
	}

	public void setZ1(double z1) {
		this.z1 = z1;
	}

	public double getZ2() {
		return z2;
	}

	public void setZ2(double z2) {
		this.z2 = z2;
	}

	public double getZ3() {
		return z3;
	}

	public void setZ3(double z3) {
		this.z3 = z3;
	}

	public double getZ4() {
		return z4;
	}

	public void setZ4(double z4) {
		this.z4 = z4;
	}

	public double getF1() {
		return f1;
	}

	public void setF1(double f1) {
		this.f1 = f1;
	}

	public double getF2() {
		return f2;
	}

	public void setF2(double f2) {
		this.f2 = f2;
	}

	public double getF3() {
		return f3;
	}

	public void setF3(double f3) {
		this.f3 = f3;
	}

	public double getF4() {
		return f4;
	}

	public void setF4(double f4) {
		this.f4 = f4;
	}
	
}
