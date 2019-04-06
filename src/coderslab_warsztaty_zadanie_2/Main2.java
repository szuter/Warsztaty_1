package coderslab_warsztaty_zadanie_2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        int[] userNumbers = getUserNumbers();
        int[] rngNumbers = getRngNumbers();
        Arrays.sort(userNumbers);
        System.out.println("");
        System.out.println("Liczby wybrane przez urzytkownika: ");
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.print(userNumbers[i] + " ");
        }
        System.out.println("");
        System.out.println("Liczby wylosowane: ");
        Arrays.sort(rngNumbers);
        for (int i = 0; i < rngNumbers.length; i++) {
            System.out.print(rngNumbers[i] + " ");
        }
        System.out.println("");

        int count = match(userNumbers, rngNumbers);
        if (count >= 3)
            System.out.println("Liczba trafien: " + count);
        else
            System.out.println("Brak wygranej.");
    }

    static int match(int[] userNumbers, int[] rngNumbers) {
        int count = 0;
        Arrays.sort(userNumbers);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (userNumbers[i] == rngNumbers[j])
                    count++;
            }
        }
        return count;
    }

    static int[] getUserNumbers() {
        int[] userNumbers = new int[6];
        int count = 0;
        int tempNum = 0;
        while (count < 6) {
            tempNum = getNumber();
            if (noRepeat(tempNum, userNumbers)) {
                userNumbers[count] = tempNum;
                count++;
            } else
                System.out.println("Podano juz tą liczbe.");
        }
        return userNumbers;
    }

    static int[] getRngNumbers() {
        Random r = new Random();
        int[] rngNumbers = new int[6];
        int count = 0;
        int tempNum = 0;
        while (count < 6) {
            tempNum = r.nextInt(49) + 1;
            if (noRepeat(tempNum, rngNumbers)) {
                rngNumbers[count] = tempNum;
                count++;
            }
        }
        return rngNumbers;
    }

    static boolean noRepeat(int number, int[] numTab) {
        for (int i = 0; i < numTab.length; i++) {
            if (number == numTab[i])
                return false;
        }
        return true;
    }

    static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int temp = 0;
        System.out.println("Podaj liczbe od 1 do 49");
        while (!((temp > 0) && (temp < 50))) {
            try {
                temp = scanner.nextInt();
                if (!((temp > 0) && (temp < 50)))
                    System.out.println("Błędny zakres. Podaj jeszcze raz.");
            } catch (InputMismatchException e) {
                System.out.println("Błędna warość. Podaj jeszcze raz.");
                scanner.nextLine();
            }
        }
        return temp;
    }
}
