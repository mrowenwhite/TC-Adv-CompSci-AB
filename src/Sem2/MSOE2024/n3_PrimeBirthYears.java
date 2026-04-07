package Sem2.MSOE2024;
import java.util.Scanner;
import java.util.stream.IntStream;
public class n3_PrimeBirthYears {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter years of birth:");
        System.out.println(Math.toIntExact(IntStream.range(sc.nextInt(), sc.nextInt()).filter(n ->((n > 1) && (IntStream.range(2, n).noneMatch(i -> n % i == 0)))).count()) + " gifts");
    }
}
