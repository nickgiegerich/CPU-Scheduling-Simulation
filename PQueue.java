/**
 * Defines a priority queue using a max-heap.
 * 
 *   
 *   
 * @author NickGiegerich
 *
 */

public class PQueue {



	MaxHeap<Process> PQueue;

	

	/**
	 * Constructor - makes a new priority queue
	 * 
	 */
	public PQueue() {

		PQueue = new MaxHeap<Process>();

	}



	/**
	 * Adding the process to the end of the priority queue
	 * 
	 * @param p
	 */
	public void enPQueue(Process p) {
		PQueue.add(p);
	}

	

	/**
	 * removing the process from the beginning of the priority queue
	 *
	 * @return - process that was removed
	 *
	 */

	public Process dePQueue() {

		Process extraction = PQueue.extractMaxHeap();
		extraction.resetTimeNotProcessed();

		return extraction;

	}


	

	/**
	 * Update the queue with a given time increment and priority level 
	 * 
	 * @param timeToIncrementPriority - user specified time increment 
	 * @param maxLevel - highest level that priority can be 
	 */

	public void update(int timeToIncrementPriority, int maxLevel) {

			PQueue.update(timeToIncrementPriority, maxLevel);

	}



	/**
	 * checking if the size of the queue is == 0
	 *
	 * @return - true if the size of queue == 0; false otherwise
	 */

	public boolean isEmpty() {

		return PQueue.size() == 0;

	}

}
