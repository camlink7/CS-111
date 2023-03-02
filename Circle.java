
public class Circle extends GraphicObject {
	private double radius;
	
	public Circle(double newX, double newY, int red, int green, int blue, double newRadius) {
		super(newX, newY, red, green, blue);
		this.radius = newRadius;
	}
	
	@Override
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledCircle(this.getX(), this.getY(), this.radius);
	}

	@Override
	public double calculateArea() {
		return Math.PI * (Math.pow(this.radius, 2));
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * this.radius;
	}

}
