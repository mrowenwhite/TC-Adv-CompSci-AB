package Q1.Langdocs;
import java.util.Scanner;

public class Prog335e {
    static int[] arr = new int[100];

    public static int Location(int n) {
        for (int lcv=0;lcv<arr.length;++lcv)
            if (arr[lcv] == n)
                return lcv;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int lcv=0;lcv<100;++lcv) {
            arr[lcv] = (int)(Math.random()*1000-1)+1;
            System.out.print(arr[lcv] + " ");
            if (lcv%10==0) System.out.println();
        }
        System.out.println("\n");

        System.out.print("Enter Number to Locate:" );int choice = sc.nextInt();
        if (Location(choice)==-1)
            System.out.printf("%d does not exist in the array\n", choice);
        else
            System.out.println(choice + " is located at position " + Location(choice));
    }


}
/*
320 66 74 11 158 97 673 890 816 674 616
776 888 370 807 350 64 791 564 126 772
86 381 406 684 33 198 341 357 340 52
967 788 925 229 596 946 47 610 969 398
344 719 114 997 21 77 967 232 665 901
405 225 413 807 508 580 498 171 540 236
519 13 349 227 126 800 641 806 204 358
834 667 44 146 35 140 455 544 995 62
216 397 766 719 813 34 207 681 925 136
394 568 681 347 442 787 361 270 291

Enter Number to Locate:361
361 is located at position 97

Process finished with exit code 0

 */