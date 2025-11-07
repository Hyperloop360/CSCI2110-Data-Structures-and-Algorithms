public class MatchRecord {
   private String roundNumber;
   private String dateTime;
   private String location;
   private String homeTeam;
   private String awayTeam;
   private String group;
   private String homeGoals;
   private String awayGoals;

   public MatchRecord(String roundNumber, String dateTime, String location, String homeTeam, 
                      String awayTeam, String group, String homeGoals, String awayGoals) {
    this.roundNumber = roundNumber;
    this.dateTime = dateTime;
    this.location = location;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.group = group;
    this.homeGoals = homeGoals;
    this.awayGoals = awayGoals;
   }

   public String getRoundNumber(){return roundNumber;}
   public String getDateTime(){return dateTime;}
   public String getLocation(){return location;}
   public String getHomeTeam(){return homeTeam;}
   public String getAwayTeam(){return awayTeam;}
   public String getGroup(){return group;}
   public String getHomeGoals(){return homeGoals;}
   public String getAwayGoals(){return awayGoals;}

  @Override
  public String toString(){
    return String.format("%s %s-%s %s (%s, %s, %s)", homeTeam, homeGoals, awayGoals, awayTeam, roundNumber, location, dateTime);
  }
}
