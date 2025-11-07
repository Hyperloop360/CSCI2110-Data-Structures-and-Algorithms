import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadWorldCupData {
    public static void main(String[] args) {
        String filename = "A3/fifa-world-cup-2022-UTC.txt"; // make sure file is in same folder as program

        try (Scanner sc = new Scanner(new File(filename))) {
            // Skip the header line
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            System.out.printf("%-4s %-15s %-20s %-30s %-20s %-20s %-10s %-6s%n",
                    "#", "Round", "Date", "Location", "Home", "Away", "Group", "Result");
            System.out.println("-----------------------------------------------------------------------------------------------------------");

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                // Split by tab
                String[] tokens = line.split("\t");

                // Defensive check (some knockout rows may have an empty 'Group' field)
                if (tokens.length < 8) {
                    System.out.println("Skipped malformed line: " + line);
                    continue;
                }

                String matchNo = tokens[0];
                String round = tokens[1];
                String date = tokens[2];
                String location = tokens[3];
                String home = tokens[4];
                String away = tokens[5];
                String group = tokens[6].isEmpty() ? "-" : tokens[6];
                String result = tokens[7];

                System.out.printf("%-4s %-15s %-20s %-30s %-20s %-20s %-10s %-6s%n",
                        matchNo, round, date, location, home, away, group, result);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please ensure " + filename + " is in the correct folder.");
        }
    }
}

