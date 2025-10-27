package Q1.BigCircularlyLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class myCLL<T extends Number & Comparable<T>>implements Iterable<T>  {

    public class Node <T>{
        private T data;
        public Node<T> myNext;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
        public T getData() {
            return this.data;
        }
    }

    private Node<T> myRoot;

    public boolean addfront(T n) {
        Node<T> t = new Node<>(n);
        t.myNext = myRoot;
        myRoot = t;
        return true;
    }

    public boolean addlast(T n) {
        Node<T> t = new Node<>(n);
        if (myRoot == null) {
            myRoot = t;
            return true;
        }
        Node<T> c = myRoot;
        while (c.myNext != myRoot) c = c.myNext;
        c.myNext = t;
        return true;
    }

    public void printList() {
        for (Node<T> c = myRoot; c != null; c = c.myNext)
            System.out.print(c.getData() + " ");
        System.out.println();
    }

    public int getCount() {
        int cnt = 0;
        for (Node<T> c = myRoot; c != null; c = c.myNext) cnt++;
        return cnt;
    }

    public boolean add(T num, int spot) {
        if (spot < 0 || spot > getCount()) return false;
        if (spot == 0) return addfront(num);
        Node<T> c = myRoot;
        for (int i = 0; i < spot - 1; i++) c = c.myNext;
        Node<T> n = new Node<>(num);
        n.myNext = c.myNext;
        c.myNext = n;
        return true;
    }

    public boolean isEmpty() {
        return myRoot == null;
    }

    public boolean isThere(T n) {
        for (Node<T> c = myRoot; c != null; c = c.myNext)
            if (c.getData().equals(n)) return true;
        return false;
    }

    public T getFirst() {
        return myRoot == null ? null : myRoot.getData();
    }

    public T getLast() {
        if (myRoot == null) return null;
        Node<T> c = myRoot;
        while (c.myNext != null) c = c.myNext;
        return c.getData();
    }

    public T getSpot(int spot) {
        if (spot < 0 || spot >= getCount()) return null;
        Node<T> c = myRoot;
        for (int i = 0; i < spot; i++) c = c.myNext;
        return c.getData();
    }

    public void removeFirst() {
        if (myRoot != null) myRoot = myRoot.myNext;
    }

    public void removeLast() {
        if (myRoot == null) return;
        if (myRoot.myNext == null) {
            myRoot = null;
            return;
        }
        Node<T> c = myRoot;
        while (c.myNext.myNext != null) c = c.myNext;
        c.myNext = null;
    }

    public int countLess10() {
        int cnt = 0;
        for (Node<T> c = myRoot; c != null; c = c.myNext)
            if (c.getData().intValue() < 10) cnt++;
        return cnt;
    }

    public void removeSpot(int pos) {
        if (pos < 0 || pos >= getCount()) return;
        if (pos == 0) {
            removeFirst();
            return;
        }
        Node<T> c = myRoot;
        for (int i = 0; i < pos - 1; i++) c = c.myNext;
        c.myNext = c.myNext.myNext;
    }

    public void clear() {
        myRoot = null;
    }

    public boolean checkForNum(T n) {
        return isThere(n);
    }

    public T getNum(int pos) {
        return getSpot(pos);
    }

    public myCLL<T> getReverse() {
        myCLL<T> r = new myCLL<>();
        for (Node<T> c = myRoot; c != null; c = c.myNext) r.addfront(c.getData());
        return r;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> c = myRoot;
            public boolean hasNext() { return c != null; }
            public T next() { T v = c.getData(); c = c.myNext; return v; }
        };
    }

    public double avg() {
        int n = 0; double s = 0;
        for (T t : this) { s += t.doubleValue(); n++; }
        return n == 0 ? 0 : s / n;
    }

    public T min() {
        if (myRoot == null) return null;
        T m = myRoot.getData();
        for (T t : this) if (t.compareTo(m) < 0) m = t;
        return m;
    }

    public T max() {
        if (myRoot == null) return null;
        T m = myRoot.getData();
        for (T t : this) if (t.compareTo(m) > 0) m = t;
        return m;
    }

    public int findSlotMaxFirst() {
        if (myRoot == null) return -1;
        T mx = max();
        int i = 0;
        for (T t : this) { if (t.equals(mx)) return i; i++; }
        return -1;
    }

    public int findSlotMaxLast() {
        if (myRoot == null) return -1;
        T mx = max();
        int i = 0, f = -1;
        for (T t : this) { if (t.equals(mx)) f = i; i++; }
        return f;
    }

    public void sort() {
        ArrayList<T> a = new ArrayList<>();
        for (T t : this) a.add(t);
        Collections.sort(a);
        clear();
        for (T t : a) addlast(t);
    }

    public int lose58() {
        int cnt = 0;
        Node<T> c = myRoot, p = null;
        while (c.getData().equals(58)) {
            if (c.getData().intValue() == 58) {
                cnt++;
                if (c == myRoot) myRoot = c.myNext;
                else p.myNext = c.myNext;
            } else p = c;
            c = c.myNext;
        }
        return cnt;
    }

    public int getEvenCount() {
        int cnt = 0;
        for (T t : this) if (t.intValue() % 2 == 0) cnt++;
        return cnt;
    }

    public void killOdds() {
        Node<T> c = myRoot, p = null;
        while (c != null) {
            if (c.getData().intValue() % 2 != 0) {
                if (c == myRoot) myRoot = c.myNext;
                else p.myNext = c.myNext;
            } else p = c;
            c = c.myNext;
        }
    }
}