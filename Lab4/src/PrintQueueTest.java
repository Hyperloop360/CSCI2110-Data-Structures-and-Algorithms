/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;

public class PrintQueueTest {
    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("   ADD owner jobId");
        System.out.println("   LIST");
        System.out.println("   RM jobId");
        System.out.println("   RMALL owner");
        System.out.println("   HELP");
        System.out.println("   QUIT");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintQueue pq = new PrintQueue();
        System.out.println("Print Queue Demo (type HELP for commands)");
        printHelp();

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();

            if (line.equals("QUIT")) break;

            String[] tokens = line.split(" ");
            String command = tokens[0].toUpperCase();

            switch (command) {
                case "ADD":
                    if (tokens.length >= 3) {
                        String owner = tokens[1];
                        try {
                            int jobId = Integer.parseInt(tokens[2]);
                            pq.lpr(owner, jobId);
                            System.out.println("Added job " + jobId + " by " + owner);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: jobId must be an integer");
                        }
                    } else {
                        System.out.println("Error: ADD command requires owner and jobId");
                    }
                    break;

                case "LIST":
                    pq.lpq();
                    break;

                case "RM":
                    if (tokens.length >= 2) {
                        try {
                            int jobId = Integer.parseInt(tokens[1]);
                            pq.lprm(jobId);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: jobId must be an integer");
                        }
                    } else {
                        System.out.println("Error: RM command requires jobId");
                    }
                    break;

                case "RMALL":
                    if (tokens.length >= 2) {
                        String owner = tokens[1];
                        pq.lprmAll(owner);
                    } else {
                        System.out.println("Error: RMALL command requires owner");
                    }
                    break;

                case "HELP":
                    printHelp();
                    break;

                default:
                    System.out.println("Unknown command. Type HELP for available commands.");
                    break;
            }
        }

        System.out.println("BYE");
    }
}