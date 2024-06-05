import java.util.LinkedList;
import java.util.List;

public class StackLL<E> implements Stack<E> {
    private List<E> stack = new LinkedList<>();
    
    /**
     * Add an object to the top of the stack
     * @param obj the object to add
     */
    public void push(E obj) {
        stack.add(0, obj);
    }
    
    /**
     * @return the top value on the stack.  Return null if the stack is empty.
     * The stack is not changed.
     */
    public E peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(0);
    }
    
    /**
     * Remove the top of the stack
     * @return the value removed.  Return null if the stack is empty.
     */
    public E pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(0);
    }
    
    /**
     * @return true if there is nothing in the stack
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    /**
     * @return a string representation of the stack.  The string starts with the
     * top of the stack.  Each value of the stack is separated by 2 spaces.
     */
    public String toString() {
        String value = "";
        for (int i = 0; i < stack.size(); i++) {
            value = value + "  " + stack.get(i);
        }
        return value;
    }
    

}
