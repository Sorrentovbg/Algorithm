package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E>{

    protected int size;
    protected Node<E> firstElement;
    Iterator<E> it;



    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
//        firstElement = firstElement.next;

        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null){
            if(current.item.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }
        if(current == null){
            return false;
        }
        if(current == firstElement){
            firstElement = firstElement.next;
        }else {
            previous.next = current.next;
        }
        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null){
            if(current.item.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public void display() {
        System.out.println("----------");
        Node<E> current = firstElement;
        while (current != null){
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("----------");
    }

    @Override
    public Iterator<E> iterator() {

        it = new Iterator<>() {

            Node<E> current = firstElement;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value01 = null;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();

                }else {
                    value01 = current.item;
                    current = current.next;
                }
                return value01;
            }
        };

        return it;
    }
}
