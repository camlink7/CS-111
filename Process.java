/*
 * Name: Camden Link
 * Assignment: Program 3
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-04-05
 * Purpose: This file contains the Process class, representing a CPU process as specified in Program 3
 */

/*
 * Class Name: Process
 * Purpose: Class that allows for the calculation of information about the Process as well as executing the process
 * Exceptions: N/A
 */
public class Process {
	private static final int TIME_SLICE_LENGTH = 100; //In Milliseconds
	
	private String id;
	private int burstTime; //In Milliseconds
	private int totalWaitTime; //In Milliseconds
	private int lastExecutionTime; //In Milliseconds
	
	/*
	 * Method Name: Process
	 * Purpose: Constructs a new Rectangle object
	 * Parameters:
	 * - id: The identifier for the process
	 * - burstTime: The total amount of time it takes for the execution to complete
	 * Preconditions: N/A
	 * Postconditions: N/A
	 * Exceptions: N/A
	 */
	public Process(String id, int burstTime) {
		this.id = id;
		this.burstTime = burstTime * 1000;
		this.totalWaitTime = 0;
		this.lastExecutionTime = 0;
	}

	public String getID() {
		return this.id;
	}

	public int getBurst() {
		return this.burstTime;
	}
	

	public int getWaitTime() {
		return this.totalWaitTime;
	}

	public int getLastExecutionTime() {
		return this.lastExecutionTime;
	}

	public void execute(int currentTime) {
		this.totalWaitTime += (currentTime - this.getLastExecutionTime());
		this.lastExecutionTime = currentTime + TIME_SLICE_LENGTH;
		this.burstTime -= TIME_SLICE_LENGTH;
	}

	public boolean isComplete() {
		return this.burstTime <= 0;
	}
}