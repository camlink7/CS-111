package Program3;
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
	 * Purpose: Constructs a new Process object with the given id and burstTime (given in seconds)
	 * Parameters:
	 * - id: The identifier for the process
	 * - burstTime: The total amount of time it takes for the execution to complete in SECONDS
	 * Preconditions: N/A
	 * Postconditions: Constructs a new Process object with the given parameters
	 * Exceptions: N/A
	 */
	public Process(String id, int burstTime) {
		this.id = id;
		this.burstTime = burstTime * 1000;
		this.totalWaitTime = 0;
		this.lastExecutionTime = 0;
		this.turnaroundTime = 0;
	}

	/*
	 * Method Name: Process
	 * Purpose: Constructs a new Process object given another Process object (copy constructor)
	 * Parameters:
	 * - otherProc: The given other process to create a deep copy from
	 * Preconditions: N/A
	 * Postconditions: Constructs a new, deep-copy Process object given another process object
	 * Exceptions: N/A
	 */
	public Process(Process otherProc) {
		this.id = otherProc.getID();
		this.burstTime = otherProc.getBurst();
		this.totalWaitTime = otherProc.getWaitTime();
		this.lastExecutionTime = otherProc.getLastExecutionTime();
		this.turnaroundTime = otherProc.getTurnaroundTime();
	}
	
	/*
	 * Method Name: getID
	 * Purpose: Gets the ID of the process
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the id of this Process object
	 * Exceptions: N/A
	 */
	public String getID() {
		return this.id;
	}

	/*
	 * Method Name: getBurst
	 * Purpose: Gets the burst time (in milliseconds) of this Process object
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the burst time of the process in milliseconds
	 * Exceptions: N/A
	 */
	public int getBurst() {
		return this.burstTime;
	}
	
	/*
	 * Method Name: getWaitTime
	 * Purpose: Gets the wait time of this Process
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the wait time of this Process in milliseconds
	 * Exceptions: N/A
	 */
	public int getWaitTime() {
		return this.totalWaitTime;
	}

	/*
	 * Method Name: getLastExecutionTime
	 * Purpose: Gets the last execution time in running milliseconds
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the last execution time of the process in milliseconds
	 * Exceptions: N/A
	 */
	public int getLastExecutionTime() {
		return this.lastExecutionTime;
	}
	
	/*
	 * Method Name: getTurnaroundTime
	 * Purpose: Gets the current turnaround time of the process (as of when the getTurnaroundTime is called)
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the current turnaround time of this Process in milliseconds
	 * Exceptions: N/A
	 */
	public int getTurnaroundTime() {
		return this.turnaroundTime;
	}

	/*
	 * Method Name: execute
	 * Purpose: Executes the process performing the calculations needed upon execution
	 * Parameters: 
	 * - currentTime: The running clock time of when the process is executed in milliseconds
	 * Preconditions: N/A
	 * Postconditions: Updates this Process's wait time, turnaround time, last execution time, and new burst time after execution
	 * Exceptions: N/A
	 */
	public void execute(int currentTime) {
		this.totalWaitTime += (currentTime - this.getLastExecutionTime());
		this.turnaroundTime += (currentTime - this.getLastExecutionTime()) + (TIME_SLICE_LENGTH);
		this.lastExecutionTime = currentTime + TIME_SLICE_LENGTH;
		this.burstTime -= TIME_SLICE_LENGTH;
	}

	/*
	 * Method Name: isComplete
	 * Purpose: Determines if the Process has fully completed its execution
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns true if the Process has fully completed execution, false if it needs to execute more
	 * Exceptions: N/A
	 */
	public boolean isComplete() {
		return this.burstTime <= 0;
	}
}