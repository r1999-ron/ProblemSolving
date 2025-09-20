package multithreading_problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterLock {

    private final int max;
    private int number = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public OddEvenPrinterLock(int max){
        this.max = max;
    }

    public void printOdd(){
        while (true) {
            lock.lock();
            try {
                while (number % 2 == 0) condition.await();
                if (number > max) {
                    condition.signalAll();
                    break;
                }
                System.out.println("Odd: " + number);
                number++;
                condition.signalAll();
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            finally { lock.unlock(); }
        }
    }

    private void printEven(){
        while (true) {
            lock.lock();
            try {
                while (number % 2 != 0) condition.await();
                if (number > max) {
                    condition.signalAll();
                    break;
                }
                System.out.println("Even: " + number);
                number++;
                condition.signalAll();
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            finally { lock.unlock(); }
        }
    }
    public static void main(String[] args) {
        OddEvenPrinterLock printer = new OddEvenPrinterLock(10);
        Thread t1 = new Thread(printer::printOdd, "Odd-Thread");
        Thread t2 = new Thread(printer::printEven, "Even-Thread");

        t1.start();
        t2.start();
    }


}
