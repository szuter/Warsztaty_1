package coderslab_warsztaty_zadanie_3;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Pomyśl liczbe od 1 do 1000");
        int  min = 1,max = 1000;
        Scanner scanner = new Scanner(System.in);
        int temp = 0;
        String guessTemp = "";
        while (true) {
            temp = guess(min, max);
            System.out.println("Zgaduje: " + temp);
            guessTemp = scanner.nextLine();

            if ("za malo".equals(guessTemp)) {
                min = temp;
            } else if ("za duzo".equals(guessTemp)) {
                max = temp;
            } else if ("zgadles".equals(guessTemp)) {
                break;
            } else
                System.out.println("Nie oszukuj");
        }


    }
    static int guess(int min,int max){
        if (min==999 && max ==1000)
            return 1000;
        return  ((max - min)/2)+min;
    }
}
