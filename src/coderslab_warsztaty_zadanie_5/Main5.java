package coderslab_warsztaty_zadanie_5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            String tempText = "";
            String[] forbidenWords = {"jaki", "jaka", "jest", "żeby", "przed", "poza", "można", "oraz", "ponieważ"};

            Document document = connect.get();
            Elements links = document.select("span.title");
            PrintWriter writer = new PrintWriter("popular_words.txt");
            for (Element elem : links) {
                tempText = elem.text();
                String[] tempStrTab = tempText.split(" ");
                for (int i = 0; i < tempStrTab.length; i++) {
                    tempStrTab[i] = tempStrTab[i].replaceAll("\"|\\.|:|–|,|\\?|!|-|\\[|\\]|\\(|\\)", "");
                    if (tempStrTab[i].length() > 3)
                        writer.print(tempStrTab[i] + " ");
                    writer.flush();
                }
                writer.println("");
            }
            writer.close();
            File file = new File("popular_words.txt");
            Scanner scanner = new Scanner(file);
            PrintWriter filteredWriter = new PrintWriter("filtered_popular_words.txt");
            while (scanner.hasNextLine()) {
                tempText = scanner.nextLine();
                String[] tempStrTab = tempText.split(" ");
                for (int i = 0; i < tempStrTab.length; i++) {
                    for (int j = 0; j < forbidenWords.length; j++) {
                        if (tempStrTab[i].equalsIgnoreCase(forbidenWords[j]))
                            tempStrTab[i] = tempStrTab[i].toLowerCase().replaceAll(forbidenWords[j], "");
                    }
                    if (!"".equals(tempStrTab[i]))
                        filteredWriter.print(tempStrTab[i] + " ");
                    else
                        filteredWriter.print(tempStrTab[i]);
                }
                filteredWriter.println("");
                filteredWriter.flush();
            }
            filteredWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
