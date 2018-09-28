import java.util.Random;

/**
 * Randomly generates processes with a given probability. At beginning
 * of each time unit, whether a process will arrive is decided by the given probability. In addition,
 * while generating a new process, both its priority and the required time units to finish the
 * process are randomly generated within given ranges.
 * 
 * @author NickGiegerich
 *
 */
public class ProcessGenerator {
	
	private double probability;
	Random rand;
	
	/**
	 * Constructor for new probability 
	 * 
	 * @param probability
	 */
	public ProcessGenerator(double probability) {
		this.probability = probability;
		rand = new Random();
	}
	
	
	/**
	 * Checking to see if the process generator probability is less than or equal to given probability 
	 * 
	 * @return - True if random number is less than or equal to probability; false otherwise
	 */
	public boolean query() {
		
		boolean retVal = false;
		double randomize = rand.nextDouble();
		
		if(randomize <= probability) {
			return true;
		}
		
		return retVal;
	}
	
	
	/**
	 * Getting a new process that takes in parameters 
	 * 
	 * @param currentTime
	 * @param maxProcessTime
	 * @param maxLevel
	 * @return - the new process that was made
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		rand = new Random();
		
		int priorityLevel = rand.nextInt(maxLevel) + 1;
		int timeRemaining = rand.nextInt(maxProcessTime) + 1;
		
		Process newProcess = new Process(priorityLevel, timeRemaining, currentTime);
		newProcess.resetTimeNotProcessed();
		
		return newProcess;
	}

}