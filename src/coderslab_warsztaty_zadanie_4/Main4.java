package coderslab_warsztaty_zadanie_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        String str = getThrow();
        String cubeTypeSize = "3,4,6,8,10,12,20,100";
        String[] strThrow = str.toLowerCase().split("d");
        int countThrow = 1;
        int modifier = 0;
        int cubeType = 0;
        try {
            if (!"".equals(strThrow[0]))
                countThrow = Integer.parseInt(strThrow[0]);
            String[] strCube = strThrow[1].split("\\+|-");
            cubeType = Integer.valueOf(strCube[0]);
            if (strThrow[1].contains("-") && strCube.length > 1)
                modifier = Integer.valueOf(strCube[1]) * (-1);
            if (strThrow[1].contains("\\+") && strCube.length > 1)
                modifier = Integer.valueOf(strCube[1]);
            if (cubeTypeSize.contains(strCube[0]))
                throwCube(cubeType, countThrow, modifier);
            else
                System.out.println("Podano złe wymiary kostki.");
        } catch (NumberFormatException e) {
            System.out.println("Podano zła warość");
        }

    }

    static void throwCube(int size, int countThrows, int modifier) {
        int result = 0;
        Random r = new Random();
        for (int i = 0; i < countThrows; i++) {
            result += (r.nextInt(size) + 1);
        }
        result += modifier;
        if (result < 0)
            System.out.println("Wynik: 0");
        else
            System.out.println("Wynik: " + result);
    }

    static String getThrow() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        return str;
    }

}
