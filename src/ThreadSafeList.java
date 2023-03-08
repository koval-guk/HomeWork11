import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T>{
    volatile Object[] array = new Object[10];
    private final Lock lock = new ReentrantLock();

    public synchronized void add(T thing) {
        lock.lock();
        try {
            int count = 0;
            while (array[count] != null) {
                count++;
            }
            if (count == (array.length - 1)) {
                Object[] newArr = new Object[array.length + 10];
                System.arraycopy(array, 0, newArr, 0, array.length);
                array = newArr;
            }
            array[count] = thing;
        } finally {
            lock.unlock();
        }
    }

    public synchronized void remove(int index) {
        lock.lock();
        try {
            int i = index;
            int d = array.length - 1;
            while (i < array.length - 1) {
                array[i] = array[i + 1];
                i++;
            }
            array[i] = null;
            while (array[d] == null) {
                d--;
            }
            if (array.length - 1 - d > 10) {
                Object[] newArr = new Object[array.length - 10];
                System.arraycopy(array, 0, newArr, 0, array.length - 10);
                array = newArr;
            }
        }finally {
            lock.unlock();
        }
    }

    public T get(int index) {
        if (index <= array.length-1) {
            return (T) array[index];
        } else return null;
    }

    public int size() {
        return array.length;
    }
}
