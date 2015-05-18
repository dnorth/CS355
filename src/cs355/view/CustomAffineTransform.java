package cs355.view;

import java.awt.geom.AffineTransform;

@SuppressWarnings("serial")
public class CustomAffineTransform extends AffineTransform{
	@Override
	public void rotate(double theta) {
		double[] matrix = new double[6];
		this.getMatrix(matrix);
		
		double cos = Math.cos(theta);
		double sin = Math.sin(theta);
				
		this.setTransform(
				matrix[0] * cos + matrix[2] * sin,
				matrix[1]*cos + matrix[3] * sin,
				matrix[0] * -sin + matrix[2] * cos,
				matrix[1] * -sin + matrix[3] * cos,
				matrix[4],
				matrix[5]
				);
	}
	
	@Override
	public void scale(double sx, double sy)
	{
		double[] matrix = new double[6];
        this.getMatrix(matrix);

        this.setTransform(
            matrix[0] * sx,
            matrix[1] * sx,
            matrix[2] * sy,
            matrix[3] * sy,
            matrix[4],
            matrix[5]
        );
	}
	
	@Override 
	public void translate(double tx, double ty)
	{
		double[] matrix = new double[6];
        this.getMatrix(matrix);

        this.setTransform(
            matrix[0],
            matrix[1],
            matrix[2],
            matrix[3],
            matrix[0] * tx + matrix[2] * ty + matrix[4],
            matrix[1] * tx + matrix[3] * ty + matrix[5]
        );
	}
}
