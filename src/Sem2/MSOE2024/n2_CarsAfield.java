package Sem2.MSOE2024;

public class n2_CarsAfield {
    public static void main(String[] args) {
        String testString = "__ooo__o.o___O.O___O.o___";
        int count = 0;
        for (int i = 0; i < testString.length()-2; i++)
            count = ((testString.charAt(i)==testString.charAt(i+2)&&((testString.charAt(i)=='o'||testString.charAt(i)=='O')))&&(!(testString.charAt(i+1)=='o')||(testString.charAt(i+1)=='O'))) ? count+1 : count;
        System.out.printf(testString + "\n%d", count);


    }
}