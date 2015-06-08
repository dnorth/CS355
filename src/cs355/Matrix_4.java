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
	
	public void dot(double a1, double a2, double a3, double a4, double b1,
			double b2, double b3, double b4, double c1, double c2, double c3,
			double c4, double d1, double d2, double d3, double d4) {
	
			double l1 = x1, l2 = x2, l3 = x3, l4 = x4; 
			double m1 = y1, m2 = y2, m3 = y3, m4 = y4;
			double q1 = z1, q2 = z2, q3 = z3, q4 = z4;
			double o1 = f1, o2 = f2, o3 = f3, o4 = f4;
			
			x1 = l1*a1 + l2*b1 + l3*c1 + l4*d1;
			x2 = l1*a2 + l2*b2 + l3*c2 + l4*d2;
			x3 = l1*a3 + l2*b3 + l3*c3 + l4*d3;
			x4 = l1*a4 + l2*b4 + l3*c4 + l4*d4;
			
			y1 = m1*a1 + m2*b1 + m3*c1 + m4*d1;
			y2 = m1*a2 + m2*b2 + m3*c2 + m4*d2;
			y3 = m1*a3 + m2*b3 + m3*c3 + m4*d3;
			y4 = m1*a4 + m2*b4 + m3*c4 + m4*d4;

			z1 = q1*a1 + q2*b1 + q3*c1 + q4*d1;
			z2 = q1*a2 + q2*b2 + q3*c2 + q4*d2;
			z3 = q1*a3 + q2*b3 + q3*c3 + q4*d3;
			z4 = q1*a4 + q2*b4 + q3*c4 + q4*d4;
			
			f1 = o1*a1 + o2*b1 + o3*c1 + o4*d1;
			f2 = o1*a2 + o2*b2 + o3*c2 + o4*d2;
			f3 = o1*a3 + o2*b3 + o3*c3 + o4*d3;
			f4 = o1*a4 + o2*b4 + o3*c4 + o4*d4;
		
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
