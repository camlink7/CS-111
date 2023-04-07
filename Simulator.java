/*
 * Name: Camden Link
 * Assignment: Program 3
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-04-05
 * Purpose: This file contains the Simulator, which simulates a CPU running different processes as outlined in 
 * 	program 3
 */

import java.util.Scanner;
import java.io.File;

/*
 * Class Name: Simulator
 * Purpose: This class represents a CPU in which processes are created from an input text file and simulated being ran in a processor. This is per the outline in Program 3
 * Exceptions:
 * - Could throw an exception when reading from the input.txt file if the file is missing or the content of the file is not in the proper format
 */
public class Simulator {
	public static final int MS_PER_MINUTE = 60000;
	public static final int MS_PER_SECOND = 1000;

	private static int totalProcessesCount;
	
	/*
	 * Method Name: enqueueProcesses
	 * Purpose: Loads the Processes from the input file into a PriorityQueue object
	 * Parameters:
	 * - filename: The name of the input file to load the processes from
	 * - priority: The flag variable representing whether the processes should be enqueued based on their priority or simply enqueued.
	 * Preconditions: 
	 * - filename must be a valid file with proper formatting for input (each line should contain: "{Process Name} {batch time}", e.g.: "ProcA 13"
	 * Postconditions: Enqueues the processes into either a normal queue or priority queue from the input text file
	 * Exceptions:
	 * - Exception: May throw exception if the input filename is not found or the content of the input file is impropperly formatted
	 */
	public static PriorityQueue enqueueProcesses(String filename, boolean priority) throws Exception {
		try {
			Scanner file = new Scanner(new File(filename));
			PriorityQueue queue = new PriorityQueue();
			
			while (file.hasNextLine()) {
				String[] procInfo = file.nextLine().trim().split(" ");
				String procId = procInfo[0];
				int burstTime = Integer.valueOf(procInfo[1]);
				
				Process newProcess = new Process(procId, burstTime);
				
				if (priority) {
					queue.priorityEnqueue(newProcess);
				}
				else {
					queue.enqueue(newProcess);
				}
				
				Simulator.totalProcessesCount++;
			}
			return queue;
		} 
		catch (Exception e) {
			System.out.println("Error when loading the input file!");
			throw e;
		}
	}

	/*
	 * Method Name: simulate
	 * Purpose: Runs the simulation sequence on a given PriorityQueue of Processes
	 * Parameters:
	 * - queue: The PriorityQueue containing the processes to be executed
	 * Preconditions: N/A
	 * Postconditions: Each process will be executed until all processes are finished. Each time a process is executed, info about that is printed.
	 * 		When a process is finished, a status statement will be printed. At the end, average wait time, average turnaround time, and total elapsed time is
	 * 		printed.
	 * Exceptions: N/A
	 */
	public static void simulate(PriorityQueue queue) {
		int currentTime = 0; //In Milliseconds
		int totalElapsed = 0;
		
		int averageWaitTime = 0;
		int averageWaitTimeCount = 0;
		
		int averageTurnaroundTime = 0;
		int averageTurnaroundTimeCount = 0;
		
		while (!queue.isEmpty()) {
			Process process = queue.dequeue();
			process.execute(currentTime);
			System.out.println(process.getID() + " executed; " + Simulator.formatTimestamp(process.getBurst()) + " remaining");
			if (!process.isComplete()) {
				queue.enqueue(process);
			}
			else {
				int turnaroundTime = process.getTurnaroundTime();
				totalElapsed += turnaroundTime;
				int totalWaitTime = process.getWaitTime();
				System.out.println(process.getID() + " finished; " + 
						Simulator.formatTimestamp(totalWaitTime) + " wait time; " +
						Simulator.formatTimestamp(turnaroundTime) + " turnaround time");
				
				//Add to the average turnaround time
				averageTurnaroundTime += turnaroundTime;
				averageTurnaroundTimeCount++;
				
				//Add to the average wait time
				averageWaitTime += totalWaitTime;
				averageWaitTimeCount++;
			}
			
			//Increment current time
			currentTime += Process.TIME_SLICE_LENGTH;
		}
		
		//Complete the average wait time and turnaround time calculations
		averageTurnaroundTime /= averageTurnaroundTimeCount;
		averageWaitTime /= averageWaitTimeCount;
		
		
		//Print out the concluding statement
		System.out.println(Simulator.totalProcessesCount + " processes; " + 
				Simulator.formatTimestamp(averageWaitTime) + " average wait time; " +
				Simulator.formatTimestamp(averageTurnaroundTime) + " average turnaround time; " +
				Simulator.formatTimestamp(totalElapsed) + " total elapsed time"
		);
		
		//Reset the total process count 
		Simulator.totalProcessesCount = 0;
	}

	/*
	 * Method Name: main
	 * Purpose: The main method in which the user is prompted for the input filename and both fifo and priority style processes are executed
	 * Parameters:
	 * -args: The string of arguments accompanied by the default java main entry point
	 * Preconditions: N/A
	 * Postconditions: Gathers the filename of the input file from the user and simulates two queues of Processes.
	 * 		One queue is priority based, and the other is simple FIFO based
	 * Exceptions: 
	 * -Exception: May throw an exception that is passed on from the enqueueProcesses method
	 */
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String filename = in.nextLine();
		in.close();
		
		PriorityQueue fifo = enqueueProcesses(filename, false);
		simulate(fifo);

		PriorityQueue priority = enqueueProcesses(filename, true);
		simulate(priority);
	}
	
	/*
	 * Method Name: formatTimestamp
	 * Purpose: Formats a given timestamp in milliseconds to be simply displayed
	 * Parameters:
	 * -milliseconds: The milliseconds timestamp to format
	 * Preconditions: N/A
	 * Postconditions: 
		Returns a String with the formatted timestamp in the following format: {minutes}:{seconds}.{milliseconds}
		Each value is padded with 0s
	 * Exceptions: N/A
	 */
	public static String formatTimestamp(int milliseconds) {
		int minutes = milliseconds / MS_PER_MINUTE;
		int seconds = milliseconds % MS_PER_MINUTE / MS_PER_SECOND;
		int remainingMs = (int) (Math.round((double)(milliseconds % MS_PER_SECOND) / 10));
		return String.format("%01d", minutes) + ":" + String.format("%02d", seconds) + "." + String.format("%02d", remainingMs);
	}
}