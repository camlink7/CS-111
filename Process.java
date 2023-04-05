public class Process {
	private final int TIME_SLICE_LENGTH = 100; //In Milliseconds
	
	private String id;
	private int burstTime; //In Milliseconds
	private int totalWaitTime; //In Milliseconds
	private int lastExecutionTime; //In Milliseconds
	
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