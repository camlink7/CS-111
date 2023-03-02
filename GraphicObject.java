import java.awt.Color;

public abstract class GraphicObject {
	private double x;
	private double y;
	private Color color;
	
	public GraphicObject(double newX, double newY, int red, int green, int blue) {
		this.x = newX;
		this.y = newY;
		this.color = new Color(red, green, blue);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public String toString() {
		return String.format("The object at location: %s %s is an instance of %s Red: %s Blue: %s Green %s. It has the area:"
				+ " %s, and perimeter: %s", Double.toString(this.x), Double.toString(this.y), this.getClass().toString(), 
				Integer.toString(this.color.getRed()), Integer.toString(this.color.getBlue()), Integer.toString(this.color.getGreen()),
				Double.toString(this.calculateArea()), Double.toString(this.calculatePerimeter()));
	}
	
	public abstract void draw();
	
	public abstract double calculateArea();
	
	public abstract double calculatePerimeter();
}