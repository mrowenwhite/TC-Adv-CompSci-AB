package BigLinkedList;

import java.io.*;

public class BigLLmain {
    public static void main(String[] args) throws IOException {
        int[] myRandNums = new int[200];
        for  (int i = 0; i < 200; i++)
            myRandNums[i] = (int)(Math.random()*100);

        HomeMadeLinkedList<Node<Integer>> LL = new HomeMadeLinkedList<>();
        for (int i=0;i<myRandNums.length;i++)LL.addFront(new Node(myRandNums[i]));
        while (LL.myNext!=null) {
            System.out.println(LL.myNext);
            LL.myNext=LL.myNext;
        }
    }
}
