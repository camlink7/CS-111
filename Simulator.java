import java.util.Scanner;

public class Simulator {
	public static PriorityQueue enqueueProcesses(String filename, boolean priority) {
		return null;
	}

	public static void simulate(PriorityQueue queue) {
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String filename = in.nextLine();
		in.close();

		PriorityQueue fifo = enqueueProcesses(filename, false);
		simulate(fifo);

		PriorityQueue priority = enqueueProcesses(filename, true);
		simulate(priority);
	}
}