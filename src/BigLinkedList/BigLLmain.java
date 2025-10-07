package BigLinkedList;

import java.io.*;

public class BigLLmain {
    public static void main(String[] args) throws IOException {
        int[] myRandNums = new int[200];
        for (int i = 0; i < 200; i++)
            myRandNums[i] = (int) (Math.random() * 100);

        HomeMadeLinkedList<Integer> LL = new HomeMadeLinkedList<>();
        for (int rn : myRandNums) LL.addFront(new Node<Integer>());
        LL.addLast(new Node<Integer>(55));
        LL.printList();

    }
}
