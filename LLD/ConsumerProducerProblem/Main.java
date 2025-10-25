package LLD.ConsumerProducerProblem;

public class Main {
    public static void main(String[] args) {
        CommonBuffer buffer = new CommonBuffer(2);
        Thread producer = new Thread(()->{
            buffer.produceItem(5);
        });
        Thread consumer = new Thread(()->{
            buffer.consumeItem(5);
        });
        consumer.start();
        producer.start();
    }
}
