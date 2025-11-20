package Sem1.BigCircularlyLinkedList;

import java.util.*;

public class myCLL<T extends Number & Comparable<T>> implements Iterable<T> {

    private class Node<T> {
        private T data;
        public Node<T> myNext;
        public Node(T data) { this.data = data; }
        public T getData() { return data; }
        @Override
        public String toString() { return String.valueOf(data); }
    }

    private Node<T> myRoot;

    private Node<T> getLastNode() {
        if (myRoot == null) return null;
        Node<T> c = myRoot;
        while (c.myNext != myRoot) c = c.myNext;
        return c;
    }

    public boolean addfront(T n) {
        Node<T> t = new Node<>(n);
        if (myRoot == null) {
            myRoot = t;
            t.myNext = myRoot;
        } else {
            Node<T> last = getLastNode();
            last = last.myNext;
            last.myNext = myRoot;

        }
        return true;
    }

    public boolean addlast(T n) {
        Node<T> t = new Node<>(n);
        if (myRoot == null) {
            myRoot = t;
            t.myNext = myRoot;
        } else {
            Node<T> last = getLastNode();
            last.myNext = t;
            t.myNext = myRoot;
        }
        return true;
    }

    public void printList() {
        if (myRoot == null) return;
        Node<T> c = myRoot;
        do {
            System.out.print(c.getData() + " ");
            c = c.myNext;
        } while (c != myRoot);
        System.out.println();
    }

    public int getCount() {
        if (myRoot == null) return 0;
        int cnt = 0;
        Node<T> c = myRoot;
        do { cnt++; c = c.myNext; } while (c != myRoot);
        return cnt;
    }

    public boolean add(T num, int spot) {
        int count = getCount();
        if (spot < 0 || spot > count) return false;
        if (spot == 0) return addfront(num);
        if (spot == count) return addlast(num);

        Node<T> c = myRoot;
        for (int i = 0; i < spot - 1; i++) c = c.myNext;
        Node<T> n = new Node<>(num);
        n.myNext = c.myNext;
        c.myNext = n;
        return true;
    }

    public boolean isEmpty() { return myRoot == null; }

    public boolean isThere(T n) {
        if (myRoot == null) return false;
        Node<T> c = myRoot;
        do {
            if (c.getData().equals(n)) return true;
            c = c.myNext;
        } while (c != myRoot);
        return false;
    }

    public boolean checkForNum(T n) { return isThere(n); }

    public T getFirst() { return myRoot == null ? null : myRoot.getData(); }

    public T getLast() {
        Node<T> last = getLastNode();
        return last == null ? null : last.getData();
    }

    public T getSpot(int spot) {
        if (spot < 0 || spot >= getCount()) return null;
        Node<T> c = myRoot;
        for (int i = 0; i < spot; i++) c = c.myNext;
        return c.getData();
    }

    public T getNum(int pos) { return getSpot(pos); }

    public void removeFirst() {
        if (myRoot == null) return;
        if (myRoot.myNext == myRoot) { myRoot = null; return; }
        Node<T> last = getLastNode();
        myRoot = myRoot.myNext;
        last.myNext = myRoot;
    }

    public void removeLast() {
        if (myRoot == null) return;
        if (myRoot.myNext == myRoot) { myRoot = null; return; }
        Node<T> c = myRoot;
        while (c.myNext.myNext != myRoot) c = c.myNext;
        c.myNext = myRoot;
    }

    public int countLess10() {
        if (myRoot == null) return 0;
        int cnt = 0;
        Node<T> c = myRoot;
        do {
            if (c.getData().intValue() < 10) cnt++;
            c = c.myNext;
        } while (c != myRoot);
        return cnt;
    }

    public void removeSpot(int pos) {
        int count = getCount();
        if (pos < 0 || pos >= count) return;
        if (pos == 0) { removeFirst(); return; }
        Node<T> c = myRoot;
        for (int i = 0; i < pos - 1; i++) c = c.myNext;
        c.myNext = c.myNext.myNext;
        getLastNode().myNext = myRoot;
    }

    public void clear() { myRoot = null; }

    public myCLL<T> getReverse() {
        myCLL<T> r = new myCLL<>();
        if (myRoot == null) return r;
        Node<T> c = myRoot;
        do {
            r.addfront(c.getData());
            c = c.myNext;
        } while (c != myRoot);
        return r;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> c = myRoot;
            boolean started = false;
            public boolean hasNext() { return c != null && (!started || c != myRoot); }
            public T next() { started = true; T v = c.getData(); c = c.myNext; return v; }
        };
    }

    public double avg() {
        if (myRoot == null) return 0;
        int n = 0; double s = 0;
        Node<T> c = myRoot;
        do { s += c.getData().doubleValue(); n++; c = c.myNext; } while (c != myRoot);
        return s / n;
    }

    public T min() {
        if (myRoot == null) return null;
        T m = myRoot.getData();
        Node<T> c = myRoot.myNext;
        while (c != myRoot) { if (c.getData().compareTo(m) < 0) m = c.getData(); c = c.myNext; }
        return m;
    }

    public T max() {
        if (myRoot == null) return null;
        T m = myRoot.getData();
        Node<T> c = myRoot.myNext;
        while (c != myRoot) { if (c.getData().compareTo(m) > 0) m = c.getData(); c = c.myNext; }
        return m;
    }

    public int findSlotMaxFirst() {
        if (myRoot == null) return -1;
        T mx = max(); int i = 0;
        Node<T> c = myRoot;
        do { if (c.getData().equals(mx)) return i; i++; c = c.myNext; } while (c != myRoot);
        return -1;
    }

    public int findSlotMaxLast() {
        if (myRoot == null) return -1;
        T mx = max(); int i = 0, f = -1;
        Node<T> c = myRoot;
        do { if (c.getData().equals(mx)) f = i; i++; c = c.myNext; } while (c != myRoot);
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
        if (myRoot == null) return 0;
        int cnt = 0; Node<T> c = myRoot, p = getLastNode();
        do {
            if (c.getData().intValue() == 58) {
                cnt++;
                if (c == myRoot) { myRoot = c.myNext; p.myNext = myRoot; }
                else p.myNext = c.myNext;
            } else p = c;
            c = c.myNext;
        } while (c != myRoot);
        return cnt;
    }

    public int getEvenCount() {
        if (myRoot == null) return 0;
        int cnt = 0; Node<T> c = myRoot;
        do { if (c.getData().intValue() % 2 == 0) cnt++; c = c.myNext; } while (c != myRoot);
        return cnt;
    }

    public void killOdds() {
        if (myRoot == null) return;
        Node<T> c = myRoot, p = getLastNode();
        do {
            if (c.getData().intValue() % 2 != 0) {
                if (c == myRoot) { myRoot = c.myNext; p.myNext = myRoot; }
                else p.myNext = c.myNext;
            } else p = c;
            c = c.myNext;
        } while (c != myRoot);
    }
}
