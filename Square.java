
public class Square extends GraphicObject {
	private double sideLength;
	
	public Square(double newX, double newY, int red, int green, int blue, double sideLength) {
		super(newX, newY, red, green, blue);
		this.sideLength = sideLength;
	}
	
	@Override
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledSquare(this.getX(), this.getY(), this.sideLength);
	}

	@Override
	public double calculateArea() {
		//Multiply the length of the side by itself
		return Math.pow(this.sideLength * 2, 2);
	}

	@Override
	public double calculatePerimeter() {
		//A square has 4 sides, so multiply the side length by 4
		return (this.sideLength * 2) * 4;
	}

}
