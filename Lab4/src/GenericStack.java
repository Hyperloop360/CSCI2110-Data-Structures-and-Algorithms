/**
 * Antony Punnassery
 * B01012905
 */
import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> stack;

    //Crate Empty GenericStack Object
    public GenericStack(){
        stack = new ArrayList<>();
    }

    //Returns the number of elements in the GenericStack
    public int size(){
        return stack.size();
    }

    //Removes and returns the top element in the GenericStack
    public T pop() {
        return stack.remove(stack.size() - 1);
    }

    //Returns the top element in the GenericStack (doesn’t remove it)
    public T peek() {
        return stack.get(stack.size() - 1);
    }

    //Adds an element to the top of the GenericStack
    public void push(T element){
        stack.add(element);
    }

    //Returns true if the GenericStack is empty, false otherwise
    public boolean isEmpty(){
        return stack.isEmpty();
    }

}