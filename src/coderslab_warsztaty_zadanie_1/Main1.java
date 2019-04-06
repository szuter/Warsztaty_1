package coderslab_warsztaty_zadanie_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Random r = new Random();
        int result = r.nextInt(100) + 1;
        System.out.println("Zgadnij liczbe");
        Scanner scanner = new Scanner(System.in);
        int temp = 0;
        while (true) {
            try {
                temp = scanner.nextInt();
                if (result == temp)
                    break;
                else if (temp > result)
                    System.out.println("Za dużo");
                else
                    System.out.println("Za mało");
                System.out.println("Podaj liczbe");
            } catch (InputMismatchException e) {
                System.out.println("Bład!Podaj liczbe.");
                scanner.nextLine();
            }
        }
        System.out.println("Zgadłeś! Wynik: " + result);
    }
}

