package Sem2.MSOE2024;

public class n4_HappyAlphabeticalAnts {
    public static void main(String[] args) {
        int count = 0, greatestCount = 0;
        String s1 = "  my milkshake brings all the boys to the yard, abcef abcde fg abfghtnz abaccusasm";
        s1 = s1.toLowerCase().strip().replaceAll(" ", "").replaceAll(",", "");
        for(int i = 0; i < s1.length()-1; i++){
            char ch1 = s1.charAt(i), ch2 = s1.charAt(i+1);
            if (ch2>=ch1) {count++;greatestCount = Math.max(count, greatestCount);}
            else count = 0;
        }
        System.out.println(greatestCount);
    }
}
