package Sem1;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Prog88aBigInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next()), m = new BigInteger(12, new Random());
        Integer sum = n.add(m).intValue(),diff = n.subtract(m).intValue(),product = n.multiply(m).intValue(), distance = Math.abs(n.subtract(m).intValue()), max = (n.intValue()>m.intValue()) ? n.intValue() : m.intValue();
        Double avg = (n.doubleValue()+m.doubleValue())/2;
        System.out.printf("Sum:\t%d\nDifference:\t%d\nProduct:\t%d\nAverage:\t%.2f\nDistance:\t%d\nMax:\t%d", sum, diff, product, avg, distance, max);


    }
}
/*
12
Sum:	3195
Difference:	-3171
Product:	38196
Average:	1597.50
Distance:	3171
Max:	3183
Process finished with exit code 0
 */
