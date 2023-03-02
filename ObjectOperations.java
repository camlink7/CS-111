import java.util.Scanner;
import java.util.Arrays;

public class ObjectOperations {
	private static GraphicObject[] array;
	private static int currentSize;
	
	public static GraphicObject[] fillArray(Scanner filename) {
		///Get the number of shapes and init the array with that count
		int numberOfShapes = Integer.parseInt(filename.nextLine());
		array = new GraphicObject[numberOfShapes];
		currentSize = 0;
		
		//Read each shape from the file
		for (int i = 0; i < numberOfShapes; i++) {
			String[] shapeData = filename.nextLine().split(" ");
			
			String[] tempShapeData = new String[shapeData.length];
			int tempCurrentSize = 0;
			//Remove the shapeData elements that are simply blank spaces by stripping the element
			for (int x = 0; x < shapeData.length; x++) {
				if (!shapeData[x].strip().equals("")) {
					tempShapeData[tempCurrentSize] = shapeData[x];
					tempCurrentSize++;
				}
			}
			
			//Only copy to the part that is filled in, so no null values are still in the shape data
			shapeData = Arrays.copyOfRange(tempShapeData, 0, tempCurrentSize);
			
			//Instantiate an object for the appropriate shape type
			double x = Double.parseDouble(shapeData[1]);
			double y = Double.parseDouble(shapeData[2]);
			int red = Integer.parseInt(shapeData[3]);
			int green = Integer.parseInt(shapeData[5]);
			int blue = Integer.parseInt(shapeData[4]);
			switch (shapeData[0].toUpperCase()) {
				case "C":
					double radius = Double.parseDouble(shapeData[6]);
					array[currentSize] = new Circle(x, y, red, green, blue, radius);
					currentSize++;
					break;
				case "R": 
					double length = Double.parseDouble(shapeData[6]);
					double width = Double.parseDouble(shapeData[7]);
					array[currentSize] = new Rectangle(x, y, red, green, blue, length, width);
					currentSize++;
					break;
				case "S":
					double sideLength = Double.parseDouble(shapeData[6]);
					array[currentSize] = new Square(x, y, red, green, blue, sideLength);
					currentSize++;
					break;
				case "E":
					double semiMinorAxis = Double.parseDouble(shapeData[6]);
					double semiMajorAxis = Double.parseDouble(shapeData[7]);
					array[currentSize] = new Ellipse(x, y, red, green, blue, semiMajorAxis, semiMinorAxis);
					currentSize++;
					break;
			}
		}
		return array;
	}
	
	public static void drawList(GraphicObject[] objectList) {
		for (int i = 0; i < objectList.length; i++) {
			objectList[i].draw();
		}
	}
	
	public static void printList(GraphicObject[] objectList) 
	{
		for (int i = 0; i < objectList.length; i++) {
			System.out.println(objectList[i].toString());
		}
	}
}
