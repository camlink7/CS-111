package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the Circle class that extends the GraphicObject class
 */

/*
 * Class Name: Circle
 * Purpose: Allows for calculation of area + perimeter of a Circle, as well as drawing to the screen using the StdDraw library
 * Exceptions: N/A
 */
public class Circle extends GraphicObject {
	private double radius;
	
	/*
	 * Method Name: Circle
	 * Purpose: Constructs a new Circle object extending the GraphicObject class
	 * Parameters:
	 * - newX: The x-coordinate of the object on the StdDraw canvas
	 * - newY: The y-coordinate of the object on the StdDraw canvas
	 * - red: The red RGB value for the color of the Circle
	 * - green: The green RGB value for the color of the Circle
	 * - blue: The blue RGB value for the color of the Circle
	 * - newRadius: The radius of the circle
	 * Preconditions: 
	 * - The x, y coordinates should be within the bounds of the canvas
	 * - The newRadius should be > 0 to actually draw a shape
	 * Postconditions: Constructs a new Circle object at the specified location with the specified color and radius
	 * Exceptions: N/A
	 */
	public Circle(double newX, double newY, int red, int green, int blue, double newRadius) {
		super(newX, newY, red, green, blue);
		this.radius = newRadius;
	}
	
	/*
	 * Method Name: draw
	 * Purpose: Override method to draw the Circle object in the active StdDraw canvas
	 * Parameters: N/A
	 * Preconditions:
	 * - The StdDraw canvas must be setup and configured properly before drawing
	 * Postconditions: Postconditions: A circle is drawn at the (x, y) coordinates with the color, 
	 * 		and radius specified in this Object
	 * Exceptions: N/A
	 */
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledCircle(this.getX(), this.getY(), this.radius);
	}

	/*
	 * Method Name: calculateArea
	 * Purpose: Override method to calculate the area of this Circle object in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - The circle should have a valid radius
	 * Postconditions: Returns the area of the circle in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculateArea() {
		return Math.PI * (Math.pow(this.radius, 2));
	}

	/*
	 * Method Name: calculatePerimeter
	 * Purpose: Override method to calculate the perimeter of this Circle object in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - The circle should have a valid radius
	 * Postconditions: Returns the perimeter of the circle in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculatePerimeter() {
		return 2 * Math.PI * this.radius;
	}
}