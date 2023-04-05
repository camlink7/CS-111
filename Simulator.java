import java.util.Scanner;

public class Simulator {
	public static final int MS_PER_MINUTE = 60000;
	public static final int MS_PER_SECOND = 1000;

	
	public static PriorityQueue enqueueProcesses(String filename, boolean priority) {
		return new PriorityQueue();
	}

	public static void simulate(PriorityQueue queue) {
		int currentTime = 0; //In Milliseconds
		while (!queue.isEmpty()) {
			Process process = queue.dequeue();
			process.execute(currentTime);
			System.out.println(process.getID() + " executed; " + Simulator.formatTimestamp(process.getBurst()) + " remaining");
		}
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		System.out.print("Enter file name: ");
//		String filename = in.nextLine();
//		in.close();
//
//		PriorityQueue fifo = enqueueProcesses(filename, false);
//		simulate(fifo);
//
//		PriorityQueue priority = enqueueProcesses(filename, true);
//		simulate(priority);
		System.out.println(Simulator.formatTimestamp(3251));
	}
	
	public static String formatTimestamp(int milliseconds) {
		int minutes = milliseconds / MS_PER_MINUTE;
		int seconds = milliseconds / MS_PER_SECOND;
		int remainingMs = milliseconds % MS_PER_SECOND / 10;
		return String.format("%01d", minutes) + ":" + String.format("%02d", seconds) + "." + String.format("%02d", remainingMs);
	}
}