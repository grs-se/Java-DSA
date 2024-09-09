package datastructures.queue;

public class Main {
    public static void main(String[] args) {

        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

//        myQueue.getFirst();
//        myQueue.getLast();
//        myQueue.getLength();

//        myQueue.printQueue();

        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
    }
}
