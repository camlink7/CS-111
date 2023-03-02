
public class Ellipse extends GraphicObject {
	private double semiMajorAxis;
	private double semiMinorAxis;
	
	public Ellipse(double newX, double newY, int red, int green, int blue, double newSemiMajor, double newSemiMinor) {
		super(newX, newY, red, green, blue);
		this.semiMajorAxis = newSemiMajor;
		this.semiMinorAxis = newSemiMinor;
	}
	
	@Override
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledEllipse(this.getX(), this.getY(), this.semiMajorAxis, this.semiMinorAxis);
	}

	@Override
	public double calculateArea() {
		return Math.PI * this.semiMajorAxis * this.semiMinorAxis;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * Math.sqrt(((Math.pow(this.semiMajorAxis, 2)) + (Math.pow(this.semiMinorAxis, 2))) / 2);
	}

}
