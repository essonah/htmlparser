/**
 * A stack is a LIFO (Last In First Out) data structure.  Values are 
 * pushed onto the top of the stack and popped from the top of the stack.
 * 
 * @param <E>
 */
public interface Stack<E> {
    /**
     * Add an object to the top of the stack
     * @param obj the object to add
     */
	public void push(E obj); 
	
	/**
	 * @return the top value on the stack.  Return null if the stack is empty.
	 * The stack is not changed.
	 */
	public E peek();
	
	/**
	 * Remove the top of the stack
	 * @return the value removed.  Return null if the stack is empty.
	 */
	public E pop();
	
	/**
	 * @return true if there is nothing in the stack
	 */
	public boolean isEmpty();
	
	/**
	 * @return a string representation of the stack.  The string starts with the
	 * top of the stack.  Each value of the stack is separated by 2 spaces.
	 */
	public String toString();
}
