public class StatCalculator {
    private final GamesHistory gamesHistory;

    public StatCalculator(GamesHistory gamesHistory) {
        this.gamesHistory = gamesHistory;
    }

    public void addGame(int plateAppearances, int singles, int doubles, int triples, int homers,
                        int runsScored, int RBIs, int walks, int strikeouts, int timesHitByPitch, int sacrifices){
            var gamePlayed = new GamePlayed(plateAppearances, singles, doubles, triples, homers,
                    runsScored, RBIs, walks, strikeouts, timesHitByPitch, sacrifices);

        gamesHistory.addGameStats(gamePlayed);
    }

    public float getBattingAverage(){
        return StatCalc.AVGCalc(gamesHistory.getTotalHits(), gamesHistory.getTotalAtBatsNotPAs());
    }

    public float getSluggingPercentage(){
        return StatCalc.SLGCalc(gamesHistory.getTotalTotalBases(), gamesHistory.getTotalAtBatsNotPAs());
    }

    public float getOnbasePlusSlugging(){
        return StatCalc.OPSCalc(gamesHistory.getTotalTimesOnBase(), gamesHistory.getTotalTotalBases(), gamesHistory.getTotalAtBatsNotPAs(),gamesHistory.getTotalPlateAppearances());
    }

    /*
    //this is a sample of the methods in the InMemoryGamesHistory class. if methods would be here,
    // they would need the line which pulls the total history down each time.
    public int getTotalHits(){
        int hits =0;
        var allGamesPlayed = gamesHistory.getHistory();
        for (GamePlayed anAllGamesPlayed : allGamesPlayed) {
            hits += anAllGamesPlayed.getHits();
        }
        return hits;
    }*/


}
