package LLD.ConsumerProducerProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CommonBuffer {
    Queue<Integer> queue;
    int queueSize = 5;

    CommonBuffer(){
        this.queue = new LinkedList<>();
    }

    CommonBuffer(int size){
        this.queue = new LinkedList<>();
        this.queueSize = size;
    }

    public synchronized void produceItem(int items) {
        for(int i=0; i<items; i++) {
            if(queue.size()>=queueSize){
                try {
                    System.out.println("Waiting for the Queue to gain space");
                    wait();
                } catch (Exception e) {
                    System.out.println("Exception Occured");
                }
            }
            this.queue.add(1);
            System.out.println("Produced Item"+(i+1));
//            System.out.println("Notifying that an item has been added");
            notifyAll(); // <-- IMPORTANT
        }
    }

    public synchronized void consumeItem(int items) {
        for(int i=0; i<items; i++) {
            if(queue.isEmpty()){
                try {
                    System.out.println("Waiting for the Queue to get elements");
                    wait();
                } catch (Exception e) {
                    System.out.println("Exception Occured");
                }
            }
            this.queue.remove();
            System.out.println("Consumed Item"+(i+1));
//            System.out.println("Notifying that an item has been consumed");
            notifyAll();  // <-- IMPORTANT
        }
    }
}
