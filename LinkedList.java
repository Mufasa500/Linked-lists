import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first, last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean add(T element) {
        // for the sake of lab, let's _not_ allow null data
        if(element == null) return false;

        Node<T> newNode = new Node<>(element);

        if(size == 0)
            first = newNode;
        else
            last.setNext(newNode);

        last = newNode;
        size++;

        return true;
    }

    public String toString() {
        String ret = "[";
        Node<T> ptr = first;
        for(int i = 0; i < size; i++) {
            ret += ptr.getData().toString() + ", ";
            ptr = ptr.getNext();
        }

        return size == 0 ? ret + "]" : ret.substring(0, ret.length() - 2) + "]";
    }

    
    private class LinkedListIterator implements Iterator<T> {
        Node<T> current = LinkedList.this.first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    
    public static int[] nCopies(LinkedList<Integer> x){
        return new int[]{2,2};
    }

    
    public static LinkedList<Integer> countingSort(LinkedList<Integer> lst) {
        return new LinkedList<Integer>();
    }

    
    public void reverse() {

    }

    
    public void shuffle() {

    }

    
    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(1);
        lst.add(2);
        Iterator<Integer> it = lst.iterator();
        System.out.println(it.next());

    }

}

