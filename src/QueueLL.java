import java.util.LinkedList;
import java.util.List;

public class QueueLL<E> implements Queue<E> {
    private List<E> queue = new LinkedList<>();

    /**
     * Add a value to the end of the queue
     * @param obj the value to add
     */
    public void enqueue(E obj) {
        queue.add(obj);
    }
    
    /**
     * @return the value in the front of the queue.  Return null if the queue is
     * empty.  The queue is not changed.
     */
    public E peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }
    
    /**
     * Remove the front object from the queue.  Return null if the queue is empty.
     * @return the object removed
     */
    public E dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }
    
    /**
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    /**
     * @return a string representation of the values in the queue
     */
    public String toString() {
        String value = "";
        for (int i = 0; i < queue.size(); i++) {
            value = value + "  " + queue.get(i);
        }
        return value;
    }

}
