import java.io.File;
import java.util.Scanner;

public class Tester {
	public static void main(String args[]) {		
		try {
			//Prompt the user for the name of the file
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the name of the file (file must be in local directory): ");
			String filename = input.nextLine();
			
			//Initialize and setup the StdDraw canvas
			StdDraw.setCanvasSize(1000, 1000);
			StdDraw.setXscale(0, 1000);
			StdDraw.setYscale(0, 1000);
			StdDraw.setPenRadius(0.02);
			
			GraphicObject[] fileShapeList = ObjectOperations.fillArray(new Scanner(new File(filename)));
			ObjectOperations.drawList(fileShapeList);
			ObjectOperations.printList(fileShapeList);
		} 
		catch(Exception e) {
			System.err.println("Something went wrong when trying to read that file!");
			System.err.println(e);
		}
	}
}
