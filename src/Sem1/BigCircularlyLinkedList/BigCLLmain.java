package Sem1.BigCircularlyLinkedList;

public class BigCLLmain {
    public static void main(String[] args) {
        myCLL<Integer> ll = new myCLL<>();

        for (int i = 0; i < 10; i++) ll.addfront(i);
        System.out.print("addfront/initial list: "); ll.printList();

        for (int i = 10; i < 15; i++) ll.addlast(i);
        System.out.print("addlast: "); ll.printList();

        ll.add(99, 5);
        System.out.print("add(99,5): "); ll.printList();

        System.out.println("getCount: " + ll.getCount());

        System.out.println("isEmpty: " + ll.isEmpty());

        System.out.println("isThere(7): " + ll.isThere(7));

        System.out.println("getFirst: " + ll.getFirst());

        System.out.println("getLast: " + ll.getLast());

        System.out.println("getSpot(3): " + ll.getSpot(3));

        ll.removeFirst();
        System.out.print("removeFirst: "); ll.printList();

        ll.removeLast();
        System.out.print("removeLast: "); ll.printList();

        System.out.println("countLess10: " + ll.countLess10());

        ll.removeSpot(4);
        System.out.print("removeSpot(4): "); ll.printList();

        System.out.println("checkForNum(99): " + ll.checkForNum(99));

        System.out.println("getNum(2): " + ll.getNum(2));

        myCLL<Integer> rev = ll.getReverse();
        System.out.print("getReverse: "); rev.printList();

        System.out.print("iterator: "); for (int n : ll) System.out.print(n + " "); System.out.println();

        System.out.println("avg: " + ll.avg());

        System.out.println("min: " + ll.min());

        System.out.println("max: " + ll.max());

        System.out.println("findSlotMaxFirst: " + ll.findSlotMaxFirst());

        System.out.println("findSlotMaxLast: " + ll.findSlotMaxLast());

        ll.sort();
        System.out.print("sort: "); ll.printList();

        ll.addlast(58); ll.addlast(58); ll.addlast(20);
        System.out.println("lose58: " + ll.lose58());
        System.out.print("list after lose58: "); ll.printList();

        System.out.println("getEvenCount: " + ll.getEvenCount());

        ll.killOdds();
        System.out.print("killOdds: "); ll.printList();

        ll.clear();
        System.out.print("clear: "); ll.printList();
        System.out.println("isEmpty after clear: " + ll.isEmpty());
    }
}

/*
addfront/initial list: 9 8 7 6 5 4 3 2 1 0
addlast: 9 8 7 6 5 4 3 2 1 0 10 11 12 13 14
add(99,5): 9 8 7 6 5 99 4 3 2 1 0 10 11 12 13 14
getCount: 16
isEmpty: false
isThere(7): true
getFirst: 9
getLast: 14
getSpot(3): 6
removeFirst: 8 7 6 5 99 4 3 2 1 0 10 11 12 13 14
removeLast: 8 7 6 5 99 4 3 2 1 0 10 11 12 13
countLess10: 9
removeSpot(4): 8 7 6 5 4 3 2 1 0 10 11 12 13
checkForNum(99): false
getNum(2): 6
getReverse: 13 12 11 10 0 1 2 3 4 5 6 7 8
iterator: 8 7 6 5 4 3 2 1 0 10 11 12 13
avg: 6.3076923076923075
min: 0
max: 13
findSlotMaxFirst: 12
findSlotMaxLast: 12
sort: 0 1 2 3 4 5 6 7 8 10 11 12 13
lose58: 2
list after lose58: 0 1 2 3 4 5 6 7 8 10 11 12 13 20
getEvenCount: 8
killOdds: 0 2 4 6 8 10 12 20
clear: isEmpty after clear: true

Process finished with exit code 0
 */

