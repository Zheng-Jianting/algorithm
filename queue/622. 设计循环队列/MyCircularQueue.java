import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyCircularQueue {
    int[] queue;
    int count;
    int head;
    Lock lock = new ReentrantLock();

    public MyCircularQueue(int k) {
        queue = new int[k];
        count = 0;
        head = 0;
    }
    
    public boolean enQueue(int value) {
        try {
            lock.lock();
            if (isFull()) {
                return false;
            }
            int tailBack = (head + count) % queue.length;
            queue[tailBack] = value;
            count++;
        } finally {
            lock.unlock();
        }
        return true;
    }
    
    public boolean deQueue() {
        try {
            lock.lock();
            if (isEmpty()) {
                return false;
            }
            count--;
            head = (head + 1) % queue.length;
        } finally {
            lock.unlock();
        }
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[(count + head - 1) % queue.length];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == queue.length;
    }
}