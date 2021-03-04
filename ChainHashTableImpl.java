package lesson8;

import java.util.ArrayList;
import java.util.List;

public class ChainHashTableImpl<K,V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }



    private final List<Item<K, V>>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ChainHashTableImpl(int maxSize) {
        this.data = new List[maxSize];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (data[index] != null) {
            List<Item<K, V>> listItem = data[index];
            for (int i = 0; i < listItem.size(); i++) {
                if (listItem.get(i).getKey().equals(key)) {
                    data[index].get(i).setValue(value);
                } else {
                    data[index].add(new Item<>(key, value));
                }
            }
            return true;
        }if(size < data.length) {
            data[index] = new ArrayList<>();
            data[index].add(new Item<>(key, value));
            size++;
            return true;
        }else {
            return false;
        }

    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        int indexList = indexOf(key);
        return indexList != -1 ? data[index].get(indexList).getValue() : null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        if (data[index] != null) {
            List<Item<K, V>> listItem = data[index];
            for (int i = 0; i < listItem.size(); i++) {
                if (listItem.get(i).getKey().equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        int indexList = indexOf(key);
        if (index == -1) {
            return null;
        }
        Item<K,V> returnItem = data[index].get(indexList);
        if(data[index].size() > 1){
            data[index].remove(indexList);
        }else{
            data[index].remove(indexList);
            data[index] = null;
            size--;
        }
        return returnItem.getValue();
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
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("----------");
    }
}
