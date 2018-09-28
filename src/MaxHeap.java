import java.util.ArrayList;


/**
 * 
 * @author NickGiegerich
 *
 */
public class MaxHeap<T>{
	
	private ArrayList<Process> maxHeap;
	private int size; 
	
	
	/**
	 * Constructor for building MaxHeap Array 
	 * 
	 * @param maxHeap
	 * 
	 */
	public MaxHeap() {
		maxHeap = new ArrayList<Process>();
		size = 0;
	}
	
	
	
	
	/**
	 * 
	 * @param p
	 */
	public void add(Process p) {
		maxHeap.add(p);
		size++;
		maxHeapifyUp(maxHeap,maxHeap.size()-1);
	}
	

	
	/**
	 * Finding the index of the left child 
	 * 
	 * @param index - index of the parent node 
	 * @return - the location of the left child 
	 * 
	 */
	public int getLeftIndex(int index) {
		return (index*2)+1;
	}
	
	
	
	
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void exchange(int i, int j) {
		if(maxHeap.size() > 0 && i!=j) {
			Process temp = maxHeap.get(i);
			maxHeap.set(i,maxHeap.get(j));
			maxHeap.set(j, temp);
		}
	}
	
	
	
	/**
	 * Finding the index of the right child 
	 * 
	 * @param index - index of the parent node 
	 * @return - the index of the right child node 
	 * 
	 */
	public int getRightIndex(int index) {
		return (1+index) * 2;
	}
	

	/**
	 * Finding the index of the parent node
	 * 
	 * @param index - index of the child node
	 * @return - the index of the parent node 
	 */
	public int getParentIndex(int index){
		return ((index-1)/2);
		
	}
	

	/**
	 * Method for getting the Max Heap 
	 * 
	 * @return - the Max Heap that has been constructed  
	 */
	public ArrayList<Process> getMaxHeapArray() {
		return maxHeap;
	}
	

	/**
	 * 
	 * @return
	 */
	public int size() {
		return maxHeap.size();
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Process get(int index) {
		return maxHeap.get(index);
	}
	
	
	/**
	 * 
	 * @param index
	 * @param element
	 */
	public void set(int index, Process element) {
			maxHeap.set(index, element);
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Process remove(int index) {
		return maxHeap.remove(index);
	}
	
	
	/**
	 * 
	 * @param A
	 * @param i
	 */
	public void maxHeapifyDown(ArrayList<Process> A, int i) {
			
		int l = getLeftIndex(i);
		int r = getRightIndex(i);
		int largest;
		
		if(l < A.size() && A.get(l).compareTo(A.get(i)) == 1) {
			largest = l;
		}else {
			largest = i; 
		}
		
		if(r < A.size() && A.get(r).compareTo(A.get(largest)) == 1) {
			largest = r; 
		}
		
		if(largest != i) {
			exchange(i,largest);
			maxHeapifyDown(A,largest);
		}		
	}
	
	
	/**
	 * 
	 * @param A
	 * @param i
	 */
	public void maxHeapifyUp(ArrayList<Process> A ,int i) {
		if(i != 0) {
			int parent = getParentIndex(i);
			if(A.get(i).compareTo(A.get(parent)) == 1) {
				exchange(i,parent);
				maxHeapifyUp(A,parent);
			}
		}
	}
	
	
	/**
	 * 
	 * @param timeToIncrementPriority
	 * @param maxLevel
	 */
	public void update(int timeToIncrementPriority, int maxLevel) {

		if(maxHeap.size() != 0) {

			for(int i = 0; i < maxHeap.size(); i++) {

				maxHeap.get(i).incrementTimeNotProcessed();

				if(maxHeap.get(i).getTimeNotProcessed() >= timeToIncrementPriority) {  

					maxHeap.get(i).resetTimeNotProcessed();
					if(maxHeap.get(i).getPriority() < maxLevel) {
						
						maxHeap.get(i).makePriority();
						maxHeapifyUp(maxHeap, i);
					}

				}


			}

		}

		

	}
	
	
	/**
	 * 
	 * @return
	 */
	public Process extractMaxHeap() {
		Process max = null;
		if(maxHeap.size() > 0) {
			exchange(0,maxHeap.size()-1);
			max = maxHeap.remove(maxHeap.size()-1);
			size--;
			maxHeapifyDown(maxHeap,0);
		}
		return max;
	}

}




/**
 * This is a method that will build a max heap starting at the last
 * non-leaf node. It is not used for this project but it is here for 
 * future reference....
 * 
 * 
 * @param A - Takes an array list with Process as the type 
 *//*
	public void buildMaxHeap(ArrayList<Process> A){
		if(size != 0){
			for(int i = (int) Math.floor(maxHeap.size()/2); i > 0; i--) {
				maxHeapifyDown(A,i);
			}
		}
	}*/
