/**
 * Defines a Process. Used manage processes within a priority queue.
 * 
 * 
 * @author NickGiegerich
 *
 */
public class Process implements Comparable<Process> {
	
	private int priorityLevel;
	private int timeRemaining; 
	private int arrivalTime;
	private int timeNotProcessed;
	
	
	/**
	 * Constructor
	 * 
	 * @param priorityLevel
	 * @param timeRemaining
	 * @param arrivalTime
	 */
	public Process(int priorityLevel, int timeRemaining, int arrivalTime) {
		this.priorityLevel = priorityLevel;
		this.timeRemaining = timeRemaining;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}

	

	/**
	 * Increases the priority level by 1 
	 * 
	 */
	public void makePriority() {
		 priorityLevel++;
	}
	
	
	/**
	 * Gets the current priority level
	 * 
	 * @return
	 */
	public int getPriority() {
		return priorityLevel;
	}
	
	
	/**
	 * Sets the priority level
	 * 
	 * @param priorityLevel
	 */
	public void setPriorityLevel(int pLevel) {
		this.priorityLevel = pLevel;
	}
	
	
	/**
	 * Gets the time remaining 
	 * 
	 * @return
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	
	/**
	 * Sets the time until finish 
	 * 
	 * @param timeToFinish
	 */
	public void setTimeRemaining(int timeToFinish) {
		this.timeRemaining = timeToFinish;
	}
	
	
	
	/**
	 * Gets the arrival time 
	 * 
	 * @return
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	
	/**
	 * Sets the arrival time 
	 * 
	 * @param arrivalTime
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
	@Override
	public int compareTo(Process o) {
		if(this.priorityLevel > o.getPriority()) {
			return 1;
		}else if(this.priorityLevel < o.getPriority()) {
			return -1;
		}else if(this.arrivalTime <= o.getArrivalTime()) {
			 
				return 1;
				
		}
		return -1;
	}
	
	
	/**
	 * Reduces the time remaining by 1
	 * 
	 */
	public void reduceTimeRemaining() {
		timeRemaining--;
	}
	
	
	/**
	 * Checks if finished 
	 * 
	 * @return - true if finished; false otherwise 
	 */
	public boolean finish() {
		return timeRemaining == 0;
	}
	
	
	
	
	/**
	 * Gets the time not processed 
	 * 
	 * @return - time not processed
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	
	
	/**
	 * Reset the time not processed back to 0 
	 * 
	 */
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0; 
	}
	
	/**
	 * 
	 */
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}



}
