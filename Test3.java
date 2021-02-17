package lesson3;

import lesson3.IQueue;
import lesson3.QueueImpl;

public class Test3 {

    public static void main(String[] args) {
        testDQueue();
    }



        private static void testDQueue() {
        IDQueue<Integer> queue = new DQueueImpl<>(5);
        System.out.println(queue.insertLeft(3));
        System.out.println(queue.insertRight(5));
        System.out.println(queue.insertLeft(1));
        System.out.println(queue.insertRight(2));
        System.out.println(queue.insertLeft(6));
        System.out.println(queue.insertRight(4));


        System.out.println("DQueue peekHead: " + queue.peekHead());
        System.out.println("DQueue peekTail: " + queue.peekTail());
        System.out.println("DQueue size: " + queue.size());
        System.out.println("DQueue is full: " + queue.isFull());

//            while (!queue.isEmpty()) {
//                System.out.println(queue.removeRight());
//            }

        System.out.println("Remove right : " + queue.removeRight());
        System.out.println("Remove left : " + queue.removeLeft());
        System.out.println("Remove left : " + queue.removeLeft());

    }
}