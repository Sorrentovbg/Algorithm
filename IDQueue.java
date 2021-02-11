package lesson3;

public interface IDQueue<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekHead();

    E peekTail();

    int size();

    boolean isEmpty();

    boolean isFull();
}
