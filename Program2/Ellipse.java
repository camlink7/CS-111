package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the Ellipse class that extends the GraphicObject class
 */

/*
 * Class Name: Ellipse
 * Purpose: Allows for calculation of area + perimeter of an Ellipse, as well as drawing to the screen using the StdDraw library
 * Exceptions: N/A
 */
public class Ellipse extends GraphicObject {
	private double semiMajorAxis;
	private double semiMinorAxis;
	
	/*
	 * Method Name: Ellipse
	 * Purpose: Constructs a new Circle object extending the GraphicObject class
	 * Parameters:
	 * - newX: The x-coordinate of the object on the StdDraw canvas
	 * - newY: The y-coordinate of the object on the StdDraw canvas
	 * - red: The red RGB value for the color of the Ellipse
	 * - green: The green RGB value for the color of the Ellipse
	 * - blue: The blue RGB value for the color of the Ellipse
	 * - newSemiMajor: The semi major length of the Ellipse
	 * - newSemiMinor: The semi minor length of the Ellipse
	 * Preconditions: 
	 * - The x, y coordinates should be within the bounds of the canvas
	 * - Both axis lengths should be valid lengths to properly draw the shape
	 * Postconditions: Constructs a new Ellipse object at the specified location with the specified color and axis lengths
	 * Exceptions: N/A
	 */
	public Ellipse(double newX, double newY, int red, int green, int blue, double newSemiMajor, double newSemiMinor) {
		super(newX, newY, red, green, blue);
		this.semiMajorAxis = newSemiMajor;
		this.semiMinorAxis = newSemiMinor;
	}
	
	/*
	 * Method Name: draw
	 * Purpose: Override method to draw the Ellipse object in the active StdDraw canvas
	 * Parameters: N/A
	 * Preconditions:
	 * - The StdDraw canvas must be setup and configured properly before drawing
	 * Postconditions: An ellipse is drawn at the (x, y) coordinates with the color, 
	 * 		and axis lengths specified in this Object
	 * Exceptions: N/A
	 */
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledEllipse(this.getX(), this.getY(), this.semiMajorAxis, this.semiMinorAxis);
	}

	/*
	 * Method Name: calculateArea
	 * Purpose: Override method to calculates the area of this Ellipse object in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - This Ellipse should have valid axis lengths to be drawn properly
	 * Postconditions: Returns the area of the Ellipse in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculateArea() {
		return Math.PI * this.semiMajorAxis * this.semiMinorAxis;
	}

	/*
	 * Method Name: calculatePerimeter
	 * Purpose: Override method to calculate the perimeter (circumference) of this Ellipse object 
	 * 		in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - This Ellipse should have valid axis lengths
	 * Postconditions: Returns the perimeter (circumference) of the circle in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculatePerimeter() {
		return 2 * Math.PI * Math.sqrt(((Math.pow(this.semiMajorAxis, 2)) + (Math.pow(this.semiMinorAxis, 2))) / 2);
	}
}