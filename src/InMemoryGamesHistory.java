import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InMemoryGamesHistory implements GamesHistory{

    private ArrayList<GamePlayed> history;
    private Stack<GamePlayed> redoGameStack;

    public InMemoryGamesHistory() {
        history = new ArrayList<>();
        redoGameStack = new Stack<>();
    }

    @Override
    public void addGameStats(GamePlayed gamePlayed) {
        this.history.add(gamePlayed);
    }

    @Override
    public void redo() {
        if (this.redoGameStack.isEmpty()){
            return;
        }

        this.history.add(this.redoGameStack.pop());
    }

    @Override
    public void undo() {
        if (this.history.isEmpty()){
            return;
        }

        var removedItem = this.history.remove(getLastHistoryIndex());
        this.redoGameStack.push(removedItem);
    }

    @Override
    public List<GamePlayed> getHistory() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public GamePlayed getCurrentGame() {
        if (this.history.isEmpty()){
            return null;
        }

        return this.history.get(getLastHistoryIndex());
    }

    private int getLastHistoryIndex() {
        return this.history.size() -1;
    }

    public int getTotalHits(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getHits();
        }
        return total;
    }

    public int getTotalPlateAppearances(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getPlateAppearances();
        }
        return total;
    }

    public int getTotalSingles(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getSingles();
        }
        return total;
    }

    public int getTotalDoubles(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getDoubles();
        }
        return total;
    }

    public int getTotalTriples(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getTriples();
        }
        return total;
    }

    public int getTotalHomers(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getHomers();
        }
        return total;
    }

    public int getTotalRunsScored(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getRunsScored();
        }
        return total;
    }

    public int getTotalRBIs(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getRBIs();
        }
        return total;
    }

    public int getTotalWalks(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getWalks();
        }
        return total;
    }

    public int getTotalStrikeouts(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getStrikeouts();
        }
        return total;
    }

    public int getTotalHBPs(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getTimesHitByPitch();
        }
        return total;
    }

    public int getTotalSacs(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getSacrifices();
        }
        return total;
    }

    // get the total number of "total bases"
    public int getTotalTotalBases(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getTotalBases();
        }
        return total;
    }

    public int getTotalAtBatsNotPAs(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getAtBatsNotPA();
        }
        return total;
    }

    public int getTotalTimesOnBase(){
        int total=0;
        for (GamePlayed aHistory : history) {
            total+=aHistory.getTimesOnBase();
        }
        return total;
    }

    public String getOverallBattingAverage(){
        return String.format("%.3f",StatCalc.AVGCalc(getTotalHits(), getTotalAtBatsNotPAs()));
    }

    public String getOverallSluggingPercentage(){
        return String.format("%.3f",StatCalc.SLGCalc(getTotalTotalBases(), getTotalAtBatsNotPAs()));
    }

    public String getOverallOnBasePercentage(){
        return String.format("%.3f",StatCalc.OBPCalc(getTotalTimesOnBase(), getTotalPlateAppearances()));
    }

    public String getOverallOnBasePlusSlugging(){
        return String.format("%.3f",StatCalc.OPSCalc(getTotalTimesOnBase(), getTotalTotalBases(), getTotalAtBatsNotPAs(), getTotalPlateAppearances()));
    }
}
