public class FifaStatsDemo {
    public static void main(String[] args) {
        // Create MatchStats object
        MatchStats stats = new MatchStats();

        // Load the dataset (ensure file is in the A3 folder)
        String filename = "A3/src/fifa-world-cup-2022-UTC.txt";
        stats.loadData(filename);

        System.out.println("\n============================");
        System.out.println(" FIFA WORLD CUP 2022 STATS ");
        System.out.println("============================\n");

        //List all teams in a given group
        stats.displayTeams("Group F");
        System.out.println();

        //Number of matches played by a team
        String team = "Brazil";
        System.out.println("Number of matches played by " + team + ": " + stats.numMatches(team));
        System.out.println();

        //Team with highest total goals
        System.out.println("Team with highest total goals:");
        stats.highestTotalGoals();
        System.out.println();

        //Team with lowest total goals
        System.out.println("Team with lowest total goals:");
        stats.lowestTotalGoals();
        System.out.println();

        //All matches played at a given stadium
        stats.matchesPlayedAt("Lusail Stadium");
        System.out.println();

        //All matches played on a given date
        stats.matchesPlayedOn("18/12/2022");
        System.out.println();

        //All matches played by a given team
        stats.matchesPlayedBy("Morocco");
        System.out.println();

        //Teams ranked by performance
        System.out.println("Teams ranked by performance (most wins to least wins):");
        stats.displayTeamsTopDown();

        System.out.println("\n=== End of Report ===");
    }
}
