
public class Rectangle extends GraphicObject {
	private double length;
	private double width;
	
	public Rectangle(double newX, double newY, int red, int green, int blue, double newLength, double newWidth) {
		super(newX, newY, red, green, blue);
		this.length = newLength;
		this.width = newWidth;
	}

	@Override
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getX(), this.getY(), this.length, this.width);
	}

	@Override
	public double calculateArea() {
		return (this.length * 2) * (this.width * 2);
	}

	@Override
	public double calculatePerimeter() {
		return ((this.length * 2) * 2) + ((this.width * 2) * 2);
	}

}
