/**
 * A queue is a FIFO (First In First Out) data structure.  Values are 
 * enqueued at one end and dequeued from the other end.
 *
 * @param <E> The type of values stored in the queue.
 */
public interface Queue<E> {
    /**
     * Add a value to the end of the queue
     * @param obj the value to add
     */
	public void enqueue(E obj);
	
	/**
	 * @return the value in the front of the queue.  Return null if the queue is
	 * empty.  The queue is not changed.
	 */
	public E peek();
	
	/**
	 * Remove the front object from the queue.  Return null if the queue is empty.
	 * @return the object removed
	 */
	public E dequeue();
	
	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty();
	
	/**
	 * @return a string representation of the values in the queue
	 */
	public String toString();
}
