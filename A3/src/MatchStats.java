import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatchStats {
    private List<MatchRecord> matchList;

    //Constructor
    public MatchStats() {
        matchList = new List<>();
    }

    // Loads match data from the given filename
    public void loadData(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {

            // Skip the header line
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

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

                String matchNo = tokens[0].trim();
                String round = tokens[1].trim();
                String dateTime = tokens[2].trim();
                String location = tokens[3].trim();
                String homeTeam = tokens[4].trim();
                String awayTeam = tokens[5].trim();
                String group = tokens[6].isEmpty() ? "-" : tokens[6].trim();
                String result = tokens[7].trim();

                // Clean and normalize result
                result = result.replaceAll("[^0-9–—\\- ]", "");
                result = result.replaceAll("[–—]", "-");
                String[] goals = result.split("\\s*-\\s*");

                String homeGoals = "0";
                String awayGoals = "0";
                if (goals.length == 2) {
                    homeGoals = goals[0].trim();
                    awayGoals = goals[1].trim();
                }

                MatchRecord record = new MatchRecord(
                        round, dateTime, location, homeTeam, awayTeam, group, homeGoals, awayGoals
                );

                matchList.add(record);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please ensure " + filename + " is in the correct folder.");
        }
    }



    //List all the teams in a given group;
    public void displayTeams(String group) {
        List<String> teams = new List<>();

        MatchRecord current = matchList.first();
        while (current != null) {
            if (current.getGroup().equalsIgnoreCase(group)) {
                if (!teams.contains(current.getHomeTeam()))
                    teams.add(current.getHomeTeam());
                if (!teams.contains(current.getAwayTeam()))
                    teams.add(current.getAwayTeam());
            }
            current = matchList.next();
        }
        String t = teams.first();
        while (t != null) {
            System.out.print(t);
            t = teams.next();
            if (t != null) System.out.print(", ");
        }
        System.out.println();
    }

    // Number of matched played by a team
    public int numMatches(String team) {
        int count = 0;
        MatchRecord current = matchList.first();
        while (current != null) {
            if (current.getHomeTeam().equalsIgnoreCase(team) ||
                    current.getAwayTeam().equalsIgnoreCase(team)) {
                count++;
            }
            current = matchList.next();
        }
        return count;
    }

    //Team with the highest total goals scored
    public void highestTotalGoals() {
        List<String> teams = getAllTeams();
        String topTeam = "";
        int maxGoals = -1;

        String t = teams.first();
        while (t != null) {
            int total = totalGoalsFor(t);
            if (total > maxGoals) {
                maxGoals = total;
                topTeam = t;
            }
            t = teams.next();
        }
        System.out.println("Team with highest total goals: " + topTeam + " (" + maxGoals + ")");
    }

    //team with the lowest total goals scored
    public void lowestTotalGoals() {
        List<String> teams = getAllTeams();
        String bottomTeam = "";
        int minGoals = Integer.MAX_VALUE;

        String t = teams.first();
        while (t != null) {
            int total = totalGoalsFor(t);
            if (total < minGoals) {
                minGoals = total;
                bottomTeam = t;
            }
            t = teams.next();
        }

        System.out.println("Team with lowest total goals: " + bottomTeam + " (" + minGoals + ")");
    }

    //All matches played at a given stadium
    public void matchesPlayedAt(String stadiumName) {
        System.out.println("Matches played at " + stadiumName + ":");
        MatchRecord current = matchList.first();
        while (current != null) {
            if (current.getLocation().equalsIgnoreCase(stadiumName))
                System.out.println(current);
            current = matchList.next();
        }
    }

    //All matches played on a given date
    public void matchesPlayedOn(String date) {
        System.out.println("Matches played on " + date + ":");
        MatchRecord current = matchList.first();
        while (current != null) {
            if (current.getDateTime().startsWith(date))
                System.out.println(current);
            current = matchList.next();
        }
    }

    //All matches played by a given team(with results)
    public void matchesPlayedBy(String teamName) {
        System.out.println("Matches played by " + teamName + ":");
        MatchRecord current = matchList.first();
        while (current != null) {
            if (current.getHomeTeam().equalsIgnoreCase(teamName) ||
                    current.getAwayTeam().equalsIgnoreCase(teamName)) {
                System.out.println(current);
            }
            current = matchList.next();
        }
    }

    //Teams ranked by performance (most wins to least wins)
    public void displayTeamsTopDown() {
        List<String> teams = getAllTeams();
        List<String> printed = new List<>();

        System.out.println("Teams ranked by performance (most wins to least wins):");
        for (int rank = 1; rank <= teams.size(); rank++) {
            String bestTeam = "";
            int bestWins = -1;

            String t = teams.first();
            while (t != null) {
                if (!printed.contains(t)) {
                    int wins = countWins(t);
                    if (wins > bestWins) {
                        bestWins = wins;
                        bestTeam = t;
                    }
                }
                t = teams.next();
            }

            if (!bestTeam.isEmpty()) {
                System.out.println(rank + ". " + bestTeam + " (" + bestWins + " wins)");
                printed.add(bestTeam);
            }
        }
    }

    /* ---------------- Helper Methods ---------------- */

    private int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    // Returns a List<String> of all unique team names
    private List<String> getAllTeams() {
        List<String> teams = new List<>();
        MatchRecord current = matchList.first();
        while (current != null) {
            if (!teams.contains(current.getHomeTeam()))
                teams.add(current.getHomeTeam());
            if (!teams.contains(current.getAwayTeam()))
                teams.add(current.getAwayTeam());
            current = matchList.next();
        }
        return teams;
    }

    // Returns total goals scored by the given team
    private int totalGoalsFor(String team) {
        int total = 0;
        MatchRecord current = matchList.first();
        while (current != null) {
            if (current.getHomeTeam().equalsIgnoreCase(team))
                total += parseIntSafe(current.getHomeGoals());
            else if (current.getAwayTeam().equalsIgnoreCase(team))
                total += parseIntSafe(current.getAwayGoals());
            current = matchList.next();
        }
        return total;
    }

    //Counts wins for a given team
    private int countWins(String team) {
        int wins = 0;
        MatchRecord current = matchList.first();
        while (current != null) {
            int homeGoals = parseIntSafe(current.getHomeGoals());
            int awayGoals = parseIntSafe(current.getAwayGoals());

            if (current.getHomeTeam().equalsIgnoreCase(team) && homeGoals > awayGoals)
                wins++;
            else if (current.getAwayTeam().equalsIgnoreCase(team) && awayGoals > homeGoals)
                wins++;

            current = matchList.next();
        }
        return wins;
    }
}