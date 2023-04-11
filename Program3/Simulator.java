package Program3;
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

public class Simulator {
	public static final int MS_PER_MINUTE = 60000;
	public static final int MS_PER_SECOND = 1000;

	private static int totalProcessesCount;
	
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
	
	public static String formatTimestamp(int milliseconds) {
		int minutes = milliseconds / MS_PER_MINUTE;
		int seconds = milliseconds % MS_PER_MINUTE / MS_PER_SECOND;
		int remainingMs = (int) (Math.round((double)(milliseconds % MS_PER_SECOND) / 10));
		return String.format("%01d", minutes) + ":" + String.format("%02d", seconds) + "." + String.format("%02d", remainingMs);
	}
}