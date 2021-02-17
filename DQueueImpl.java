package lesson3;

public class DQueueImpl<E> implements IDQueue<E>{

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;

    protected final E[] data;
    protected int size;

    private int tail;
    private int head;

    @SuppressWarnings("unchecked")
    public DQueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
//        head++;
        size++;
        return true;

    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }
        data[head++] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E removedValue = data[tail];
        data[tail--] = null;
        size--;
        return removedValue;
    }

    @Override
    public E removeRight() {
        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }
        E removedValue = data[head-1];
        data[--head] = null;
        size--;
        return removedValue;
    }

    @Override
    public E peekHead() {
        return data[head - 1];
    }
    @Override
    public E peekTail() {
        return data[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
