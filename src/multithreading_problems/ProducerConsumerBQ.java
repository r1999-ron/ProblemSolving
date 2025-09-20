package multithreading_problems;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerBQ {
    private final Queue<Integer> q;
    private final int capacity;

    public ProducerConsumerBQ(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    // Producer adds item
    public void add(int item) throws InterruptedException {
        synchronized (q) {
            while (q.size() == capacity) {   // use while not if
                q.wait();
            }
            q.add(item);
            System.out.println("Produced: " + item);
            q.notifyAll(); // notify waiting consumers
        }
    }

    // Consumer removes item
    public int remove() throws InterruptedException {
        synchronized (q) {
            while (q.isEmpty()) {  // use while not if
                q.wait();
            }
            int element = q.poll();
            System.out.println("Consumed: " + element);
            q.notifyAll(); // notify waiting producers
            return element;
        }
    }

    // Quick demo
    public static void main(String[] args) {
        ProducerConsumerBQ buffer = new ProducerConsumerBQ(3);

        // Producer
        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.add(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer
        Runnable consumer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.remove();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer, "Producer").start();
        new Thread(consumer, "Consumer").start();
    }
}