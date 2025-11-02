/**
 * Antony Punnassery
 * B01012905
 */

import java.util.ArrayList;

public class GenericQueue<T> {
    private ArrayList<T> queue;

    //Create an empty GenericQueue object
    public GenericQueue() { queue = new ArrayList<>(); }

    //Returns the number of elements in the GenericQueue
    public int size() { return queue.size(); }

    //Adds an element to the rear of the GenericQueue
    public void enqueue(T t) { queue.add(t); }

    //Removes and returns the front element
    public T dequeue() { return queue.remove(0); }

    //Returns the front element (doesn't remove it)
    public T peek() { return queue.get(0); }

    //Returns true if the GenericQueue is empty, false otherwise
    public boolean isEmpty() { return queue.isEmpty(); }

    //Return the position of the specified item and -1 if not found
    public int positionOf(T t) {
        return queue.indexOf(t);
    }

    //Removes the first occurrence of a specified item (From the front)
    public void remove(T t) {
        int index = queue.indexOf(t);
        if (index != -1) {
            queue.remove(index);
        } else {
            System.out.println("Error: item not in queue");
        }
    }
}

