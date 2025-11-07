public class MatchRecord {
    private String roundNumber;
    private String dateTime;
    private String location;
    private String homeTeam;
    private String awayTeam;
    private String group;
    private String homeGoals;
    private String awayGoals;

    public MatchRecord(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
        this.roundNumber = var1;
        this.dateTime = var2;
        this.location = var3;
        this.homeTeam = var4;
        this.awayTeam = var5;
        this.group = var6;
        this.homeGoals = var7;
        this.awayGoals = var8;
    }

    public String getRoundNumber() {
        return this.roundNumber;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getLocation() {
        return this.location;
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public String getAwayTeam() {
        return this.awayTeam;
    }

    public String getGroup() {
        return this.group;
    }

    public String getHomeGoals() {
        return this.homeGoals;
    }

    public String getAwayGoals() {
        return this.awayGoals;
    }

    public String toString() {
        return String.format("%s %s-%s %s (%s, %s, %s)", this.homeTeam, this.homeGoals, this.awayGoals, this.awayTeam, this.roundNumber, this.location, this.dateTime);
    }
}