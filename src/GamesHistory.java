import java.util.List;

public interface GamesHistory {
    void addGameStats(GamePlayed gamePlayed);
    int getTotalHits();
    int getTotalPlateAppearances();
    int getTotalSingles();
    int getTotalDoubles();
    int getTotalTriples();
    int getTotalHomers();
    int getTotalRunsScored();
    int getTotalRBIs();
    int getTotalWalks();
    int getTotalStrikeouts();
    int getTotalHBPs();
    int getTotalSacs();
    int getTotalTotalBases();
    int getTotalTimesOnBase();
    // to distinguish plate appearances from at bats
    int getTotalAtBatsNotPAs();
    String getOverallBattingAverage();
    String getOverallSluggingPercentage();
    String getOverallOnBasePercentage();
    String getOverallOnBasePlusSlugging();
    void redo();
    void undo();
    List<GamePlayed> getHistory();
    GamePlayed getCurrentGame();
}