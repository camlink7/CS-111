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
	public static final int TIME_SLICE_LENGTH = 100; //In Milliseconds
	
	private String id;
	private int burstTime; //In Milliseconds
	private int totalWaitTime; //In Milliseconds
	private int lastExecutionTime; //In Milliseconds
	private int turnaroundTime; //In Milliseconds
	
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
		this.turnaroundTime = 0;
	}

	//Copy Constructor
	public Process(Process otherProc) {
		this.id = otherProc.getID();
		this.burstTime = otherProc.getBurst();
		this.totalWaitTime = otherProc.getWaitTime();
		this.lastExecutionTime = otherProc.getLastExecutionTime();
		this.turnaroundTime = otherProc.getTurnaroundTime();
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
	
	public int getTurnaroundTime() {
		return this.turnaroundTime;
	}

	public void execute(int currentTime) {
		this.totalWaitTime += (currentTime - this.getLastExecutionTime());
		this.turnaroundTime += (currentTime - this.getLastExecutionTime()) + (TIME_SLICE_LENGTH);
		this.lastExecutionTime = currentTime + TIME_SLICE_LENGTH;
		this.burstTime -= TIME_SLICE_LENGTH;
	}

	public boolean isComplete() {
		return this.burstTime <= 0;
	}
}