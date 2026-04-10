import java.util.function.*;
class Main {
    public static void main(String[] args) {
        Function<Integer, Integer>[] funcs = new Function[]{
            n->(int)n*2,
            n->(int)Math.pow((int)n, 2)
        };
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int n : nums) {
            for (Function<Integer, Integer> func : funcs)
                System.out.print(func.apply(n)+"\t");
            System.out.println();
        }
    }
}
